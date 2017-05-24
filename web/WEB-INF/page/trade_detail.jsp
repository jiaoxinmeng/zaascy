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
                        <a href="loginOut.do"><i class="fa fa-sign-out fa-fw"></i>登出</a>
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
                        <a href="/trade/newFirst.do">
                            <i class="fa fa-home"></i>&nbsp;&nbsp;录入项目</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-refresh"></i>&nbsp;&nbsp;&nbsp;技术转让<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/trade/list.do?codeType=A1">&nbsp;&nbsp;专利权</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A2">&nbsp;&nbsp;专利申请权</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A3">&nbsp;&nbsp;专利实施许可</a>
                            </li>
                            <li>
                                <a href="/trade/list.do?codeType=A4">&nbsp;&nbsp;技术秘密</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>&nbsp;&nbsp;技术开发<span class="fa arrow"></span></a>

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
                        <a href="/trade/list.do?codeType=F1"><i class="fa fa-edit fa-fw"></i>&nbsp;&nbsp;技术服务</a>
                    </li>
                    <li>
                        <a href="/trade/list.do?codeType=J"><i class="fa fa-flask"></i>&nbsp;&nbsp;&nbsp;检测服务</a>

                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/trade/list.do?codeType=J1">&nbsp;&nbsp;检测项目</a>
                            </li>
                            <li>
                                <a href="/trade/goChildImport.do">&nbsp;&nbsp;零散检测单导入</a>
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
                        详情页面
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-10 col-lg-offset-1">
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <%--@declare id="exampleinputemail2"--%><label for="exampleInputEmail2">项目编号</label>&nbsp;&nbsp;${trade.projectNum}
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">院成果技术编码</label>&nbsp;&nbsp;${trade.zaasCode}
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">其他相关成果技术编码</label>&nbsp;
                                        <c:forEach items="${otherZaasCodes}" var="tradeSubsidiary" >
                                            ${tradeSubsidiary.zaasCode}&nbsp;&nbsp;
                                        </c:forEach>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">项目名称</label>
                                        <div>${trade.projectName}</div>

                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <%--@declare id="exampleinputname2"--%><label for="exampleInputName2">年份</label>
                                                <div>${trade.projectYear}</div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">项目类别</label>
                                                <div>${trade.projectType}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">单位</label>
                                                <div>${trade.depart}</div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">项目负责人</label>
                                                <div>${trade.projectPerson}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">让与/承担单位</label>
                                                <div>${trade.departFullName}</div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">委托/受让单位</label>
                                                <div>${trade.customerDepart}</div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">其他合作单位</label>
                                                <div>${trade.customerDepart}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">起始年月</label>
                                                <div><fmt:formatDate value="${trade.startDate}" dateStyle="medium" type="date"/></div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">终止年月</label>
                                                <div><fmt:formatDate value="${trade.endDate}" dateStyle="medium" type="date"/></div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">意向总金额（元）</label>
                                                <div>${trade.intentionAmount}</div>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputEmail2">签约总金额（元）</label>
                                                <div>${trade.signAmount}</div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">项目基本情况介绍（委托/受让单位、项目内容等，可公开，限200字）</label>
                                        <div>
                                            ${trade.projectSummary}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">意向总金额与付款方式说明</label>
                                        <div>
                                            ${trade.intentionAmountExplain}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">备注</label>
                                        <div>
                                            ${trade.remarks}
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-lg-offset-5 col-md-offset-6  col-sm-offset-6">

                                <input class="btn btn-primary" type="button" value="返回列表" onclick="doList()"/>

                                <c:if test="${isSubmitor and (editEnable or (departEditEnable and (adminDepartId==adminDepartId)))}">
                                    <input class="btn btn-primary" type="button" value="提交" id="submitBt" title="submit to editor"onclick="doSubmit(<c:out value="${trade.id}"/>)"/>
                                </c:if>
                                <c:if test="${isAssessor and (editEnable or (departEditEnable and (adminDepartId==adminDepartId)))}">
                                    <input class="btn btn-primary" type="button" value="审核通过" id="accessBt" title="submit to editor"onclick="doAccess(<c:out value="${trade.id}"/>)"/>
                                    <input class="btn btn-primary" type="button" value="退回" id="backBt" title="submit to editor"onclick="doBack(<c:out value="${trade.id}"/>)"/>
                                </c:if>

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
    function doList() {
        window.location.href = "list.do?codeType=" + ${codeType};
    }

    function doSubmit(id){

    }
    function doAccess(id){

    }
    function doBack(id){

    }
</script>

</html>