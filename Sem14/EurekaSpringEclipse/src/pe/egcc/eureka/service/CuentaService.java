package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;
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

  public double getSaldoTotal(String moneda) {
    String sql = "select sum(dec_cuensaldo) from cuenta "
            + "where chr_monecodigo = ?";
    Object[] args = {moneda};
    Double saldo = jdbcTemplate.queryForObject(sql, args, Double.class);
    return saldo;
  }

  public List<Map<String, Object>> getResumenSucursal(String sucursal, String moneda) {
    String sql = "select sucucodigo, sucunombre, "
            + "monecodigo, monenombre, "
            + "tipocodigo, tiponombre, "
            + "count(*) cant, "
            + "sum(moviimporte) importe "
            + "from v_movimiento "
            + "where sucucodigo = ? "
            + "and monecodigo = ? "
            + "group by sucucodigo, sucunombre, "
            + "monecodigo, monenombre, "
            + "tipocodigo, tiponombre";
    List<Map<String, Object>> lista
            = jdbcTemplate.queryForList(sql, sucursal, moneda);
    return lista;
  }

}
