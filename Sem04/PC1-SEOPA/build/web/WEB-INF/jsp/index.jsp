<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
  </head>

  <body>
    <h1>PROMEDIO</h1>
    <form method="post" action="<c:url value="/panchito.usil"/>">
      
      <p>
        Nombre del producto:
        <input type="text" name="producto"/>
      </p>
      <p>
        Tamaño del lote:
        <input type="text" name="tamLote"/>
      </p>
      <p>
        Precio del lote:
        <input type="text" name="precLote"/>
      </p>
      <p>
        Porc. Gastos Ad,:
        <input type="text" name="porcGastos"/>
      </p>
      <p>
        Porc. Ganancia: 
        <input type="text" name="porcGanancia"/>
      </p>
      <p>
        <input type="submit" value="Procesar"/>
      </p>
    </form>
    
    <c:if test="${venta != null}">
      <h1>REPORTE</h1>
      <p>Unidades a comercializar: ${venta.uniComerc}</p>
      <p>Costo total lote: ${venta.costoTotal}</p>
      <p>Costo por unidad: ${venta.costoUnidad}</p>
      <p>Precio de venta: ${venta.precVentaUni}</p>
    </c:if>
      
  </body>
</html>
