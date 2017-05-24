<%-- 
    Document   : pagina1
    Created on : 08/05/2017, 02:28:56 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PAGE ONE</title>
  </head>
  <body>
    <h1>SUMA DOS NUMEROS</h1>
    
    <form id="form1">
      
      <div class="campo">
        <label>Número 1:</label>
        <input type="text" name="num1"/>
      </div>
      <div class="campo">
        <label>Número 2:</label>
        <input type="text" name="num2"/>
      </div>
      <div class="campo">
        <input class="botonDefault" id="btnProcesar" 
               type="button" value="Procesar"/>
      </div>
      
    </form>
    
    <div id="divReporte" style="display: none;">
      <h2>REPORTE</h2>
      <p class="campo">Número 1: <span id="n1"></span></p>
      <p class="campo">Número 2: <span id="n2"></span></p>
      <p class="campo">Suma: <span id="n3"></span></p>
    </div>
    
    <script>
      
      $("#btnProcesar").click(fnProcesar);
      
      function fnProcesar(){
        // Datos
        var data = $("#form1").serialize();
        // Proceso
        $.post("sumar.htm",data,function(repo){
          var obj = $.parseJSON(repo);
          $("#n1").text(obj.n1);
          $("#n2").text(obj.n2);
          $("#suma").text(obj.su);
          $("#divReporte").show();
        });
      }
      
      
    </script>
    
  </body>
</html>
