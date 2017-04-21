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
    <script type="application/javascript" src="/resources/js/jquery.js"></script>
    <script>
        $(document).ready(
            function() {
                addYearSelect();
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

        function upload() {
            var formData = new FormData();
            formData.append("myfile",$("#myfile").get(0).files[0]);
            formData.append("year",$("#year_select").val());
            formData.append("quarter",$("#quarter_select").val());
            formData.append("mydata",$("#mydata").val());
            $.ajax({
                type:'POST',
                url:"childImport.do",
                cache: false,
                data: formData,
                contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
                processData: false,  // 告诉jQuery不要去处理发送的数据
                success: function(data){
                    alert("success");
                }
            });
        }
    </script>
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
                            <option value="spring">春季</option>
                            <option value="summer">夏季</option>
                            <option value="autumn">秋季</option>
                            <option value="winter">冬季</option>
                        </select>
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
                        <input type="text" id="mydata" name="mydata" value=""/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" id="submit" value="上传" onclick="upload()"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
