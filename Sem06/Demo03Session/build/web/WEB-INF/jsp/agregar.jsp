<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AGREGAR CIUDAD</title>
  </head>
  <body>
    <h2>AGREGAR CIUDAD</h2>
    <form method="post" action="agregar.usil">
      Nueva Ciudad: 
      <input type="text" name="ciudad" />
      <input type="submit" value="Procesar"/>
    </form>
    <c:if test="${mensaje != null}">
      <div style="padding: 10px; color: blue; ">
        ${mensaje}
      </div>
    </c:if>
  </body>
</html>
