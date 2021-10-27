<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Customer List</title>
  </head>
  <body>
  <h2>Customer list</h2>
  <table>
    <tr>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa chỉ</th>
      <th>Image</th>
    </tr>

      <c:forEach var="customerObj" items="${customerListServlet}">
            <tr>
                <td>${customerObj.name}</td>
                <td>${customerObj.birthday}</td>
                <td>${customerObj.address}</td>
                <td><img src= "<c:out value="${customerObj.image}"/>" alt="..." style="width: 50px"></td>
<%--                <td><img src="image/1.bmp" alt="."></td>--%>
            </tr>
      </c:forEach>
  </table>

  </body>
</html>
