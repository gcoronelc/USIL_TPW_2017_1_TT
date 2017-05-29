<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simulador Prestamo Bancario</title>
    <style>
      .menu{
        display: inline-block;
        margin: 5px;
        padding: 10px 20px;
        background-color: cornflowerblue;
        color: black;
        text-decoration: none;
      }
      table{
        align-content: center;
      }
      body {
        font-family: source-sans-pro;
        background-color: #f2f2f2;
        margin-top: 0px;
        margin-right: 0px;
        margin-bottom: 0px;
        margin-left: 0px;
        font-style: normal;
        font-weight: 200;
      }
      .container {
        width: 90%;
        margin-left: auto;
        margin-right: auto;
        height: 1000px;
        background-color: #FFFFFF;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <center>
        <h1>Simulador Prestamo Bancario</h1>
        <form method="post" action='<c:url value="/banco.prestamo"/>'> 
          <table>
            <tr>
              <td width="150">plazo: </td>
              <td width="150"><input type="text" name="meses" /></td>
            </tr>
            <tr>
              <td width="150">monto a solicitar: </td>
              <td width="150"><input type="text" name="capital" /></td>
            </tr>
            <tr>
              <td width="150">Interes mensual: </td>
              <td width="150"><input type="text" name="interes" /></td>
            </tr>
            <tr>
              <td width="200" colspan="2" align="center">
                <input type="submit" value="ENVIAR">
              </td>
            </tr>    
          </table>
        </form>
        <c:if test="${prestamo != null}">
          <table>
            <tr>
              <td>Interes Anual:</td>
              <td>${prestamo.totalInteres}</td>
            </tr>
            <tr>
              <td>Pago Mensual: </td>
              <td>${prestamo.valorCuota}</td>
            </tr>
            <tr>
              <td>Total a Pagar: </td>
              <td>${prestamo.importePagar}</td>
            </tr>
            <tr>
              <td>Total Capital: </td>
              <td>${prestamo.capital}</td>
            </tr>
          </table>
            <h2>CRONOGRAMA DE PAGOS</h2>
          <table border="1">
            <tr>
              <th>Meses</th>
              <th>Deuda Inicial</th>
              <th>Pago de Intereses</th>
              <th>Pago a Capital</th>
              <th>Cuota Mensual a Pagar</th>
            </tr>
            <c:forEach items="${prestamo.cuotas}" var="r">
              <tr>
                <td>${r.mes}</td>
                <td>${r.deuda}</td>
                <td>${r.interes}</td>
                <td>${r.capital}</td>
                <td>${r.cuota}</td>
              </tr>
            </c:forEach>
          </table>
        </c:if>



      </center>
    </div>
  </body>
</html>
