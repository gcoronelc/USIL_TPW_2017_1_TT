package pe.egcc.eureka.util;

import java.util.List;
import pe.egcc.eureka.model.Combo;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public final class EurekaUtil {

  public static void selectedCombo(List<Combo> lista, String opcion) {
    for (Combo combo : lista) {
      if(combo.getCodigo().equals(opcion)){
        combo.setSelected("selected");
      }
    }
  }



}
