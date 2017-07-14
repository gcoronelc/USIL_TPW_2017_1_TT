<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INGRESO AL SISTEMA</title>
</head>
<body>
  <h1>INGRESO AL SISTEMA</h1>
  
  <div style="color: red;">${error}</div>
  
  <form method="post" action="logon.htm">
  
    <div>
      <label>Usuario:</label>
      <input type="text" name="usuario" />
    </div>
    
    <div>
      <label>Clave:</label>
      <input type="password" name="clave" />
    </div>
    
    <div>
      <input type="submit" value="Ingresar" />
    </div>
    
  </form>
  
  
</body>
</html>