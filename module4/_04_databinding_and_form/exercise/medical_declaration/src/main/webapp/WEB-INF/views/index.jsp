<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail box</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
    <form:form action="/submit" method="post" modelAttribute="medical_form">
        <div class="col-12">
            <p><label for="name">Họ tên (ghi chữ IN HOA)<span class="text-danger fst-italic">(*)</span></label></p>
            <form:input type="text" path="name"/>
        </div>

        <div class="row ">
            <div class="col-4">
                <label for="birthday" class="form-label">Năm sinh <span class="text-danger fst-italic">(*)</span>
                </label>
                <form:input type="date" path="birthday" id="birthday" cssClass="form-control"/>
            </div>
            <div class="col-4">
                <div>Giới tính <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="gender" cssClass="form-select mt-2">
                    <form:options items="${genderList}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Quốc tịch <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="country" cssClass="form-select mt-2">
                    <form:options items="${countryList}"></form:options>
                </form:select>
            </div>
        </div>

        <div class="col-12">
            <p><label for="travelInfo">Thông tin đi lại<span class="text-danger fst-italic">(*)</span></label></p>
            <form:radiobuttons items="${travelInfoList}" path="travelInfo" />
        </div>

        <div class="row">
            <div class="col-6">
                <label for="departDay" class="form-label">Ngày khởi hành<span class="text-danger fst-italic">(*)</span>
                </label>
                <form:input type="date" path="departDay" id="departDay" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label for="endDay" class="form-label">Ngày kết thúc <span class="text-danger fst-italic">(*)</span>
                </label>
                <form:input type="date" path="endDay" id="endDay" cssClass="form-control"/>
            </div>
        </div>

        <div class="row ">
            <label class="font-weight-bold">Địa chỉ liên lạc</label>
            <div class="col-4">
                <label for="province" class="form-label">Tỉnh/thành<span class="text-danger fst-italic">(*)</span>
                </label>
                <form:select path="province" cssClass="form-select mt-2">
                    <form:options items="${provinceList}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Quận/huyện <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="district" cssClass="form-select mt-2">
                    <form:options items="${districList}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Xã/phường <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="ward" cssClass="form-select mt-2">
                    <form:options items="${wardList}"></form:options>
                </form:select>
            </div>
        </div>

        <div class="row ">
            <label class="font-weight-bold" >Trong vòng 14 ngày qua, Anh/chị có thấy xuất hiện dấu hiệu nào sau đây không?<span class="text-danger fst-italic">(*)</span></label>
            <table class="table table-bordered">
                <tr class="thead-dark bg-secondary">
                    <th class="w-5">Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                    <th>Triệu chứng</th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Sốt<span class="text-danger fst-italic">(*)</span></td>
                    <td><form:radiobutton path="fever" value="${true}"></form:radiobutton></td>
                    <td><form:radiobutton path="fever" value="${false}"></form:radiobutton></td>
                    <td>Nôn/buồn nôn<span class="text-danger fst-italic">(*)</span></td>
                    <td><form:radiobutton path="vomiting" value="${true}"></form:radiobutton></td>
                    <td><form:radiobutton path="vomiting" value="${false}"></form:radiobutton></td>
                </tr>
                <tr>
                    <td>Ho<span class="text-danger fst-italic">(*)</span></td>
                    <td><form:radiobutton path="cough" value="${true}"></form:radiobutton></td>
                    <td><form:radiobutton path="cough" value="${false}"></form:radiobutton></td>
                    <td>Tiêu chảy<span class="text-danger fst-italic">(*)</span></td>
                    <td><form:radiobutton path="diarrhea" value="${true}"></form:radiobutton></td>
                    <td><form:radiobutton path="diarrhea" value="${false}"></form:radiobutton></td>
                </tr>
            </table>
        </div>
        <div class="row ">
            <label >Lịch sử phơi nhiễm: Trong vòng 14 ngày qua anh/chị có?<span class="text-danger fst-italic">(*)</span></label>
            <table class="table table-bordered">
                <tr class="thead-dark bg-secondary">
                    <th class="w-5"></th>
                    <th>Có</th>
                    <th>Không</th>
                </tr>
                <tr>
                    <td>Tiếp xúc gần (< 2m) với người mắc bệnh viêm đường hô hấp do nCoV
                        <span class="text-danger fst-italic">(*)</span></td>
                    <td><form:radiobutton path="closeContact" value="${true}"></form:radiobutton></td>
                    <td><form:radiobutton path="closeContact" value="${false}"></form:radiobutton></td>
                </tr>
            </table>
        </div>
        <div class="row mb-2">
            <div class="col-12 text-danger">
                <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban
                    chỉ đạo Quốc gia về phòng chống dịch Covid-19.</p>
                <p>Khi bạn nhấn gửi là bạn đã hiểu và đồng ý.</p>

            </div>
        </div>
        <div class="row mb-2">
            <div class="col-12 text-danger text-center">
                <button type="submit" class="button btn-success bg-gradient rounded-3">Gửi tờ khai</button>
            </div>
        </div>
    </form:form>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
