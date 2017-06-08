<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/27
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>成果转化审核表-打印</title>
    <link rel="stylesheet" href="../../resources/css/print.css" />

</head>

<body>
<div class="print-table" id="print-table">
    <div class="table-index">
        <div class="" style="float: left;padding-top:20px;">${trade.projectNum}</div><img src="../singlecode/${trade.projectYear}/${trade.oneCode}.jpg" width=200px/>
    </div>

    <div class="table-header">
        浙江省农业科学院科技成果转化合同审核表
    </div>
    <div class="table-sub">
        <div class="table-sub-depart">申请单位（盖章）：</div>
        <div class="table-sub-date">申请日期：</div>
    </div>
    <div class="table-content">
        <table class="table-t" cellpadding="0" cellspacing="0">
            <tbody>
            <tr class="table-1">
                <td width="130px" class="table-first-1">成果名称</td>
                <td width="300px">
                    <div class="title" id="title">${trade.projectName}</div>
                </td>
                <td width="100px" class="table-first-3">拟转化金额<br>（万元）</td>
                <td width="100px" class="table-td-right money">${trade.intentionAmount/10000}</td>
            </tr>
            <tr class="table-2" height="150px">
                <td class="table-second-1">转化基本情况<br>介绍（主要阐述受让单位、<br>成果简介、成果排名等）</td>
                <td colspan="3" class="table-td-right " >
                    <div class="content" id="content">${trade.projectSummary}</div>
                </td>
            </tr>
            <tr class="table-3" style="height:80px;">
                <td class="table-second-1">研究室或<br>课题组意见</td>
                <td colspan="3" class="table-td-right">
                    <div class="sign-1">负责人（签字）：</div>
                </td>
            </tr>
            <tr class="table-4">
                <td class="table-second-1">研究所意见</td>
                <td colspan="3" class="table-td-right">
                    <div class="sign-2">
                        <div class="sign-2-1">
                            <div style="float: right;padding-top:40px;padding-right:160px;">经办人（签字）：</div>
                        </div>
                        <div class="sign-2-2">
                            <div style="float: right;padding-top:40px;padding-right:160px;">负责人（签字）：</div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr class="table-4">
                <td class="table-second-1">科技推广与<br>产业处意见</td>
                <td colspan="3" class="table-td-right">
                    <div class="sign-2">
                        <div class="sign-2-1">
                            <div style="float: right;padding-top:40px;padding-right:160px;">经办人（签字）：</div>
                        </div>
                        <div class="sign-2-2">
                            <div style="float: right;padding-top:40px;padding-right:160px;">负责人（签字）：</div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr class="table-7" style="height:80px;">
                <td class="table-second-1">分管院领导<br>意&nbsp;&nbsp;&nbsp;&nbsp;见</td>
                <td colspan="3" class="table-td-right">
                    <div class="sign-1">分管院长（签字）：</div>
                </td>
            </tr>
            <tr class="table-7" style="height:80px;">
                <td class="table-second-1">院长意见</td>
                <td colspan="3" class="table-td-right">
                    <div class="sign-1">院长（签字）：</div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="example example-5" id="biuuu_button">
    <input type="button"  value="print" />
</div>
</body>

<script src="../../resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../../resources/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript" src="../../resources/js/jquery.PrintArea.js" ></script>
<script language="javascript">
    $("div#biuuu_button").click(function(){

        var  title_num = $("#title").text().length;
        var content_num = $("#content").text().length;

        //alert(title_num+" "+content_num);

        $("div#print-table").printArea();
    });
</script>

</html>