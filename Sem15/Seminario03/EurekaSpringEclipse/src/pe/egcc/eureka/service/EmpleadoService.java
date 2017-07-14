package pe.egcc.eureka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.model.Empleado;

@Service
public class EmpleadoService extends AbstractJdbcSupport{

	private final String SQL_SELECT = "select "
			+ "chr_emplcodigo     codigo, "
			+ "vch_emplpaterno    paterno, "
			+ "vch_emplmaterno    materno, "
			+ "vch_emplnombre     nombre, "
			+ "vch_emplciudad     ciudad, "
			+ "vch_empldireccion  direccion "
			+ "from empleado ";
	
	
	public Empleado validar(String usuario, String clave){
		Empleado bean = null;
		try {
			String sql = SQL_SELECT 
					+ "where chr_emplcodigo = ("
					+ "select chr_emplcodigo from usuario "
					+ "where vch_emplusuario = ? "
					+ "and vch_emplclave = SHA(?)) ";
			bean = jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<Empleado>(Empleado.class), 
					usuario, clave);
			
			
		} catch (EmptyResultDataAccessException e) {
		}
		return bean;
	}
	
	
	public Map<String, String> leerPermisos(String codEmp){
		
		Map<String, String> permisos = new HashMap<>();
		
		// Recupero la lista
		String sql = "select int_moducodigo cod, vch_permestado estado "
				+ "from permiso where chr_emplcodigo = ?";
		List<Map<String,Object>> lista = jdbcTemplate.queryForList(sql, codEmp);
		
		// Pasar la lista a un Map
		for (Map<String, Object> map : lista) {
			permisos.put(
					"op" + map.get("cod").toString(), 
					map.get("estado").toString());
		}
		
		return permisos;
	}
	
	
}
