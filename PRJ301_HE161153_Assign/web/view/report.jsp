<%-- 
    Document   : report
    Created on : Aug 22, 2022, 12:38:58 AM
    Author     : kieut
--%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Employee" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:useBean id="dt" class="helper.DateTimeHelper"/>
        <table border="1px">
            <tr>
            <p style="teXt-align:center;font-size:30pX">Bảng Chấm Công</p>
            <p style="teXt-align:center;font-size:20pX">Bộ Phận:Công Nhân thi công</p>
            <p style="teXt-align:center;font-size:20pX">Tháng 1 Năm 2016</p>
            <table border="1">
                <thead>
                    <tr>
                        <th rowspan="2">Số Thứ Tự</th>
                        <th rowspan="2">Họ Và Tên</th>
                        <th rowspan="2">Chức vụ</th>
                        <th colspan="31">Ngày trong tháng / Thứ trong tuần</th>
                        <th rowspan="2">X</th>
                        <th rowspan="2">X2</th>
                        <th rowspan="2">NO</th>
                        <th rowspan="2">Tổng</th>
                    </tr>
                    <tr>
                        <c:forEach items="${requestScope.dates}" var="d">
                            <td
                                <c:if test="${dt.getDayOfWeek(d) eq 7}">
                                    style="background-color: red;"
                                </c:if>
                                >
                                <fmt:formatDate pattern = "dd" 
                                                value = "${d}" /> <br/>
                                <fmt:formatDate pattern = "EEE" 
                                                value = "${d}" />
                            </td>
                        </c:forEach>
                    </tr>
                    <c:forEach items="${requestScope.employees}" var="e">
                        <tr>
                            <td>${e.id}</td>
                            <td>${e.name}</td>
                            <td>${e.type}</td>
                            <c:forEach items="${requestScope.dates}" var="d">
                                <td 
                                    <c:if test="${dt.getDayOfWeek(d) eq 7}">
                                        style="background-color: red;"
                                    </c:if> 
                                    >
                                    <c:forEach items="${e.timesheets}" var="t">                                         
                                        <c:if test="${t.checkin eq d}">
                                            <c:if test="${t.cosalary eq 0}">
                                                <div style="background-color: red;">
                                                    NO
                                                </div>
                                            </c:if> 
                                            <c:if test="${t.cosalary eq 1}">
                                                <div style="background-color: aqua;">
                                                    X
                                                </div>
                                            </c:if> 
                                            <c:if test="${t.cosalary eq 0.5}">
                                                <div style="background-color: aquamarine;">
                                                    X2
                                                </div>
                                            </c:if> 
                                        </c:if>                                          
                                    </c:forEach>
                                </td>
                            </c:forEach>
                            <td>${e.getSumX()}</td>
                            <td>${e.getSumX2()}</td>
                            <td>${e.getSumNO()}</td>
                            <td>${e.getSumCoSalary()}</td>
                        </tr>
                    </c:forEach>
            </table>
            <br>
        <br>
        <br>
        <br>
        <br>
        <br>
            <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>Mã</th>
                    <th>Nội Dung</th>
                    <th>Mã Màu</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="4">kí hiệu</td>
                    <td>X</td>
                    <td>Làm cả ngày</td>
                    <td rowspan="4">Ngày lễ,ngày nghỉ</td>
                </tr>
                <tr>
                    <td>X2</td>
                    <td>Làm nửa ngày</td>
                </tr>
                <tr>
                    <td>NC</td>
                    <td>Nghỉ có lương</td>
                </tr>
                <tr>
                    <td>NO</td>
                    <td>Nghỉ không lương</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
