<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="dependencias.jsp" />
<title>EUREKA BANK</title>

</head>

<body>

  <jsp:include page="cabecera.jsp"/>
  <jsp:include page="menu.jsp"/>

  <h1>MANTENIMIENTO DE CLIENTES</h1>
  
  <fieldset>
    <legend>Control</legend>
    
    <form method="post" action="crudClientesConsulta.htm">
	    <table>
	      <tr>
	      
	        <td>
	          <label>Paterno:</label><br/>
	          <input type="text" name="paterno" />
	        </td>
	        
	        <td>
            <label>Materno:</label><br/>
            <input type="text" name="materno" />
          </td>
          
          <td>
            <label>Nombre:</label><br/>
            <input type="text" name="nombre" />
          </td>
          
          <td style="vertical-align: bottom;">
            <input class="btnDefault" type="submit" name="btnAccion" value="Buscar" />
            <input class="btnDefault" type="submit" name="btnAccion" value="Nuevo" />
          </td>
	      
	      </tr>
	    
	    </table>
    </form>
  </fieldset>
  
  <c:if test="${ not empty mensaje }">
    <div class="cssMsgInfo">${mensaje}</div>
  </c:if>
  
  <c:if test="${ not empty error }">
    <div class="cssMsgError">${error}</div>
  </c:if>
  
  <c:if test="${ not empty lista }">
  <fieldset>
    <legend>Resultado</legend>
    
    <table border="1">
    
      <thead>
        <tr>
          <th>ACCION</th>
          <th>CODIGO</th>
          <th>PATERNO</th>
          <th>MATERNO</th>
          <th>CODIGO</th>
        </tr>    
      </thead>
    
      <tbody>
      
        <c:forEach items="${ lista }" var="r">
          <tr>
            <td>
              <a href="crudClientesEditar.htm?codigo=${r.codigo}">Editar</a>
              <a href="crudClientesEliminar.htm?codigo=${r.codigo}">Eliminar</a>
            </td>
            <td> ${ r.codigo } </td>
            <td> ${ r.paterno } </td>
            <td> ${ r.materno } </td>
            <td> ${ r.nombre } </td>
          </tr>
        
        </c:forEach>
      
      </tbody>
    
    </table>
    
    
  </fieldset>
  </c:if>
</body>

</html>
