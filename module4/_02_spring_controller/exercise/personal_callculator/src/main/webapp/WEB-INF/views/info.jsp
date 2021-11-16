<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/calculate">
    <h3>Calculator</h3>
    <label><input type="text" name="num1"></label>
    <label ><input type="text" name="num2" ></label>
    <br>
    <div style="padding-top: 10px">
        <input type="submit" value="Addition(+)" name="calculation" >
        <input type="submit" value="Subtraction(-)" name="calculation" >
        <input type="submit" value="Mutiplication(X)" name="calculation" >
        <input type="submit" value="Division(/)" name="calculation" >
    </div>

    <p>${result}</p>
</form>
