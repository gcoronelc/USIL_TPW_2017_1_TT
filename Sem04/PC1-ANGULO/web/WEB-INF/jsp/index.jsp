<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
  </head>

  <body>
    <h1>Comprar de Productos</h1>
    <form method="POST" action="<c:url value="/practica.usil" />">
      <p>
        Nombre del Producto:
        <input type="text" name="txtProducto">
      </p>
      <p>
        Tamaño de Lote
        <input type="text" name="txtCant">
      </p>
      <p>
        Precio del Lote
        <input type="text" name="txtPrecio">
      </p>
      <p>
        Gastos Administrativos
        <input type="text" name="txtGastos">
      </p>
      <p>
        Ganancia por Unidad
        <input type="text" name="txtPreventa">
      </p>
      <p><input type="submit" value="Procesar"></p>
    </form>

    <c:if test="${vm != null}">
      <h1>Reporte</h1>
      <p>Unidades a comercializar: ${vm.nombre}</p>
      <p>Tamaño del Lote: ${vm.cantidad}</p>
      <p>Precio del Lote: ${vm.costo}</p>
      <p>Gastos Administrativos: ${vm.gastoporcentaje}</p>
      <p>Ganancia por Unidad: ${vm.ganancia}</p>
      <p>Unidades a comercialixzar: ${vm.tocantidad}</p>
      <p>Costo total del lote: ${vm.costotal}</p>
      <p>Costo por unidad: ${vm.costunid}</p>
      <p>Precio de venta : ${vm.preventa}</p>
    </c:if>
  </body>
</html>
