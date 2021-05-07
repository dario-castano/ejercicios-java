package com.heinsohn.semillero.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.heinsohn.semillero.dto.*;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuarioDTO, Integer> {
	
	@Query("SELECT x FROM UsuarioDTO x WHERE x.nombre = :nombre")
	Optional<UsuarioDTO> findUsuarioByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT x FROM UsuarioDTO x WHERE x.login = :login")
	Optional<UsuarioDTO> findUsuarioByLogin(@Param("login") String nombre);
}
