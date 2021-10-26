<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/26/2021
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Discount Calculator</title>
</head>
<body>
<form action="/index" method="post">
  <h3>Product Discount Calculator</h3>
  <label> Product Description:</label>
  <input type="text" name="txtInfo" placeholder="input info product"> <br>
  <label> List Price</label>
  <input type="text" name="txtPrice" placeholder="input price"><br>
  <label>Discount Percent</label>
  <input type="text" name="txtDiscount" placeholder="input discount"> <br>
  <input type="submit" id="cal" value="calculate">

</form>
</body>
</html>
