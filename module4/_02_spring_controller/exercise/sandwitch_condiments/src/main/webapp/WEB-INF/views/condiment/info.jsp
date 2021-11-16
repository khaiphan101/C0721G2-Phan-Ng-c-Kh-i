<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/save" method="post">
    <h3>Sandwich Condiments</h3>
    <label><input type="checkbox" name="condiment" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="condiment" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="condiment" value="Mustard">Mustard</label>
    <label><input type="checkbox" name="condiment" value="Sprouts">Sprouts</label>
    <input type="submit" value="save">
</form>
