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
                        ${projectName}&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;人员排名
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-10 col-lg-offset-1">
                                <form id="memberForm" action="/member/save.do" class="form-horizontal">

                                    <div class="form-group">
                                        <label for="exampleInputEmail2">项目编号</label>&nbsp;&nbsp;${projectNum}
                                        <c:choose>
                                            <c:when test="${member!=null&&member.id!=null}">
                                                <input type="hidden" name="id" value="${member.id}"/>
                                                <input type="hidden" name="projectId" value="${member.projectId}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="hidden" name="projectId" value="${projectId}"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-5 col-sm-6">
                                                <label for="exampleInputName2">人员类型</label>
                                                <label class="checkbox-inline">
                                                    <input type="radio" name="isStaff" id="optionsRadios1" checked="checked" value="1">本院在职职工
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="radio" name="isStaff" id="optionsRadios2" value="2" >本院非在职职工
                                                </label>
                                                <label class="checkbox-inline">
                                                    <input type="radio" name="isStaff" id="optionsRadios3" value="0">其他人员
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <label for="exampleInputName2">部门名称</label>
                                                <select id="depart_select" class="form-control" name="departId">
                                                    <c:forEach items="${departList}" var="depart">
                                                        <option value="<c:out value="${depart.danwId}"/>"><c:out value="${depart.danwjc}"/></option>
                                                    </c:forEach>
                                                </select>
                                                <input type="hidden" id="depart_name" name="depart" value=""/>
                                                <input type="text" name="depart" class="form-control" id="depart_input">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <label for="exampleInputName2">课题成员名称</label>
                                                <select id="person_select" class="form-control" name="userId" onchange="changePerson(this)"></select>
                                                <input type="hidden" id="person_name" name="name" value=""/>
                                                <input type="text" name="name" class="form-control" id="person_input">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <label for="exampleInputName2">角色</label>
                                                <select id="role" name="role" class="form-control">
                                                    <option value="项目参加">项目参加</option>
                                                    <option value="项目主持">项目主持</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-3 col-sm-6">
                                                <label for="exampleInputEmail2">成员排名</label>
                                                <input type="text" name="rankNumber" class="form-control" value="${member.rankNumber}">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-lg-offset-5 col-md-offset-6  col-sm-offset-6">
                                <input class="btn btn-primary" type="button" value="返回" onclick="doList()"/>&nbsp;&nbsp;
                                <input type="button" class="btn btn-primary" value="保存" id="submitBt"/>
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
    $(function() {
        if(${member==null&&member.id==null}){
            $("#person_input").hide();
            $("#people_input").attr("disabled",true);
            $("#depart_input").hide();
            $("#depart_input").attr("disabled",true);
            $("#depart_select").val(${projectDepartId});
            $("#optionsRadios1").click();
        }else if(${member.isStaff==1}){
            //alert(111111);
            $("#depart_select").val(${member.departId});
            $("#optionsRadios1").click();
            //不知道为什么  停顿一下就能执行  不然人员选择框赋值无效
            setTimeout(function () {
                $("#person_select").val(${member.userId});
                $("#person_select").change();
                $("#role").val("${member.role}");
            }, 100);


        }else if(${member.isStaff==2}){
            alert(2222);
            $("#depart_select").val(${member.departId});
            $("#optionsRadios2").click();

            //不知道为什么  停顿一下就能执行  不然人员选择框赋值无效
            setTimeout(function () {
                $("#person_select").val(${member.userId});
                $("#person_select").change();
                $("#role").val("${member.role}");
            }, 100);

        }else if(${member.isStaff==0}){
            //alert(0000);
            $("#optionsRadios3").click();
            $("#depart_input").val("${member.depart}");
            $("#person_input").val("${member.name}");
            $("#role").val("${member.role}");
        }


    });

    $("#optionsRadios1").click(function() {

        $("#depart_select").change();

        $("#person_select").show();
        $("#person_select").removeAttr("disabled",true);
        $("#person_name").removeAttr("disabled",true);

        $("#person_input").hide();
        $("#person_input").attr("disabled",true);

        $("#depart_select").show();
        $("#depart_select").removeAttr("disabled",true);
        $("#depart_name").removeAttr("disabled",true);

        $("#depart_input").hide();
        $("#depart_input").attr("disabled",true);
    });

    $("#optionsRadios2").click(function() {

        $("#depart_select").change();

        $("#person_select").show();
        $("#person_select").removeAttr("disabled",true);
        $("#person_name").removeAttr("disabled",true);

        $("#person_input").hide();
        $("#person_input").attr("disabled",true);

        $("#depart_select").show();
        $("#depart_select").removeAttr("disabled",true);
        $("#depart_name").removeAttr("disabled",true);

        $("#depart_input").hide();
        $("#depart_input").attr("disabled",true);
    });

    $("#optionsRadios3").click(function() {

        $("#person_select").hide();
        $("#person_select").attr("disabled",true);
        $("#person_name").attr("disabled",true);

        $("#person_input").show();
        $("#person_input").removeAttr("disabled",true);

        $("#depart_select").hide();
        $("#depart_select").attr("disabled",true);
        $("#depart_name").attr("disabled",true);

        $("#depart_input").show();
        $("#depart_input").removeAttr("disabled",true);
    });

    $("#depart_select").change(function () {
        $("#person_select").empty();


        $("#depart_name").val($("#depart_select").find("option:selected").text());

        $.post("getPersonList.do",{departId:$("#depart_select").val(),isStaff:$("input[name='isStaff']:checked").val()},function(date){
            if(date.stateCode==1){
                $.each(date.staffList, function(i, item) {
                    var personArray =  item.split("|");
                    $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                });
            }else if(date.stateCode==2){
                if(date.doctorCount>0){
                    $("#person_select").append("<optgroup label='博士后'>");
                    $.each(date.doctorList, function(i, item) {
                        var personArray =  item.split("|");
                        $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                    });
                    $("#person_select").append("</optgroup>");
                }
                if(date.dispatchCount>0){
                    $("#person_select").append("<optgroup label='派遣人员'>");
                    $.each(date.dispatchList, function(i, item) {
                        var personArray =  item.split("|");
                        $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                    });
                    $("#person_select").append("</optgroup>");
                }
                if(date.studentCount>0){
                    $("#person_select").append("<optgroup label='一导研究生'>");
                    $.each(date.studentList, function(i, item) {
                        var personArray =  item.split("|");
                        $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                    });
                    $("#person_select").append("</optgroup>");
                }
                if(date.otherPersonCount>0){
                    $("#person_select").append("<optgroup label='其他人员'>");
                    $.each(date.otherPersonList, function(i, item) {
                        var personArray =  item.split("|");
                        $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                    });
                    $("#person_select").append("</optgroup>");
                }
                if(date.retiredStaffCount>0){
                    $("#person_select").append("<optgroup label='退休人员'>");
                    $.each(date.retiredStaffList, function(i, item) {
                        var personArray =  item.split("|");
                        $("#person_select").append("<option value='" + personArray[0] + "'>" + personArray[1] + "</option>");
                    });
                    $("#person_select").append("</optgroup>");
                }
            }
            $("#person_select").change();
        },"json");
    });


    
    $("#submitBt").click(function () {
        $("#memberForm").submit();
    });

    function changePerson(e){
        document.getElementById("person_name").value = e.options[e.selectedIndex].text;

    }

    function doList(){
        window.location.href = "list.do?projectId="+${projectId};
    }

</script>

</body>

</html>