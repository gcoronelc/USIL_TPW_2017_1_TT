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

  <h1>${accion} CLIENTE</h1>
  
  <form method="post" action="crudClientesGrabar.htm">
  <fieldset>
    <legend>Datos</legend>
    
    <input type="hidden" name="codigo" value="${cliente.codigo}"/>
    <input type="hidden" name="accion" value="${accion}"/>
    
  
    <div>
      <label class="formLabel">Código:</label>
      <span class="formImput">${cliente.codigo}</span>
    </div>
    
    <div>
      <label class="formLabel">Paterno:</label>
      <input  type="text"
              name="paterno" 
              class="formImput"
              ${ disabled }
              value="${cliente.paterno}" />
    </div>
    
    <div>
      <label class="formLabel">Materno:</label>
      <input  type="text"
              name="materno" 
              class="formImput"
              ${ disabled }
              value="${cliente.materno}" />
    </div>
  
    <div>
      <label class="formLabel">Nombre:</label>
      <input  type="text"
              name="nombre" 
              class="formImput"
              ${ disabled }
              value="${cliente.nombre}" />
    </div>
    
    <div>
      <label class="formLabel">DNI:</label>
      <input  type="text"
              name="dni" 
              class="formImput"
              ${ disabled }
              value="${cliente.dni}" />
    </div>
    
    <div>
      <label class="formLabel">Ciudad:</label>
      <input  type="text"
              name="ciudad" 
              class="formImput"
              ${ disabled }
              value="${cliente.ciudad}" />
    </div>
    
    <div>
      <label class="formLabel">Dirección:</label>
      <input  type="text"
              name="direccion" 
              class="formImput"
              ${ disabled }
              value="${cliente.direccion}" />
    </div>
    
    <div>
      <label class="formLabel">Teléfono:</label>
      <input  type="text"
              name="telefono"
              class="formImput" 
              ${ disabled }
              value="${cliente.telefono}" />
    </div>
  
    <div>
      <label class="formLabel">Email:</label>
      <input  type="text"
              name="email" 
              class="formImput"
              ${ disabled }
              value="${cliente.email}" />
    </div>

  </fieldset>
  
  <fieldset>
    <legend>Acción</legend>
    
    <input class="btnMain" type="submit" value="Procesar" />
    
  </fieldset>
  
  </form>
  
  
  
  
</body>

</html>
