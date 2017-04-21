
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>trade edit jsp</title>
    <link rel="stylesheet" href="/resources/css/dropify.css">
    <script charset="utf-8" src="/resources/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/resources/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="/resources/kindeditor/plugins/code/prettify.js"></script>
    <script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="/resources/js/jquery.form.min.js" type="text/javascript"></script>
    <script src="/resources/js/dropify.min.js"></script>
    <script src="/resources/laydate/laydate.js"></script>
</head>
<body>
    <div>
        <form action="save.do" method="post" >
            <table>
                <tr>
                    <td>项目编号</td>
                    <td>
                        <input type="text" name="projectNum" value="${trade.projectNum}"/>
                    </td>
                    <td>年份</td>
                    <td>
                        <select id="year_select" name="projectYear"></select>
                    </td>
                </tr>
                <tr>
                    <td>单位</td>
                    <td>
                        <select id="depart_select" name="departId">
                            <c:forEach items="${departList}" var="depart">
                                <option value="<c:out value="${depart.danwId}"/>"><c:out value="${depart.danwjc}"/></option>
                            </c:forEach>
                        </select>
                        <input type="hidden" id="depart_name" name="depart" value="${trade.depart}"/>
                    </td>
                    <td>项目负责人</td>
                    <td>
                        <input type="text" name="projectPerson" value="${trade.projectPerson}"/>
                    </td>

                </tr>
                <tr>
                    <td>项目类别</td>
                    <td>
                        <select id="projectType_select" name="projectTypeCode">
                            <c:forEach items="${projectTypeList}" var="re">
                                <option value="<c:out value="${re.key}"/>"><c:out value="${re.value}"/></option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="projectType" id="projectType" value="${trade.projectType}"/>
                    </td>
                    <td>院成果技术类型</td>
                    <td>
                        <select id="zaasTechType_select" name="zaasTechType" >
                            <c:forEach items="${zaasTechTypeList}" var="re">
                                <option value="<c:out value="${re.key}"/>"><c:out value="${re.value}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>项目名称</td>
                    <td>
                        <input type="text" name="projectName" value="${trade.projectName}"/>
                    </td>
                    <td>院成果技术编码</td>
                    <td>
                        <input type="text" id="zaasCode" name="zaasCode" value="${trade.zaasCode}"/>
                    </td>
                </tr>
                <tr>
                    <td>委托/受让单位全称</td>
                    <td>
                        <input type="text" name="customerDepart" value="${trade.customerDepart}"/>
                    </td>
                    <td>让与/承担单位全称</td>
                    <td>
                        <input type="text" name="departFullName" value="${trade.departFullName}"/>
                    </td>
                </tr>

                <tr>
                    <td>起始年月</td>
                    <td>
                        <input type="text" id="startDate" name="startDate" class="laydate-icon" value="<fmt:formatDate value="${trade.startDate}" type="date"/>"/>
                    </td>
                    <td>终止年月</td>
                    <td>
                        <input type="text" id="endDate" name="endDate" class="laydate-icon" value="<fmt:formatDate value="${trade.endDate}" type="date"/>"/>
                    </td>
                </tr>
                <tr>
                    <td>项目内容简介（可公开）</td>
                    <td colspan="3">
                        <textarea type="text" name="projectSummary">${trade.projectSummary}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>意向总金额（万元）</td>
                    <td>
                        <input type="text" name="intentionAmount" value="${trade.intentionAmount}"/>
                    </td>
                    <td>签约总金额（万元）</td>
                    <td>
                        <input type="text" name="signAmount" value="${trade.signAmount}"/>
                    </td>
                </tr>
                <tr>
                    <td>意向金额与付款方式说明</td>
                    <td colspan="3">
                        <textarea type="text" name="intentionAmountExplain">${trade.intentionAmountExplain}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td colspan="3">
                        <textarea type="text" name="remarks">${trade.remarks}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="保存">
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
<script type="application/javascript">

    $(document).ready(
        function() {
            addYearSelect();
            $("#year_select").val(${trade.projectYear});
            $("#depart_select").val(${trade.departId})
            $("#projectType_select").val(${trade.projectTypeCode});
            $("#zaasTechType_select").val(${trade.zaasTechType});


        }
    );

    $("#editBt").click(function (){
        window.location.href = "edit.do";
    });

    $("#depart_select").change(function () {
        //alert($("#depart_select").find("option:selected").text());
        $("#depart_name").val($("#depart_select").find("option:selected").text());
    });

    $("#projectType_select").change(function () {
        //alert($("#depart_select").find("option:selected").text());
        $("#projectType").val($("#projectType_select").find("option:selected").text());
    });

    KindEditor.ready(function(K) {
        var editor1 = K.create('textarea[name="projectSummary"]', {
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist']
        });

        var editor2 = K.create('textarea[name="intentionAmountExplain"]', {
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist']
        });

        var editor3 = K.create('textarea[name="remarks"]', {
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist']
        });
    });

    laydate( {
        elem : '#startDate',event: 'focus'
    });
    laydate( {
        elem : '#endDate',event: 'focus'
    });

    function addYearSelect(){
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for(var i = nowYear;i>2010;i--){
            $("#year_select").append(
                "<option value='" + i + "'>" + i + "</option>");
        }
    }
</script>
</html>
