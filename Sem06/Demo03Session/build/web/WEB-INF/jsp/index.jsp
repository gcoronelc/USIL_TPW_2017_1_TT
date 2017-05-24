<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DEMO SESSION 01</title>
    <style>
      .menu{
        display: inline-block;
        margin: 5px;
        padding: 10px 20px;
        background-color: cornflowerblue;
        color: black;
        text-decoration: none;
      }
    </style>
  </head>
  <body>
    <h1>DEMO SESSION 01</h1>
    <p>Nombre: ${sessionScope.nombre}</p>
    <div>
      <a class="menu" href="<c:url value='/agregar.usil'/>" target="panel">Agregar Ciudad</a>
      <a class="menu" href="<c:url value='/listado.usil'/>" target="panel">Listado de Ciudades</a>
      <a class="menu" href="<c:url value='/limpiar.usil'/>">Limpiar Lista</a>
    </div>
    <iframe name="panel" width="800px;" height="500px" 
            scrolling="auto"></iframe>
  </body>
</html>
