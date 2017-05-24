package pe.egcc.eureka.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@Service
public class CuentaService extends AbstractJdbcSupport {

  public int getCantCuentas() {
    String sql = "select count(*) from cuenta";
    int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
    return rowCount;
  }
  
  public double getSaldo(){
    String sql= "select sum(dec_cuensaldo) from cuenta";
    Double saldo = jdbcTemplate.queryForObject(sql, Double.class);
    return saldo;
  }

}
