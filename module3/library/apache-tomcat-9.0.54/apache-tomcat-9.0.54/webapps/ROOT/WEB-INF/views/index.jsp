<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail box</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <style>

        p{
            padding-bottom: 0px;
        }
    </style>
</head>
<body>
<center>
    <h1>TỜ KHAI Y TẾ</h1>
    <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM</h3>
    <H4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</H4>
</center>
<div class="container">
    <form:form action="/save" method="post" modelAttribute="medical_form">
        <div class="col-12">
            <p><label for="name">Họ tên (ghi chữ IN HOA)</label></p>
            <form:input type="text" name="name" path="name"/>
        </div>

        <div class="col-md-4">
            <form:label path="birthday" class="form-label">Birthday</form:label>
            <form:input type="text" path="birthday" class="form-control"/>
        </div>
        <div class="col-md-4">
            <form:label path="gender" class="form-label">Gender</form:label>
            <form:select path="gender">
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>
        <div class="col-md-4">
            <form:label path="Country" class="form-label">Country</form:label>
            <form:select path="country">
                <form:options items="${Countrys}"></form:options>
            </form:select>
        </div>
    </form:form>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
