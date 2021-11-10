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
                <a class="navbar-brand col-3 text-left pl-0" href="#">LIBRARY MANAGEMENT</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/book">Book</a>
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

        <div class="content pb-4" style="padding-top: 60px; padding-bottom: 60px">
            <div class="container-fluid col-6">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>Borrow book</h1>
                    </div>
                    <c:if test='${message != null}'>
                        <h5 class="float-right text-success text-center">${message}</h5>
                    </c:if>
                    <form class="col-12" method="post">
                        <div class="form-group col-12">
                            <label class="col-12 float-left " for="exampleInputId">Id borrow book:</label>
                            <input type="text" name="idBorrowBook" class="form-control col-12 float-left "
                                   id="exampleInputId" placeholder="Enter id" value="${card.id}">
                        </div>

                        <div class="form-group col-12 pt-2 " >
                            <label class="col-12 float-left" for="exampleInputName">Book name:</label>
                            <input type="text" name="bookName" class="form-control col-12 float-left "
                                   id="exampleInputName" placeholder="Enter Area" value="${book.name}" disabled>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputEducationDegree">Student name:</label>
                            <select name="studentName" id="exampleInputEducationDegree"
                                    class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${studentList}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputBirthday">borrow day:</label>
                            <input type="date" name="borrowDay" class="form-control col-12 float-left "
                                   id="exampleInputBirthday" placeholder="Enter floor"
                                   value="${card.borrowDay}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputIdCard">return day:</label>
                            <input type="date" name="returnDay" class="form-control col-12 float-left "
                                   id="exampleInputIdCard" placeholder="Enter price" value="${card.returnDay}">
<%--                            <c:if test='${priceError != null}'>--%>
<%--                                <p class="float-lèt text-danger">${priceError}</p>--%>
<%--                            </c:if>--%>
                        </div>




                        <button type="submit" class="btn btn-primary float-right mt-2 ml-2">borrow</button>
                        <a href="/book">
                            <button type="button" class="btn btn-info float-right mt-2">Back</button>
                        </a>
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
