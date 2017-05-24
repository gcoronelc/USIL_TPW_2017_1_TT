<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MAIN PAGE</title>
    
    <script src="<c:url value="/jquery/jquery.min.js" />"></script>
    
    <style type="text/css">
      .boton{
        margin: 15px;
        padding: 10px;
        text-decoration: none;
        color: black;
        background-color: coral;
        display: inline-block;
      }
      
      .botonDefault{
        margin: 15px;
        padding: 10px;
        text-decoration: none;
        color: white;
        background-color: darkblue;
        display: inline-block;
        font-size: 18px;
      }
      
      .campo{
        margin: 10px;
      }
    </style>
  </head>

  <body>
    <h1>DEMO AJAX</h1>
    <div>
      <a class="boton" href="javascript:fnCargarPagina('pagina1.htm');" >Page one</a>
      <a class="boton" href="javascript:fnCargarPagina('pagina2.htm');">Page two</a>
    </div>
    <div id="panel"></div>
    <script>
            
      function fnCargarPagina(pagina){
        $("#panel").load(pagina);
      }
      
    </script>
  </body>
</html>
