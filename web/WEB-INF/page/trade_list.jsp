<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>trade list jsp</title>

</head>
<body>
    <div>
        <table>
            <thead>
                <tr>
                    <td>序号</td>
                    <td>项目名称</td>
                    <td>院成果编码</td>
                    <td>操作<fmt:formatDate value="${date}" type="both"/></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tradeList}" var="trade" varStatus="tt">
                    <tr>
                        <td><c:out value="${tt.index + 1}"/></td>
                        <td><c:out value="${trade.projectName}"/></td>
                        <td><c:out value="${trade.zaasCode}"/></td>
                        <td>
                            <input type="button" value="修改" id="editBt"/>
                        </td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>


    </div>
</body>
</html>
