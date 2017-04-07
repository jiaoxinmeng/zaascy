<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>trade detail</title>
    <script type="application/javascript" src="/resources/js/jquery.js"></script>
</head>
<body>
    <div>
        <table>
            <tr>
                <td>ID:</td>
                <td><c:out value="${trade.id}"/></td>
            </tr>
            <tr>
                <td>项目名称</td>
                <td><c:out value="${trade.projectName}"/></td>
            </tr>
            <tr>
                <td>院成果编码</td>
                <td><c:out value="${trade.zaasCode}"/></td>

            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" id="returnBt" value="返回列表"/>
                </td>
            </tr>
        </table>
    </div>
</body>
<script type="application/javascript">
    $("#returnBt").click(function(){
        alert("触发成功");
        window.location.href = "list.do";
    });
</script>
</html>
