<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?actionUser=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" id="country" size="15"/>
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





<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 12/29/2020--%>
<%--  Time: 8:14 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"--%>
<%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>

<%--</head>--%>
<%--<body>--%>
<%--<div class="wrapper ">--%>
<%--    <div class="main-panel">--%>
<%--        <!-- Navbar -->--%>
<%--        <!-- End Navbar -->--%>
<%--        <div class="content">--%>
<%--            <div class="container-fluid">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-12 text-center">--%>
<%--                        <h1>Thêm khách hàng</h1>--%>
<%--                    </div>--%>
<%--                    <c:if test='${requestScope["message"] != null}'>--%>
<%--                        <span class="col-12 border bg-light">${requestScope["message"]}</span>--%>
<%--                    </c:if>--%>
<%--                    <form class="col-12" method="post">--%>
<%--                        <div class="form-group col-12">--%>
<%--                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Customer type:</label>--%>
<%--                            <select name="id_customer_type" id="exampleInputPosition" class="form-control col-12 float-left">--%>
<%--                                <option>Chose option ...</option>--%>
<%--                                <c:forEach var="item" items="${requestScope['customerType']}">--%>
<%--                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-12">--%>
<%--                            <label class="col-12 float-left" for="exampleInputVao">Tên khách hàng:</label>--%>
<%--                            <input type="text" name="name" class="form-control col-12 float-left mt-2"--%>
<%--                                   id="exampleInputVao" placeholder="Enter Name">--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-12">--%>
<%--                            <label class="col-12 float-left" for="exampleInputRa">Id Card:</label>--%>
<%--                            <input type="text" name="idCard" class="form-control col-12 float-left mt-2"--%>
<%--                                   id="exampleInputRa" placeholder="Enter Name">--%>
<%--                        </div>--%>
<%--                        <div class="form-group col-12">--%>
<%--                            <label class="col-12 float-left" for="exampleInputLyDo">SDT:</label>--%>
<%--                            <input type="text" name="phone" class="form-control col-12 float-left mt-2"--%>
<%--                                   id="exampleInputLyDo" placeholder="Enter Name">--%>
<%--                        </div>--%>
<%--                        <button type="submit" class="btn btn-primary float-right">Create</button>--%>
<%--                        <a href=""><button type="button" class="btn btn-info float-right">Back</button></a>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        &lt;%&ndash; Footer &ndash;%&gt;--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>