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
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>51农业技术</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="../../resources/vendor/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="../../resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../../resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../../resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../../resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!--Style css-->
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.do">51农业技术-浙江省农业科学院成果转化与四技服务管理信息系统</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">

                    <li>
                        <a href="/user/loginOut.do"><i class="fa fa-sign-out fa-fw"></i>登出</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <li >
                        <a href="/index.do">
                            <i class="fa fa-home"></i>&nbsp;&nbsp;主页</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);"><i class="fa fa-refresh"></i>&nbsp;&nbsp;&nbsp;成果转化<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/trade/list.do?codeType=A1">&nbsp;&nbsp;技术转让-专利权</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A2">&nbsp;&nbsp;技术转让-专利申请权</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A3">&nbsp;&nbsp;技术转让-专利实施许可</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A4">&nbsp;&nbsp;技术转让-技术秘密</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="javascript:void(0);"><i class="fa fa-bar-chart-o fa-fw"></i>&nbsp;&nbsp;技术开发<span class="fa arrow"></span></a>

                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/trade/list.do?codeType=K1">&nbsp;&nbsp;合作开发</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=K2">&nbsp;&nbsp;委托开发</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);"><i class="fa fa-edit fa-fw"></i>&nbsp;&nbsp;技术服务</a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/trade/list.do?codeType=F1">&nbsp;&nbsp;技术服务（非检测）</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=J1">&nbsp;&nbsp;检测服务</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="/trade/list.do?codeType=Z1"><i class="fa fa-comment-o"></i>&nbsp;&nbsp;技术咨询</a>
                    </li>
                    <li>
                        <a href="/trade/list.do?codeType=P1"><i class="fa fa-group"></i>&nbsp;&nbsp;技术培训</a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">
                    <a href="/trade/list.do?codeType=J1">检测服务</a>&nbsp;

                </h3>

                <!-- /input-group -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        零散检测单季度上传
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">

                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <%--@declare id="exampleinputname2"--%><label for="exampleInputName2">
                                        年份
                                    </label>
                                        <select id="year_select" class="form-control" name="year"></select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">
                                        季度
                                    </label>
                                    <select id="quarter_select" name="quarter" class="form-control">
                                        <option value="第一季度">第一季度</option>
                                        <option value="第二季度">第二季度</option>
                                        <option value="第三季度">第三季度</option>
                                        <option value="第四季度">第四季度</option>
                                    </select>
                                    <span id="quarter_tips" class="danger"></span>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">请选择文件路径</label>
                                    <input type="file" id="myfile" name="myfile" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">备注</label>
                                    <textarea  id="remarks" class="form-control" name="mydata"  rows="8"></textarea>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <input type="button" class="btn-default" value="返回"/>&nbsp;&nbsp;
                                <input type="button" class="btn-primary" id="submit" value="上传" onclick="upload();"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">
                                        <span id="tips"></span>
                                    </label>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../../resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../../resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../../resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../../resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!--bootstrap-datetimepicker-master-->
<script src="../../resources/vendor/bootstrap-datetimepicker-master/bootstrap-datetimepicker.min.js"></script>
<script src="../../resources/vendor/bootstrap-datetimepicker-master/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- Custom Theme JavaScript -->
<script src="../../resources/dist/js/sb-admin-2.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->


</body>
<script>
    $(document).ready(
        function () {
            addYearSelect();
            checkChildExist();
        }
    );

    function addYearSelect() {
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for (var i = nowYear; i > 2010; i--) {
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
        formData.append("myfile", $("#myfile").get(0).files[0]);
        formData.append("year", $("#year_select").val());
        formData.append("quarter", $("#quarter_select").val());
        formData.append("remarks", $("#remarks").val());

        if($("#myfile").val()==null||$("#myfile").val()==""){
            $("#tips").html("您还没有选择文件");
            return false;
        }
        $("#tips").html("正在上传中,请稍等....");

        $.ajax({
            type: 'POST',
            url: "childImport.do",
            cache: false,
            data: formData,
            dataType: "json",
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
            processData: false,  // 告诉jQuery不要去处理发送的数据
            success: function (data) {
                $("#tips").html("上传成功，本次共上传了" + data.childCount + "条记录,共"+data.tradeIntentionAmount+"元");
            }
        });
    }

    function checkChildExist() {
        $("#quarter_tips").html("");
        var year = $("#year_select").val();
        var quarter = $("#quarter_select").val();
        $.post("checkChildExist.do", {year: year, quarter: quarter}, function (date) {
            if (date.tradeCount > 0) {
                $("#quarter_tips").html("数据库中已存在当前季度提交状态后的记录，请先撤回提交，再进行替换操作。");
                $("#submit").attr("disabled", true);
            } else {
                $("#submit").removeAttr("disabled", true);
            }
        }, "json");
    }
</script>

</html>