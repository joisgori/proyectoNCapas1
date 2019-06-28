package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//public List<Usuario> findByNUsuario(String usuario);
	
	@Query(value = "select usuario.id_usuario,usuario.nombre_usuario, usuario.apellido_usuario, usuario.fecha_de_nacimiento, usuario.id_provincia=1, usuario.estado, usuario.user_login, usuario.password_login, usuario.user_type, usuario.saldo_cuenta, usuario.is_logged, usuario.direccion_de_residencia from usuario inner join provincia on usuario.id_provincia = provincia.id_provincia inner join estado on provincia.id_estado = estado.id_estado inner join pais on estado.id_pais = pais.id_pais where usuario.user_type =:user_type", nativeQuery = true)
	public List<Usuario> findByNUsuario(@Param("user_type") String user_type);
	
	//Método de búsqueda única
	public Usuario findByCUsuario(Integer id);
	
	public List<Usuario> findAll();
	
	public Usuario findByUserAndPass(String user, String pass);
	
	@Modifying(clearAutomatically = true)
	@Query (value = "update usuario set is_logged=:is_logged where id_usuario=:id_usuario", nativeQuery = true)
	public int updateUser(@Param("is_logged") Boolean is_logged, @Param("id_usuario") Integer id_usuario);
	
	@Modifying(clearAutomatically = true)
	@Query (value ="update usuario set estado=:estado, motivo=:motivo where id_usuario=:id_usuario", nativeQuery = true)
	public int inactivateUser(@Param("estado") Boolean estado, @Param("motivo") String motivo, @Param("id_usuario") Integer id_usuario);

}
