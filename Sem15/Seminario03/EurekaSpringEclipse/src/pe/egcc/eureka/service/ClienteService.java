package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	private final String SQL_INSERT = "insert into "
	          + "cliente(chr_cliecodigo,vch_cliepaterno,"
	          + "vch_cliematerno,vch_clienombre,chr_cliedni,"
	          + "vch_clieciudad,vch_cliedireccion,"
	          + "vch_clietelefono,vch_clieemail) "
	          + "values(?,?,?,?,?,?,?,?,?)";
	  
	private final String SQL_UPDATE = "update cliente set "
	          + "vch_cliepaterno = ?,"
	          + "vch_cliematerno = ?,"
	          + "vch_clienombre = ?,"
	          + "chr_cliedni = ?,"
	          + "vch_clieciudad = ?,"
	          + "vch_cliedireccion = ?,"
	          + "vch_clietelefono = ?,"
	          + "vch_clieemail = ? "
	          + "where chr_cliecodigo = ? ";
	  
	private final String SQL_DELETE = "delete from cliente "
	          + "where chr_cliecodigo = ? ";	
	

	public List<Cliente> getClientes(String criterio) {
		String sql = SQL_SELECT 
				+ "where vch_cliepaterno like ? " 
				+ "or vch_cliematerno like ? "
				+ "or vch_clienombre like ? ";
		criterio = "%" + criterio + "%";
		Object[] args = { criterio, criterio, criterio };
		List<Cliente> lista = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<Cliente>(Cliente.class));
		return lista;
	}

	public List<Cliente> getClientesSucursal(String sucursal) {
		String sql = SQL_SELECT 
				+ "where chr_cliecodigo in "
				+ "(select chr_cliecodigo from cuenta where chr_sucucodigo=?) ";
		List<Cliente> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cliente>(Cliente.class), sucursal);
		return lista;
	}

	/**
	 * CRUD
	 */

	public Cliente read(String codigo) {
		Cliente bean = null;
		try {
			String sql = SQL_SELECT 
					+ "where chr_cliecodigo = ? ";
			bean = jdbcTemplate.queryForObject(sql, 
					new BeanPropertyRowMapper<Cliente>(Cliente.class),
					codigo);
		} catch (EmptyResultDataAccessException e) {
		}
		return bean;
	}

	public List<Cliente> read(Cliente bean) {
		String sql = SQL_SELECT 
				+ "where vch_cliepaterno like concat('%',?,'%') "
				+ "or vch_cliematerno like concat('%',?,'%') " 
				+ "or vch_clienombre like concat('%',?,'%') ";
		List<Cliente> lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cliente>(Cliente.class),
				bean.getPaterno(), bean.getMaterno(), bean.getNombre());
		return lista;
	}

	  
  @Transactional(propagation = Propagation.REQUIRED,
          rollbackFor = Exception.class)
  public void crear(Cliente cliente) {
	    
	    // Leer el contador
	    String sql = "select int_contitem cont, int_contlongitud size "
	            + "from contador "
	            + "where vch_conttabla = 'Cliente' "
	            + "for update";
	    Map<String,Object> rec = jdbcTemplate.queryForMap(sql);
	    int cont = Integer.parseInt(rec.get("cont").toString());
	    int size = Integer.parseInt(rec.get("size").toString());

	    // Para producción se debe borrar
	    //System.out.println("CONT: " + cont);
	    /*
	    try {
	      Thread.currentThread().sleep(2000);
	    } catch (Exception e) {
	    }
	    */

	    
	    // Generar Codigo
	    cont++;
	    String codigo = String.format("%" + size + "s", cont).replace(' ', '0' );
	    
	    // Actualizar el contador
	    sql = "update contador set int_contitem = ? "
	            + "where vch_conttabla = 'Cliente'";
	    jdbcTemplate.update(sql, cont);
	    
	    // Insertar cliente
	    jdbcTemplate.update(SQL_INSERT, codigo, cliente.getPaterno(), 
	            cliente.getMaterno(),cliente.getNombre(),cliente.getDni(),
	            cliente.getCiudad(),cliente.getDireccion(),
	            cliente.getTelefono(),cliente.getEmail());
	    
	    cliente.setCodigo(codigo);
	    
	  }
	  
	  
	  @Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void update(Cliente cliente) {
	    
	    int filas = jdbcTemplate.update(SQL_UPDATE, cliente.getPaterno(), 
	            cliente.getMaterno(),cliente.getNombre(),cliente.getDni(),
	            cliente.getCiudad(),cliente.getDireccion(),
	            cliente.getTelefono(),cliente.getEmail(), cliente.getCodigo());
	    
	    if( filas != 1){
	      throw new RuntimeException("Error en el proceso.");
	    }
	    
	  }
	  
	  
		//DELETE
	   @Transactional(propagation = Propagation.REQUIRED,
	          rollbackFor = Exception.class)
	  public void delete(String codigo) {
	    
	    // VERIFICAR CUENTAS DEL CLIENTE 
	    String sql="select count(1) from cuenta where chr_cliecodigo = ?";
	    
	    int cuentas = jdbcTemplate.queryForObject(sql, Integer.class,codigo);
	    
	    if(cuentas > 0)
	    {
	      throw new RuntimeException("El cliente no puede ser eliminado.");  
	    }
	    
	    int filas = jdbcTemplate.update(SQL_DELETE, codigo);
	    
	    if( filas == 0){
	      throw new RuntimeException("El cliente no existe.");
	    }
	    
	  }

}
