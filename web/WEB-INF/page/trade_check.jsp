<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>check zaasCode</title>
    <script src="/resources/js/jquery-1.8.1.min.js" type="text/javascript"></script>
</head>
<body>
    <div>
        <table>
            <tr>
                <td colspan="6">请选择本次转化交易标相关的院成果技术编码（尚未取得编码的请先完成成果填报工作）</td>
            </tr>
            <tr>
                <td>成果技术类型</td>
                <td>
                    <select id="zaasTechType_select">
                        <c:forEach items="${zaasTechTypeList}" var="re">
                            <option value="<c:out value="${re.key}"/>"><c:out value="${re.value}"/></option>
                        </c:forEach>
                    </select>
                </td>
                <td>年份</td>
                <td>
                    <select id="year_select">
                        <option value="0">全部</option>
                    </select>
                </td>
                <td>单位</td>
                <td>
                    <select id="depart_select">
                        <option value="0">全院</option>
                        <c:forEach items="${departList}" var="depart">
                            <option value="<c:out value="${depart.danwId}"/>"><c:out value="${depart.danwjc}"/></option>
                        </c:forEach>
                    </select>
                </td>


            </tr>
            <tr>
                <td>成果技术编码</td>
                <td>
                    <select id="zaasCode_select"></select>
                </td>
                <td>成果技术名称</td>
                <td colspan="3">
                    <span id="zaastechName"></span>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <span id="mis_pass" style="color: #008800"></span>
                    <span id="mis_not_pass" style="color: #D91600"></span>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <span id="51nyjs_pass" style="color: #008800"></span>
                    <span id="51nyjs_not_pass" style="color: #D91600"></span>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <span id="span_text"></span>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <input type="button" id="bt_next" value="下一步" disabled="disabled"/>
                </td>
            </tr>
        </table>
    </div>
</body>
<script type="application/javascript">

    $(document).ready(
        function() {
            addYearSelect();
            $("#depart_select").val(${departId});
            $("#zaasTechType_select").change();
        }
    );

    $("#zaasTechType_select").change(function () {

        $("#zaasCode_select").empty();
        $("#span_text").html("");

        var year = $("#year_select").val();
        var departId = $("#depart_select").val();
        var zaasTechType = $("#zaasTechType_select").val();
        //$("#span_text").html(zaasTechType+"--"+departId+"--"+year);

        if(zaasTechType=="软件著作权"||zaasTechType=="颁布标准"){
            $("#depart_select").val(0);
            departId = 0 ;
            $("#depart_select").attr("disabled",true);

        }else{
            $("#depart_select").removeAttr("disabled",true);
        }

        $.post("getZaasCodeList.do",{zaasTechType:zaasTechType,departId:departId,year:year},function(date){

            if(date.size!=0){
                $.each(date.list, function(i, item) {
                    $("#zaasCode_select").append(
                        "<option value='" + item + "'>" + item + "</option>");
                });
            }else{
                $("#span_text").html("搜索完毕，没有找到相关记录。");
            }
            $("#zaasCode_select").change();

        },"json");


    });

    $("#depart_select").change(function () {
        $("#zaasCode_select").empty();
        $("#span_text").html("");
        var year = $("#year_select").val();
        var departId = $("#depart_select").val();
        var zaasTechType = $("#zaasTechType_select").val();
        //$("#span_text").html(zaasTechType+"--"+departId+"--"+year);
        $.post("getZaasCodeList.do",{zaasTechType:zaasTechType,departId:departId,year:year},function(date){
            if(date.size!=0){
                $.each(date.list, function(i, item) {
                    $("#zaasCode_select").append(
                        "<option value='" + item + "'>" + item + "</option>");
                });
            }else{
                $("#span_text").html("搜索完毕，没有找到相关记录。");
            }
            $("#zaasCode_select").change();
        },"json");
    });

    $("#year_select").change(function () {
        $("#zaasCode_select").empty();
        $("#span_text").html("");
        var year = $("#year_select").val();
        var departId = $("#depart_select").val();
        var zaasTechType = $("#zaasTechType_select").val();
        //$("#span_text").html(zaasTechType+"--"+departId+"--"+year);
        $.post("getZaasCodeList.do",{zaasTechType:zaasTechType,departId:departId,year:year},function(date){
            if(date.size!=0){
                $.each(date.list, function(i, item) {
                    $("#zaasCode_select").append(
                        "<option value='" + item + "'>" + item + "</option>");
                });


            }else{
                $("#span_text").html("搜索完毕，没有找到相关记录。");
            }
            $("#zaasCode_select").change();
        },"json");
    });

    $("#zaasCode_select").change(function () {
        var njy = false;
        var mis = false;
        $("#51nyjs_not_pass").html("");
        $("#51nyjs_pass").html("");
        $("#mis_not_pass").html("");
        $("#mis_pass").html("");
        $("#zaastechName").html("");
        var zaasCode = $("#zaasCode_select").val();
        if(zaasCode.length<4){return false;}
        $.post("getTechName.do",{zaasCode:zaasCode},function(date){

            if(date.name_njy==null||date.name_njy==""){
                $("#51nyjs_not_pass").html("×“51农业技术”平台中未发布，请先向平台管理员提供图文资料。");
            } else {
                $("#51nyjs_pass").html("√“51农业技术”平台中已发布");
                njy = true;
            }

            if($("#zaasTechType_select").val()=="实用技术"){
                mis = true;
            }else if(date.name_mis==null||date.name_mis==""){
                $("#mis_not_pass").html("×院MIS系统科研成果库未收录，请补齐相关记录。");
            } else {
                $("#mis_pass").html("√院MIS系统科研成果库已收录");
                mis = true;
            }

            if(date.name_njy==null||date.name_njy==""){
                $("#zaastechName").html(date.name_mis);
            } else {
                $("#zaastechName").html(date.name_njy);
            }

            if(njy && mis){
                $("#bt_next").removeAttr("disabled",true);
                $("#zaastechName").html(date.name_njy);
            }else if(njy){
                $("#zaastechName").html(date.name_njy);
                $("#bt_next").attr("disabled",true);
            }else{
                $("#zaastechName").html(date.name_mis);
            }


        },"json");
    });

    $("#bt_next").click(function () {
       window.location.href = "newNext.do?"+$("#zaasCode_select").val();
    });

    function addYearSelect(){
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for(var i = nowYear;i>2000;i--){
            $("#year_select").append(
                "<option value='" + i + "'>" + i + "</option>");
        }
        $("#year_select").val((nowYear-1));
    }
</script>
</html>
