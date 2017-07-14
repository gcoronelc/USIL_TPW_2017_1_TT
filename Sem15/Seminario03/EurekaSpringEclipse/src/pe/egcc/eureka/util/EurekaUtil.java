package pe.egcc.eureka.util;

import java.util.List;
import pe.egcc.eureka.model.Combo;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public final class EurekaUtil {

	// ========================================
	// ACCIONES DEL CRUD
	// ========================================
	
	public static final String CRUD_NUEVO = "NUEVO";
	public static final String CRUD_EDITAR = "EDITAR";
	public static final String CRUD_ELIMINAR = "ELIMINAR";
	

	/**
	 * Seleccionar opci�n del combo.
	 * 
	 * @param lista Lista de opciones
	 * @param opcion Opci�n a seleccionar
	 */
	public static void selectedCombo(List<Combo> lista, String opcion) {
		for (Combo combo : lista) {
			if (combo.getCodigo().equals(opcion)) {
				combo.setSelected("selected");
			}
		}
	}

}
