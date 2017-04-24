<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LISTADO DE CIUDADES</title>
  </head>
  <body>
    <h2>LISTADO DE CIUDADES</h2>

    <c:if test="${empty sessionScope.lista}">
      <div style="color:red;">
        Lista está vacía.
      </div>
    </c:if>

    <c:if test="${not empty sessionScope.lista}">
      <div>
        <ul>
          <c:forEach items="#{sessionScope.lista}" var="r">
            <li>${r} <a href="<c:url value='/delete.usil?ciudad=${r}'/>">Delete</a></li>
            </c:forEach>
        </ul>
      </div>
    </c:if>

  </body>
</html>
