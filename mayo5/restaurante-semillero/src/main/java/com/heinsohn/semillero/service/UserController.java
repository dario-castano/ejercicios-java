package com.heinsohn.semillero.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heinsohn.semillero.dto.UsuarioDTO;
import com.heinsohn.semillero.repository.UsuariosRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuarios")
public class UserController {

	private UsuariosRepository uRepository;
	
	public UserController(UsuariosRepository uRepository) {
		this.uRepository = uRepository;
	}
	
	/**
	 * Retorna los datos de todos los usuarios
	 * 
	 * @return Lista de usuarios registrados en el sistema
	 */
	@ApiOperation(value = "Metodo que retorna los datos de los usuarios por medio del metodo HTTP.GET",
				  response = Integer.class, tags = "consultarUsuarios")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Exitoso, funcion!"),
		@ApiResponse(code = 401, message = "No autorizado, pilas!"),
		@ApiResponse(code = 403, message = "No tienes permiso!"),
		@ApiResponse(code = 404, message = "No se encontro lo que buscabas!")
	})
	@GetMapping
	public List<UsuarioDTO> getUsuario() {
		return (List<UsuarioDTO>) uRepository.findAll();
	}
	
	/**
	 * Retorna los datos de un usuario a través de su id
	 * @param id ID de usuario a obtener
	 * @return Usuario identificado con el id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable String id) {
		try {
			UsuarioDTO usuario = uRepository
					.findById(Integer.parseInt(id))
					.orElse(null);
			
			if (usuario != null) {
				return ResponseEntity.ok().body(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (NumberFormatException nfx) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	/**
	 * Metodo que permite registrar los datos de un usuario
	 * por medio del metodo HTTP.POST
	 * @param usuario Cuerpo de la petición HTTP
	 * @return Código de respuesta del servidor con ID de creación
	 */
	@PostMapping
	public ResponseEntity<Integer> crearUsuario(@RequestBody UsuarioDTO usuario) {
			UsuarioDTO usuarioExistente = uRepository
					.findUsuarioByLogin(usuario.getLogin())
					.orElse(null);
			
			if (usuarioExistente != null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
			UsuarioDTO usuarioGuardado = uRepository.save(usuario);
			
			if (usuarioGuardado.getId() > 0) {
				return ResponseEntity
						.ok()
						.body(Integer.valueOf(usuario.getId()));
			} else {
				return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.build();
			}
	}
	
	/**
	 * Metodo que permite actualizar los datos de un usuario
	 * por medio del metodo HTTP.PUT
	 * @param id ID del usuario a actualizar
	 * @param usuario Cuerpo de la petición HTTP
	 * @return Código de respuesta del servidor
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
		UsuarioDTO usuarioExistente = uRepository
				.findById(id)
				.orElse(null);
		
		if (usuarioExistente == null) {
			return ResponseEntity.notFound().build();
		}
		
		if (usuario.getLogin() != null) {usuarioExistente.setLogin(usuario.getLogin());}
		if (usuario.getNombre() != null) {usuarioExistente.setNombre(usuario.getNombre());}
		if (usuario.getPassword() != null) {usuarioExistente.setPassword(usuario.getPassword());}
		if (usuario.getEstado() != null) {usuarioExistente.setEstado(usuario.getEstado());}
		
		uRepository.save(usuarioExistente);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Este metodo permite eliminar la información
	 * de un usuario especifico
	 * @param id ID del usuario a eliminar
	 * @return Código de respuesta del servidor
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable Integer id) {
		UsuarioDTO usuario = uRepository
				.findById(id)
				.orElse(null);
		
		if (usuario != null) {
			uRepository.delete(usuario);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
