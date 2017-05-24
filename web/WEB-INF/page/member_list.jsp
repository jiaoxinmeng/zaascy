<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/17
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>member list</title>
    <script type="application/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
    <div>
        <table>
            <thead>
                <tr>
                    <td>排名</td>
                    <td>姓名</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="tradeMember" varStatus="tt">
                <tr>
                    <td><c:out value="${tradeMember.rankNumber}"/></td>
                    <td><c:out value="${tradeMember.name}"/></td>
                    <td>
                        <input type="button" value="修改" id="editBt" title="edit this" onclick="doEdit(<c:out value="${tradeMember.id}"/>)"/>
                        <input type="button" value="删除" id="delBt" title="del this" onclick="doDel(<c:out value="${tradeMember.id}"/>)"/>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
<script type="application/javascript">
    function doEdit() {
        window.location.href = "edit.do?id="+id;
    }

    function doDel() {
        if(confirm("是否确认删除")){
            window.location.href = "del.do?id="+id;
        }
    }
</script>
</html>
