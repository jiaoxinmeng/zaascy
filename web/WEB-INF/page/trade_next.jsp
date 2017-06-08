
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
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>51农业技术</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../resources/vendor/bootstrap/css/bootstrap-multiselect.css" rel="stylesheet">
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
                        <a href="/user/loginOut.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        新增>>第二步
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-10 col-lg-offset-1">
                                <form id="tradeForm" action="/trade/save.do" class="form-horizontal" method="post">
                                    <div class="form-group">
                                        <%--@declare id="exampleinputemail2"--%><label for="exampleInputEmail2">项目编号</label>&nbsp;&nbsp;
                                        <input type="email" class="form-control" name="projectNum"  disabled="disabled" placeholder="将在审核后自动生成">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">院成果技术编码</label>&nbsp;&nbsp;${zaasCode}
                                        <input type="hidden" name="zaasCode" value="${zaasCode}"/>
                                        <input type="hidden" name="zaasTechType" value="${zaasTechType}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">项目名称</label>
                                        <input type="email" class="form-control" name="projectName" value=""/>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-6 col-sm-6">
                                                <%--@declare id="exampleinputname2"--%><label for="exampleInputName2">年份</label>
                                                <select class="form-control" name="projectYear" id="year_select"></select>
                                            </div>
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputName2">项目类别</label>
                                                <select id="projectType_select" class="form-control" name="projectTypeCode">
                                                    <c:forEach items="${projectTypeList}" var="re">
                                                        <option value="<c:out value="${re.key}"/>"><c:out value="${re.value}"/></option>
                                                    </c:forEach>
                                                </select>
                                                <input type="hidden" name="projectType" id="projectType" value=""/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputName2">单位</label>
                                                <select id="depart_select" class="form-control" name="departId">
                                                    <option value="0">全院</option>
                                                    <c:forEach items="${departList}" var="depart">
                                                        <option value="<c:out value="${depart.danwId}"/>"><c:out value="${depart.danwjc}"/></option>
                                                    </c:forEach>
                                                </select>
                                                <input type="hidden" id="depart_name" name="depart" value=""/>
                                            </div>
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputName2">项目负责人</label>
                                                <input type="text" class="form-control" name="projectPerson" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">让与/承担单位</label>
                                                <select id="departFullName_select" class="form-control" name="departFullName" multiple="multiple">
                                                    <option value="浙江省农业科学院">浙江省农业科学院</option>
                                                    <c:forEach items="${departList}" var="depart">
                                                        <option value="<c:out value="${depart.danwmc}"/>"><c:out value="${depart.danwmc}"/></option>
                                                    </c:forEach>
                                                    <c:forEach items="${otherDepartList}" var="depart">
                                                        <option value="<c:out value="${depart.key}"/>"><c:out value="${depart.value}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">委托/受让单位</label>
                                                <input type="text" class="form-control" name="customerDepart" value="">
                                            </div>
                                            <div class="col-lg-4 col-sm-6">
                                                <label for="exampleInputName2">其他合作单位</label>
                                                <input type="text" class="form-control" name="otherCustomerDepart" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputEmail2">起始年月</label>
                                                <div class='input-group date' id='datetimepicker1'>
                                                    <input type='text' class="form-control" name="startDate" />
                                                    <span class="input-group-addon">
			                    <span class="glyphicon glyphicon-calendar"></span>
															</span>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputEmail2">终止年月</label>
                                                <div class='input-group date' id='datetimepicker2'>
                                                    <input type='text' class="form-control" name="endDate"/>
                                                    <span class="input-group-addon">
			                    <span class="glyphicon glyphicon-calendar"></span>
															</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputEmail2">意向总金额（元）</label>
                                                <input type="email" class="form-control" id="intentionAmount" name="intentionAmount" value="">
                                            </div>
                                            <div class="col-lg-6 col-sm-6">
                                                <label for="exampleInputEmail2">签约总金额（元）</label>
                                                <input type="email" class="form-control" id="signAmount" name="signAmount"  disabled="disabled" placeholder="请在上传备案/审核表、正式合同后，录入签约总金额。">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputEmail2">项目基本情况介绍（委托/受让单位、项目内容等，可公开，限200字）</label>
                                        <textarea class="form-control" name="projectSummary" rows="8"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">意向总金额与付款方式说明</label>
                                        <textarea class="form-control" name="intentionAmountExplain" rows="8"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail2">备注</label>
                                        <textarea class="form-control" name="remarks" rows="8"></textarea>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-lg-offset-5 col-md-offset-6  col-sm-offset-6">
                                <button type="button" class="btn btn-default" id="quitBt">关闭</button>&nbsp;&nbsp;
                                <input type="button" class="btn btn-primary" id="submitBt" value="保存"/>
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

<script src="../../resources/vendor/bootstrap/js/bootstrap-multiselect.js"></script>

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
<script type="application/javascript">

    $(document).ready(
        function() {
            //初始化年份下拉框
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

            $('#datetimepicker2').datetimepicker({
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

            //初始化多选下拉框
            $("#departFullName_select").multiselect();

            //给单位赋初值
            $("#depart_select").val(${departId});

            $("#zaasTechType_select").val("${zaasTechType}");



            //触发生成单位名称与全称
            $("#depart_select").change();

            //如果不是从首页点如，则可赋值
            if("A"!="${codeType}"&&"K"!="${codeType}"){
                $("#projectType_select").val("${codeType}");
            }

            //触发项目生成项目类别
            $("#projectType_select").change();



        }
    );


    $("#depart_select").change(function () {
        $("#depart_name").val($("#depart_select").find("option:selected").text());
        if(${trade==null and 'A,A1,A2,A3,A4'.contains(codeType) }){
            $("#departFullName_select  option[value='浙江省农业科学院'] ").attr("selected", true);
            $("#departFullName_select").multiselect("refresh");
        }else{
            $.post("getDepartFullName.do",{departId:$("#depart_select").val()},function(date){
                $("#departFullName_select").find("option:selected").removeAttr("selected", true);
                $("#departFullName_select  option[value='" + date.departFullName + "'] ").attr("selected", true);
                $("#departFullName_select").multiselect("refresh");
            },"json");
        }
    });

    $("#projectType_select").change(function () {
        $("#projectType").val($("#projectType_select").find("option:selected").text());
    });

    $("#intentionAmount").blur(function () {
        var intentionAmount = $("#intentionAmount").val();
        intentionAmount = Number(intentionAmount).toFixed(2);
        $("#intentionAmount").val(intentionAmount);
        $("#signAmount").val(intentionAmount);
        var intentionAmount_cn = Arabia_to_Chinese(intentionAmount);
        $("#intentionAmount").attr("title",intentionAmount_cn);
        $("#signAmount").attr("title",intentionAmount_cn);
    });

    function addYearSelect(){
        var nowDate = new Date();
        var nowYear = nowDate.getFullYear();
        for(var i = nowYear;i>2010;i--){
            $("#year_select").append("<option value='" + i + "'>" + i + "</option>");
        }
    }
    
    $("#submitBt").click(function () {
        $("#tradeForm").submit();
    });

    $("#quitBt").click(function () {
        if(confirm("此时退出信息将不会保存，是否确认退出.")){
            window.location.href = "list.do?codeType=${codeType}"
        }
    });

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


</html>
