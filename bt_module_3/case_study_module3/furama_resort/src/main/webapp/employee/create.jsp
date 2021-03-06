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
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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

        <div class="content pb-4" style="padding-top: 60px; padding-bottom: 60px">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>Th??m kh??ch h??ng</h1>
                    </div>
                    <c:if test='${message != null}'>
                        <h5 class="float-right text-success text-center">${message}</h5>
                    </c:if>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left " for="exampleInputId">Id:</label>
                            <input type="text" name="id" class="form-control col-12 float-left "
                                   id="exampleInputId" placeholder="Enter id" value="${employee.id}">
                        </div>
                        <div class="form-group col-12 pt-2">
                            <label class="col-12 float-left" for="exampleInputName">name:</label>
                            <input type="text" name="name" class="form-control col-12 float-left "
                                   id="exampleInputName" placeholder="Enter Name" value="${employee.name}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputBirthday">Birthday:</label>
                            <input type="date" name="birthDay" class="form-control col-12 float-left "
                                   id="exampleInputBirthday" placeholder="Enter birthday" value="${employee.birthDay}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputIdCard">Id card:</label>
                            <input type="text" name="idCard" class="form-control col-12 float-left "
                                   id="exampleInputIdCard" placeholder="Enter id card" value="${employee.idCard}">
                            <c:if test='${idCardError != null}'>
                                <p class="float-l??t text-danger">${idCardError}</p>
                            </c:if>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputSalary">salary:</label>
                            <input type="text" name="salary" class="form-control col-12 float-left "
                                   id="exampleInputSalary" placeholder="Enter salary" value="${employee.salary}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputPhone">Phone:</label>
                            <input type="text" name="phone" class="form-control col-12 float-left"
                                   id="exampleInputPhone" placeholder="Enter Phone" value="${employee.phone}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputEmail">Email:</label>

                            <input type="text" name="email" class="form-control col-12 float-left"
                                   id="exampleInputEmail" placeholder="Enter Email" value="${employee.email}">
                            <c:if test='${emailError != null}'>
                                <p class="float-l??t text-danger">${emailError}</p>
                            </c:if>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputAddress">Address:</label>
                            <input type="text" name="address" class="form-control col-12 float-left"
                                   id="exampleInputAddress" placeholder="Enter Address" value="${employee.address}">
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputDivision">Division type:</label>
                            <select name="division_type" id="exampleInputDivision" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${divisions}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputEducationDegree">Education degree type:</label>
                            <select name="education_degree_type" id="exampleInputEducationDegree" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${educationDegrees}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">position type:</label>
                            <select name="position_type" id="exampleInputPosition" class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${positions}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary float-right mt-2">Create</button>
                        <a href="/employee"><button type="button" class="btn btn-info float-right mt-2">Back</button></a>
                    </form>
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
</div>
</body>
</html>
