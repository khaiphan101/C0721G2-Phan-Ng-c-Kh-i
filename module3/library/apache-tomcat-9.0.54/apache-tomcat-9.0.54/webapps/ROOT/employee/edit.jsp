<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
  <title>$Title$</title>
  <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
  <script type="text/javascript" src="../bootstrap413/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css_home.css">
  <script src="../js_home.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand col-3 text-left pl-0" href="#">FURAMA RESORT</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item ">
          <a class="nav-link" href="/home">Home</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/employee">Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/customer">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"  href="/service">Service</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/contract">Contract</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</div>

<center>
  <h1>User Management</h1>
  <h2>
    <a href="/employee">Back to Employee</a>
  </h2>
</center>

<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit Employee
        </h2>
      </caption>
      <c:if test="${user != null}">
        <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
      </c:if>
      <tr>
        <th>User Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${user.name}' />"
          />
        </td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>
          <input type="text" name="email" size="45"
                 value="<c:out value='${user.email}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Country:</th>
        <td>
          <input type="text" name="country" size="15"
                 value="<c:out value='${user.country}' />"
          />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>