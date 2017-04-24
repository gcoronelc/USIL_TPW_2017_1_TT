<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
  </head>

  <body>
    <h1>PROMEDIO</h1>
    <form method="post" action="panchito.usil">
      <p>
        Prom. Practicas:
        <input type="text" name="pp"/>
      </p>
      <p>
        Exa. Parcial:
        <input type="text" name="ep"/>
      </p>
      <p>
        Exa. Final:
        <input type="text" name="ef"/>
      </p>
      <p>
        <input type="submit" value="Procesar"/>
      </p>
    </form>
    
    <c:if test="${alumno != null}">
      <h1>REPORTE</h1>
      <p>Prom. Practicas: ${alumno.promPract}</p>
      <p>Exa. Parcial: ${alumno.exaParcial}</p>
      <p>Exa. Final: ${alumno.exaFinal}</p>
      <p>Pro. Final: ${alumno.promFinal}</p>
      <p>Estado: ${alumno.estado}</p>
    </c:if>
      
  </body>
</html>
