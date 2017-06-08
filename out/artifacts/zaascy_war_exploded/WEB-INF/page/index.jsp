<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 10:36
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
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources//vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!--Style css-->
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

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
                <h3 class="page-header"><c:out value="${sessionScope.get('user').xingm}"/>，欢迎您登陆！</h3>

                <!-- /input-group -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-refresh fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${A_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>技术转让</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=A">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-bar-chart-o fa-fw fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${K_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>技术开发</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=K">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-edit fa-fw fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${F_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>技术服务</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=F1">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-red">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-flask fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${J_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>检测服务</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=J1">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-comment-o fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${Z_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>技术咨询</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=Z1">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-group fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge"><c:out value="${P_count}"/>&nbsp;<small>项</small></div>
                                <div>
                                    <h4>技术培训</h4></div>
                            </div>
                        </div>
                    </div>
                    <a href="/trade/list.do?codeType=P1">
                        <div class="panel-footer">
                            <span class="pull-left">查看详情</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-bar-chart-o fa-fw"></i> 数据统计

                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div id="morris-area-chart">
                            <table id="myTable1">
                                <caption>
                                    总体数据统计
                                </caption>
                                <thead>
                                <tr>
                                    <th>农发所</th>
                                    <th>数农所</th>
                                    <th>亚作所</th>
                                    <th>园艺所</th>
                                    <th>植微所</th>
                                    <th>质标所</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th></th>
                                    <th>6</th>
                                    <th>1</th>
                                    <th>1</th>
                                    <th>1</th>
                                    <th>2</th>
                                    <th>4</th>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->

                <!-- /.panel -->
            </div>
            <!-- /.col-lg-8 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript
<script src="/resources/vendor/raphael/raphael.min.js"></script>
<script src="/resources/vendor/morrisjs/morris.min.js"></script>
-->

<script type="text/javascript" src="/resources/js/jsapi.js"></script>
<script type="text/javascript" src="/resources/js/corechart.js"></script>
<script type="text/javascript" src="/resources/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.ba-resize.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

</body>
<script>
    gvChartInit();
    $(document).ready(function(){
        $("#myTable1").gvChart({
            chartType: 'PieChart',
            gvSettings: {
                vAxis: {title: 'No of players'},
                hAxis: {title: 'Month'},
                width: 500,
                height: 350
            }
        });
    });
</script>
</html>
