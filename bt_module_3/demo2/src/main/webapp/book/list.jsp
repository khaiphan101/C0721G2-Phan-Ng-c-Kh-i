<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap413/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
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

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h2 class="text-center" style="padding-top: 60px">
                <a href="/book?actionUser=create">Add new book</a>
            </h2>
            <form action="/book?actionUser=search" method="post">
                <input type="text" name="findName" placeholder="Enter name">
                <input type="text" name="findId" placeholder="Enter id">
                <input type="text" name="findEmail" placeholder="Enter email">
                <button type="submit">Search</button>
            </form>
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr style="height: 50px" class="text-center">
                    <th>Id</th>
                    <th>name</th>
                    <th>actor</th>
                    <th>amount</th>
                    <th>description</th>
                    <th>action</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}" varStatus="count">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.actor}</td>
                        <td>${book.amount}</td>
                        <td>${book.description}</td>
                        <td class="text-center">
                            <a href="/book?actionUser=borrow&id=${book.getId()}"
                               role="button" class="btn btn-large btn-warning">Borrow</a>
                        </td>
                        <td class="text-center">
                            <a href="/book?actionUser=update&id=${book.getId()}"
                               role="button" class="btn btn-large btn-warning">Edit</a>
                        </td>
                        <td class="text-center">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal-${book.getId()}">
                                Delete
                            </button>
                        </td>
                    </tr>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal-${book.getId()}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    are you sure you want to delete book with Id: ${book.id}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="/book?actionUser=delete&id=${book.id}" role="button" class="btn-danger"> Confirm </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>

<footer class="text-center text-white fixed-bottom bg-dark">
    <div class="text-center p-3">
        C0721G2:
        <a class="text-white" href="#">Khaiphanngoc@gmail.com</a>
    </div>
</footer>
</body>
</html>
