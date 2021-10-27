<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="calculate" method="post">
    <table>
      <tr>
        <th>Calculator</th>
        <th></th>
      </tr>
      <tr>
        <td><label>First operand</label></td>
        <td><input type="text" name="firstO"></td>
      </tr>
      <tr>
        <td><label for="operator">Operator</label></td>
        <td>
          <select name="operator" id="operator">
            <option value="add">Addition</option>
            <option value="sub">Subtraction</option>
            <option value="mul">Multiplication</option>
            <option value="div">Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label>Second operand</label></td>
        <td><input type="text" name="secondO"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" id="submit" value="Calcualte"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
