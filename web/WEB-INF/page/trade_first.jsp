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
            <a class="navbar-brand" href="index.html">51农业技术-浙江省农业科学院成果转化与四技服务管理信息系统</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li>
                        <a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="/user/loginOut"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                    <c:if test="${codeType=='A'}"><a href="/trade/list.do?codeType=${codeType}">技术转让</a>&nbsp;</c:if>
                    <c:if test="${codeType=='A1'}"><a href="/trade/list.do?codeType=${codeType}">技术转让</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">专利权</a></c:if>
                    <c:if test="${codeType=='A2'}"><a href="/trade/list.do?codeType=${codeType}">技术转让</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">专利申请权</a></c:if>
                    <c:if test="${codeType=='A3'}"><a href="/trade/list.do?codeType=${codeType}">技术转让</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">专利实施许可</a></c:if>
                    <c:if test="${codeType=='A4'}"><a href="/trade/list.do?codeType=${codeType}">技术转让</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">技术秘密</a></c:if>
                    <c:if test="${codeType=='K'}"><a href="/trade/list.do?codeType=${codeType}">技术开发</a>&nbsp;</c:if>
                    <c:if test="${codeType=='K1'}"><a href="/trade/list.do?codeType=${codeType}">技术开发</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">合作</a></c:if>
                    <c:if test="${codeType=='K2'}"><a href="/trade/list.do?codeType=${codeType}">技术开发</a>&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;<a href="/trade/list.do?codeType=${codeType}">委托</a></c:if>
                    <c:if test="${codeType=='F1'}"><a href="/trade/list.do?codeType=${codeType}">技术服务</a>&nbsp;</c:if>
                    <c:if test="${codeType=='J1'}"><a href="/trade/list.do?codeType=${codeType}">检测服务</a>&nbsp;</c:if>
                    <c:if test="${codeType=='Z1'}"><a href="/trade/list.do?codeType=${codeType}">技术咨询</a>&nbsp;</c:if>
                    <c:if test="${codeType=='P1'}"><a href="/trade/list.do?codeType=${codeType}">技术培训</a>&nbsp;</c:if>
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
                        新增>>第一步
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form id="firstForm" action="/trade/newNext.do" class="form-horizontal" method="post">
                        <div class="row">
                            <div class="col-lg-12">
                                请选择本次转化交易标的相关的院成果技术编码（尚未取得编码的请先完成成果填报工作）
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">

                                <div class="form-group">
                                    <%--@declare id="exampleinputname2"--%><label for="exampleInputName2">成果技术类型</label>
                                    <select id="zaasTechType_select" name="zaasTechType" class="form-control">
                                        <c:forEach items="${zaasTechTypeList}" var="re">
                                            <option value="<c:out value="${re.key}"/>"><c:out value="${re.value}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">年份</label>
                                    <select id="year_select" class="form-control">
                                        <option value="0">全部</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">单位</label>
                                    <select id="depart_select" class="form-control">
                                        <option value="0">全院</option>
                                        <c:forEach items="${departList}" var="depart">
                                            <option value="<c:out value="${depart.danwId}"/>"><c:out value="${depart.danwjc}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">成果技术编码</label>
                                    <select id="zaasCode_select" name="zaasCode" class="form-control"></select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label for="exampleInputName2">成果技术名称</label>
                                    <div><span id="zaastechName"></span></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div id="mis_pass" class="alert alert-success" role="alert">√院MIS系统科研成果库已收录</div>
                                <div id="mis_not_pass" class="alert alert-danger" role="alert">×院MIS系统科研成果库未收录，请补齐相关记录。</div>
                                <div id="51nyjs_pass" class="alert alert-success" role="alert">√“51农业技术”平台中已发布</div>
                                <div id="51nyjs_not_pass" class="alert alert-danger" role="alert">×“51农业技术”平台中未发布，请先向平台管理员提供图文资料。</div>
                                <div id="span_text" class="alert alert-warning" role="alert">搜索完毕，没有找到相关记录。</div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <input type="hidden" name="codeType" value="${codeType}">
                                <input type="button" class="btn btn-default" onclick="doList();" value="返回"/>&nbsp;&nbsp;
                                <input id="bt_next" type="button" class="btn btn-default" value="下一步"/>

                            </div>
                        </div>
                        </form>
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
<script src="/resources/vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="/resources/vendor/raphael/raphael.min.js"></script>
<script src="/resources/vendor/morrisjs/morris.min.js"></script>
<script src="/resources/data/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

</body>
<script type="application/javascript">
    //页面加载完成时执行
    $(document).ready(
        function() {
            //关闭下一步按钮
            $("#bt_next").attr("disabled",true);
            //添加year下拉框  默认选中当前年份前一年
            addYearSelect();
            //单位赋初值
            $("#depart_select").val(${departId});
            //触发查询
            $("#zaasTechType_select").change();
        }
    );

    //当成果技术类型改变时触发查询
    $("#zaasTechType_select").change(function () {
        //清空成果编码
        $("#zaasCode_select").empty();
        //清空提示信息
        $("#span_text").hide();

        var year = $("#year_select").val();
        var departId = $("#depart_select").val();
        var zaasTechType = $("#zaasTechType_select").val();

        //当技术类型为“软件著作权”、“颁布标准”时，查询不带单位id，因为mis库中这两个表没有单位id
        if(zaasTechType=="软件著作权"||zaasTechType=="颁布标准"){
            //下拉框赋值全院
            $("#depart_select").val(0);
            //提交参数改为全员
            departId = 0 ;
            //锁定单位选择框
            $("#depart_select").attr("disabled",true);

        }else{
            //解除单位选择框锁定
            $("#depart_select").removeAttr("disabled",true);
        }

        //ajax提交访问  参数：技术类型、单位id、年份
        $.post("getZaasCodeList.do",{zaasTechType:zaasTechType,departId:departId,year:year},function(date){
            //date 为返回值 json对象 size list为自定义的两个属性 size为list长度 list为返回的成果编码列表
            if(date.size!=0){
                $.each(date.list, function(i, item) {
                    $("#zaasCode_select").append(
                        "<option value='" + item + "'>" + item + "</option>");
                });
            }else{
                //未搜索到结果提示信息
                $("#span_text").show();
            }
            //触发下一级查询
            $("#zaasCode_select").change();

        },"json");


    });

    //当单位改变时触发查询
    $("#depart_select").change(function () {
        $("#zaasCode_select").empty();
        $("#span_text").hide();
        var year = $("#year_select").val();
        var departId = $("#depart_select").val();
        var zaasTechType = $("#zaasTechType_select").val();
        $.post("getZaasCodeList.do",{zaasTechType:zaasTechType,departId:departId,year:year},function(date){
            if(date.size!=0){
                $.each(date.list, function(i, item) {
                    $("#zaasCode_select").append(
                        "<option value='" + item + "'>" + item + "</option>");
                });
            }else{
                $("#span_text").show();
            }
            $("#zaasCode_select").change();
        },"json");
    });

    //当年份改变时触发查询
    $("#year_select").change(function () {
        $("#zaasCode_select").empty();
        $("#span_text").hide();
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
                $("#span_text").show();
            }
            $("#zaasCode_select").change();
        },"json");
    });

    //当成果编码改变时触发查询
    $("#zaasCode_select").change(function () {
        //定义njy、mis boolean值作为判断是否在51nyjs、mis中存在
        var njy = false;
        var mis = false;
        //清空标题栏与提示栏信息
        $("#51nyjs_not_pass").hide();
        $("#51nyjs_pass").hide();
        $("#mis_not_pass").hide();
        $("#mis_pass").hide();
        $("#zaastechName").html("");
        var zaasCode = $("#zaasCode_select").val();
        //不合法的code初步判断  长度为4因为2015年（包括2015）前后两种验证规则，后台需先取出前4位判断
        if(zaasCode.length<4){return false;}
        //根据成果编码获取标题 并依此判断其在两个库存在情况
        $.post("getTechName.do",{zaasCode:zaasCode},function(date){

            if(date.name_njy==null||date.name_njy==""){
                $("#51nyjs_not_pass").show();
            } else {
                $("#51nyjs_pass").show();
                njy = true;
            }

            if($("#zaasTechType_select").val()=="实用技术"){
                mis = true;
            }else if(date.name_mis==null||date.name_mis==""){
                $("#mis_not_pass").show();
            } else {
                $("#mis_pass").show();
                mis = true;
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
       //window.location.href = "newNext.do?codeType=${codeType}&zaasCode="+$("#zaasCode_select").val()+"&zaasTechType="+$("#zaasTechType_select").val();
        $("#firstForm").submit();
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

    function doList() {
        window.location.href = "list.do?codeType=${codeType}";
    }
</script>

</html>
