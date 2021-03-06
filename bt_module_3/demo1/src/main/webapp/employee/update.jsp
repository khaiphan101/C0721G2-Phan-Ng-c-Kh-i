<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2020
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>

</head>
<body>
<div class="wrapper ">
    <div class="main-panel">
        <div class="container-fluid">
            <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand col-3 text-left pl-0" href="#">FURAMA RESORT</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
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
                            <a class="nav-link" href="/service">Service</a>
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

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>Edit Employee</h1>
                    </div>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 ">Id:</label>
                            <input type="text" name="id" class="form-control col-12  mt-2"
                                   value="${employee.getId()}" readonly>
                        </div>
                        <div class="form-group col-12">
                            <label class="" for="a">area:</label>
                            <input id="a" type="text" name="area" class="form-control col-12  mt-2"
                                   value="${employee.area}">
                        </div>
                        <div class="form-group col-12">
                            <label class="" for="a">floor:</label>
                            <input id="a" type="text" name="floor" class="form-control col-12  mt-2"
                                   value="${employee.floor}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">price:</label>
                            <input type="text" name="price" class="form-control col-12  mt-2"
                                   value="${employee.price}">
                        </div>
                        <div class="form-group col-12">
                            <label class="" for="a">start Day:</label>
                            <input id="a" type="text" name="startDay" class="form-control col-12  mt-2"
                                   value="${employee.startDay}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 ">end Day:</label>
                            <input type="text" name="endDay" class="form-control col-12 fmt-2"
                                   value="${employee.endDay}">
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left">Status:</label>
                            <select class="form-control" name="status">
                                <c:forEach var="type" items="${statusList}">
                                    <c:choose>
                                        <c:when test="${type.id == premise.status.id}">
                                            <option value="${type.id}" selected> ${type.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${type.id}">${type.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">premise type:</label>
                            <select class="form-control" name="premiseType">
                                <c:forEach var="type" items="${premiseTypeList}">
                                    <c:choose>
                                        <c:when test="${type.id == premise.premiseType.id}">
                                            <option value="${type.id}" selected> ${type.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${type.id}">${type.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary float-right">Edit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="text-center text-white bg-dark">
    <div class="text-center p-3">
        C0721G2:
        <a class="text-white" href="#">Khaiphanngoc@gmail.com</a>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
