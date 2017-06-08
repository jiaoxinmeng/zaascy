<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/17
  Time: 16:35
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
                    <input class="btn btn-primary" type="button" value="返回列表" onclick="doList()"/>
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
                        ${projectName}&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;到款明细
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-10 col-lg-offset-1">
                                <form id="fundsForm" action="/funds/save.do" class="form-horizontal" method="post">
                                    <div class="form-group">
                                        <c:choose>
                                            <c:when test="${funds!=null&&funds.id!=null}">
                                                <input type="hidden" name="id" value="${funds.id}"/>
                                                <input type="hidden" name="projectId" value="${funds.projectId}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="hidden" name="projectId" value="${projectId}"/>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <label for="exampleInputName2">到款年份</label>
                                                <select id="year_select" name="year"></select>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">到款日期</label>
                                                <div class='input-group date' id='datetimepicker1'>
                                                    <input type="text" name="date" class="form-control" value="<fmt:formatDate value="${funds.date}" dateStyle="medium" type="date"/>"/>
                                                    <span class="input-group-addon">
			                    <span class="glyphicon glyphicon-calendar"></span>
															</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">付款单位</label>
                                                <input type="text" id="depart" name="depart" class="form-control" value="${funds.depart}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">到款金额（元）</label>
                                                <input type="text" id="funds" name="funds" class="form-control" value="${funds.funds}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">备注</label>
                                        <textarea class="form-control" name="remarks" rows="8">${funds.remarks}</textarea>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-lg-offset-5 col-md-offset-6  col-sm-offset-6">
                                <button type="button" class="btn btn-default" onclick="doList()">关闭</button>&nbsp;&nbsp;
                                <input type="button" id="submitBt" class="btn btn-primary" value="保存" />
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
<script>
    //页面加载完成时执行
    $(document).ready(
        function() {
            //添加year下拉框
            addYearSelect();

            //初始化日期插件
            $('#datetimepicker1').datetimepicker({
                language: 'zh-CN',
                format: 'yyyy-mm-dd',//显示格式
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                initialDate: new Date(),//初始化当前日期
            });

            if(${funds.year!=null}){
                $("#year_select").val(${funds.year});
            }

            if(${funds.depart==null and customerDepart!=null}){
                $("#depart").val("${customerDepart}");
            }
        }
    );

    $("#submitBt").click(function () {
        $("#fundsForm").submit();
    });

    $("#funds").blur(function () {
        var funds = $("#funds").val();
        funds = Number(funds).toFixed(2);
        $("#funds").val(funds);
        var funds_cn = Arabia_to_Chinese(funds);
        $("#funds").attr("title",funds_cn);
    });
    
    function doList() {
        window.location.href = "list.do?projectId=${projectId}&codeType=${codeType}";
    }

    function addYearSelect(){
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for(var i = nowYear;i>2000;i--){
            $("#year_select").append(
                "<option value='" + i + "'>" + i + "</option>");
        }
    }
    function Arabia_to_Chinese(Num) {
        for (i = Num.length - 1; i >= 0; i--) {
            Num = Num.replace(",", "")//替换tomoney()中的“,”
            Num = Num.replace(" ", "")//替换tomoney()中的空格
        }
        Num = Num.replace("￥", "")//替换掉可能出现的￥字符
        if (isNaN(Num)) { //验证输入的字符是否为数字
            alert("请检查小写金额是否正确");
            return;
        }
        //---字符处理完毕，开始转换，转换采用前后两部分分别转换---//
        part = String(Num).split(".");
        newchar = "";
        //小数点前进行转化
        for (i = part[0].length - 1; i >= 0; i--) {
            if (part[0].length > 10) { alert("位数过大，无法计算"); return ""; } //若数量超过拾亿单位，提示
            tmpnewchar = ""
            perchar = part[0].charAt(i);
            switch (perchar) {
                case "0": tmpnewchar = "零" + tmpnewchar; break;
                case "1": tmpnewchar = "壹" + tmpnewchar; break;
                case "2": tmpnewchar = "贰" + tmpnewchar; break;
                case "3": tmpnewchar = "叁" + tmpnewchar; break;
                case "4": tmpnewchar = "肆" + tmpnewchar; break;
                case "5": tmpnewchar = "伍" + tmpnewchar; break;
                case "6": tmpnewchar = "陆" + tmpnewchar; break;
                case "7": tmpnewchar = "柒" + tmpnewchar; break;
                case "8": tmpnewchar = "捌" + tmpnewchar; break;
                case "9": tmpnewchar = "玖" + tmpnewchar; break;
            }
            switch (part[0].length - i - 1) {
                case 0: tmpnewchar = tmpnewchar + "元"; break;
                case 1: if (perchar != 0) tmpnewchar = tmpnewchar + "拾"; break;
                case 2: if (perchar != 0) tmpnewchar = tmpnewchar + "佰"; break;
                case 3: if (perchar != 0) tmpnewchar = tmpnewchar + "仟"; break;
                case 4: tmpnewchar = tmpnewchar + "万"; break;
                case 5: if (perchar != 0) tmpnewchar = tmpnewchar + "拾"; break;
                case 6: if (perchar != 0) tmpnewchar = tmpnewchar + "佰"; break;
                case 7: if (perchar != 0) tmpnewchar = tmpnewchar + "仟"; break;
                case 8: tmpnewchar = tmpnewchar + "亿"; break;
                case 9: tmpnewchar = tmpnewchar + "拾"; break;
            }
            newchar = tmpnewchar + newchar;
        }
        //小数点之后进行转化
        if (Num.indexOf(".") != -1) {
            if (part[1].length > 2) {
                alert("小数点之后只能保留两位,系统将自动截段");
                part[1] = part[1].substr(0, 2)
            }
            for (i = 0; i < part[1].length; i++) {
                tmpnewchar = ""
                perchar = part[1].charAt(i)
                switch (perchar) {
                    case "0": tmpnewchar = "零" + tmpnewchar; break;
                    case "1": tmpnewchar = "壹" + tmpnewchar; break;
                    case "2": tmpnewchar = "贰" + tmpnewchar; break;
                    case "3": tmpnewchar = "叁" + tmpnewchar; break;
                    case "4": tmpnewchar = "肆" + tmpnewchar; break;
                    case "5": tmpnewchar = "伍" + tmpnewchar; break;
                    case "6": tmpnewchar = "陆" + tmpnewchar; break;
                    case "7": tmpnewchar = "柒" + tmpnewchar; break;
                    case "8": tmpnewchar = "捌" + tmpnewchar; break;
                    case "9": tmpnewchar = "玖" + tmpnewchar; break;
                }
                if (i == 0) tmpnewchar = tmpnewchar + "角";
                if (i == 1) tmpnewchar = tmpnewchar + "分";
                newchar = newchar + tmpnewchar;
            }
        }
        //替换所有无用汉字
        while (newchar.search("零零") != -1)
            newchar = newchar.replace("零零", "零");
        newchar = newchar.replace("零亿", "亿");
        newchar = newchar.replace("亿万", "亿");
        newchar = newchar.replace("零万", "万");
        newchar = newchar.replace("零元", "元");
        newchar = newchar.replace("零角", "");
        newchar = newchar.replace("零分", "");

        if (newchar.charAt(newchar.length - 1) == "元" || newchar.charAt(newchar.length - 1) == "角")
            newchar = newchar + "整"
        //  document.write(newchar);
        return newchar;

    }
</script>

</body>

</html>