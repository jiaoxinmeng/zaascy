<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
    <div>
        <form id="upform" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td>请选择年份</td>
                    <td>
                        <select id="year_select" name="year"></select>
                    </td>
                </tr>
                <tr>
                    <td>请选择季度</td>
                    <td>
                        <select id="quarter_select" name="quarter">
                            <option value="第一季度">第一季度</option>
                            <option value="第二季度">第二季度</option>
                            <option value="第三季度">第三季度</option>
                            <option value="第四季度">第四季度</option>
                        </select>
                        <span id="quarter_tips"></span>
                    </td>
                </tr>
                <tr>
                    <td>请选择文件路径</td>
                    <td>
                        <input type="file" id="myfile" name="myfile" value=""/>
                    </td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td>
                        <input type="text" id="remarks" name="mydata" value=""/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" id="submit" value="上传" onclick="upload()"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span id="tips"></span>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>

<script>
    $(document).ready(
        function() {
            addYearSelect();
            checkChildExist();
        }
    );

    function addYearSelect(){
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for(var i = nowYear;i>2010;i--){
            $("#year_select").append(
                "<option value='" + i + "'>" + i + "</option>");
        }
    }
    
    $("#year_select").change(function () {
        checkChildExist();
    });

    $("#quarter_select").change(function () {
        checkChildExist();
    });

    function upload() {
        var formData = new FormData();
        formData.append("myfile",$("#myfile").get(0).files[0]);
        formData.append("year",$("#year_select").val());
        formData.append("quarter",$("#quarter_select").val());
        formData.append("remarks",$("#remarks").val());

        $("#tips").html("正在上传中,请稍等....");

        $.ajax({
            type:'POST',
            url:"childImport.do",
            cache: false,
            data: formData,
            dataType: "json",
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
            processData: false,  // 告诉jQuery不要去处理发送的数据
            success: function(data){
                $("#tips").html("上传成功，本次共上传了" + data.childCount + "条记录");
            }
        });
    }
    
    function checkChildExist() {
        $("#quarter_tips").html("");
        var year = $("#year_select").val();
        var quarter = $("#quarter_select").val();
        $.post("checkChildExist.do",{year:year,quarter:quarter},function(date){
            if(date.tradeCount>0){
                $("#quarter_tips").html("数据库中已存在当前季度提交状态后的记录，请先撤回提交，再进行替换操作。");
                $("#submit").attr("disabled",true);
            }else{
                $("#submit").removeAttr("disabled",true);
            }
        },"json");
    }
</script>
</html>
