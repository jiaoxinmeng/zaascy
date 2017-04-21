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
    <script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>

</head>
<body>
    <div>
        <table>
            <thead>
                <tr>
                    <td>序号</td>
                    <td>项目编号</td>
                    <td>年度</td>
                    <td>单位</td>
                    <td>项目名称</td>
                    <td>院成果技术编码</td>
                    <td>起始年月</td>
                    <td>终止年月</td>
                    <td>意向总金额</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tradeList}" var="trade" varStatus="tt">
                    <tr>
                        <td><c:out value="${tt.index + 1}"/></td>
                        <td><c:out value="${trade.projectNum}"/></td>
                        <td><c:out value="${trade.projectYear}"/></td>
                        <td><c:out value="${trade.depart}"/></td>
                        <td><c:out value="${trade.projectName}"/></td>
                        <td><c:out value="${trade.zaasCode}"/></td>
                        <td><fmt:formatDate value="${trade.startDate}" type="date"/></td>
                        <td><fmt:formatDate value="${trade.endDate}" type="date"/></td>
                        <td><c:out value="${trade.intentionAmount}"/></td>
                        <td>
                            <input type="button" value="修改" id="editBt" title="edit this" onclick="doEdit(<c:out value="${trade.id}"/>)"/>
                            <input type="button" value="删除" id="delBt" title="del this" onclick="doDel(<c:out value="${trade.id}"/>)"/>
                            <input type="button" value="提交" id="submitBt" title="submit to editor"onclick="doSubmit(<c:out value="${trade.id}"/>)"/>
                        </td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>


    </div>
</body>
<script type="application/javascript">
    function doEdit(id){
        window.location.href = "edit.do?id="+id;
    }
    function doDel(id){
        window.location.href = "del.do?id="+id;
    }
    function doSubmit(id){
        window.location.href = "submit.do?id="+id;
    }
</script>
</html>
