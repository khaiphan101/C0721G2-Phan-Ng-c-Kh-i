<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
<body>
    <p> Sandwich Condiments list:
        <c:forEach var="condiment" items="${condimentList}">
            <span>${condiment}</span>
        </c:forEach>
    </p>
</body>