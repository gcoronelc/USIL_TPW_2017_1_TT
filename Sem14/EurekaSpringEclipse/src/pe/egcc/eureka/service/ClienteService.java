package pe.egcc.eureka.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import pe.egcc.eureka.model.Cliente;
import pe.egcc.eureka.model.Combo;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Service
public class ClienteService extends AbstractJdbcSupport {
	
	private final String SQL_SELECT = "select "
            + "chr_cliecodigo     codigo, "
            + "vch_cliepaterno    paterno, "
            + "vch_cliematerno    materno, "
            + "vch_clienombre     nombre, "
            + "chr_cliedni        dni, "
            + "vch_clieciudad     ciudad, "
            + "vch_cliedireccion  direccion, "
            + "vch_clietelefono   telefono, "
            + "vch_clieemail      email "
            + "from cliente ";

  public List<Cliente> getClientes(String criterio) {
    String sql = SQL_SELECT 
            + "where vch_cliepaterno like ? "
            + "or vch_cliematerno like ? "
            + "or vch_clienombre like ? ";
    criterio = "%" + criterio + "%";
    Object[] args = {criterio,criterio,criterio};
    List<Cliente> lista = jdbcTemplate.query(sql, args, 
            new BeanPropertyRowMapper<Cliente>(Cliente.class));
    return lista;
  }
  
  public List<Cliente> getClientesSucursal(String sucursal) {
    String sql = SQL_SELECT
            + "where chr_cliecodigo in "
            + "(select chr_cliecodigo from cuenta where chr_sucucodigo=?) ";
    List<Cliente> lista = jdbcTemplate.query(sql,  
            new BeanPropertyRowMapper<Cliente>(Cliente.class), sucursal);
    return lista;
  }
  
  
  /**
   * CRUD
   */
  
  public Cliente read(String codigo){
	  Cliente bean = null;
	  try {
		
	  } catch (EmptyResultDataAccessException e) {
	  }
	  return bean;
  }
  
  
  public List<Cliente> read( Cliente bean){
	  
	  return null;
  }
  
  public void create( Cliente bean){
	  
	  
  }
  
  public void update( Cliente bean){
	  
	  
  }
  
  public void delete( String codigo){
	  
	  
  }
  
  

}
