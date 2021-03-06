<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/17
  Time: 10:48
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
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                        <c:if test="${editEnable or (departEditEnable and (adminDepartId==adminDepartId))}">
                            <input class="btn btn-primary" type="button" value="新增" id="newBt" title="点击此处新增一条转让记录" />
                        </c:if>

                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>项目编号</th>
                                <th>项目名称</th>
                                <th>项目负责人</th>
                                <th>起始年月</th>
                                <th>终止年月</th>
                                <th>签约总金额<br>（万元）</th>
                                <th>到款金额<br>（万元）</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${tradeList}" var="trade" varStatus="tt">
                                    <tr class="odd">
                                        <td><c:out value="${tt.index + 1}"/></td>
                                        <td><c:out value="${trade.projectNum}"/></td>
                                        <td>
                                            <a href="detail.do?id=${trade.id}&codeType=${codeType}"><c:out value="${trade.projectName}"/></a>
                                        </td>
                                        <td><a href="../member/list.do?projectId=${trade.id}&codeType=${codeType}"><c:out value="${trade.projectPerson}"/>&nbsp;&nbsp;<p class="fa fa-group"></p></a></td>
                                        <td><fmt:formatDate value="${trade.startDate}" dateStyle="medium" type="date"/></td>
                                        <td><fmt:formatDate value="${trade.endDate}" dateStyle="medium" type="date"/></td>
                                        <td>
                                            <c:out value="${trade.signAmount==null?未录入:trade.intentionAmount/10000}"/>
                                        </td>
                                        <td>

                                            <a href="../funds/list.do?projectId=${trade.id}&codeType=${codeType}"><p class="glyphicon-yen">&nbsp;<c:out value="${trade.receivedAmount==null?0.00:trade.receivedAmount/10000}"/></p></a>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${trade.submitState==0 and trade.assessState==0}">未提交</c:when>
                                                <c:when test="${trade.submitState==0 and trade.assessState==1}">退回</c:when>
                                                <c:when test="${trade.submitState==1 and trade.assessState==0}">未审核</c:when>
                                                <c:when test="${trade.submitState==1 and trade.assessState==1}">审核通过</c:when>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:if test="${trade.submitState==0 and isSubmitor and (editEnable or (departEditEnable and (trade.departId==adminDepartId)))}">
                                                <input class="btn btn-primary" type="button" value="编辑" id="editBt" title="edit this" onclick="doEdit(<c:out value="${trade.id}"/>)"/>
                                                <input class="btn btn-primary" type="button" value="删除" id="delBt" title="del this" onclick="doDel(<c:out value="${trade.id}"/>)"/>

                                            </c:if>
                                            <c:if test="${trade.submitState==1 and trade.assessState==0  and isAssessor and (editEnable or (departEditEnable and (trade.departId==adminDepartId)))}">
                                                <input class="btn btn-primary" type="button" value="编辑" id="editBt" title="edit this" onclick="doEdit(<c:out value="${trade.id}"/>)"/>

                                            </c:if>
                                            <c:if test="${trade.joinState==0 and trade.submitState==1 and trade.assessState==1 and trade.attachment==null and (editEnable or (departEditEnable and (trade.departId==adminDepartId))) }">
                                                <c:choose>
                                                    <c:when test="${'A1,A2,A3,A4'.contains(trade.projectTypeCode)}">
                                                        <a  href="../workFlow/printTable.do?id=${trade.id}&tableType=achieveTrans" onclick="return confirm('请于合同正式签订后一个月内，录入“签约总金额”，并按照我院归档格式要求上传合同正本PDF版。');" target="_blank" id="printBt" title="打印科技成果转化合同审核表" ><span class="glyphicon glyphicon-print"></span></a>
                                                    </c:when>
                                                    <c:when test="${trade.departFullName=='浙江省农业科学院' and 'K1,K2,F1,Z1,P1'.contains(trade.projectTypeCode)}">
                                                        <a  href="../workFlow/printTable.do?id=${trade.id}&tableType=techTrans" onclick="return confirm('请于合同正式签订后一个月内，录入“签约总金额”，并按照我院归档格式要求上传合同正本PDF版。');" target="_blank" id="printBt" title="打印“四技服务”合同审核表" ><span class="glyphicon glyphicon-print"></span></a>
                                                    </c:when>
                                                    <c:when test="${'K1,K2,F1,Z1,P1'.contains(trade.projectTypeCode)}">
                                                        <a  href="../workFlow/printTable.do?id=${trade.id}&tableType=techTransRecord" onclick="return confirm('请于合同正式签订后一个月内，录入“签约总金额”，并按照我院归档格式要求上传合同正本PDF版。');" target="_blank" id="printBt" title="打印“四技服务”合同备案表" ><span class="glyphicon glyphicon-print"></span></a>
                                                    </c:when>
                                                    <c:otherwise>

                                                    </c:otherwise>
                                                </c:choose>

                                                <c:if test="${trade.oneCode!=null and trade.attachmentTable==null}">
                                                    <a  href="goTradeUpload.do?codeType=${codeType}&id=${trade.id}&type=1" target="_self"  title="上传审批表PDF"><span class="glyphicon glyphicon-open-file"></span></a>
                                                </c:if>

                                                <c:if test="${trade.oneCode!=null and trade.attachment==null}">
                                                    <a  href="goTradeUpload.do?codeType=${codeType}&id=${trade.id}" target="_self"  title="上传合同原件PDF"><span class="glyphicon glyphicon-level-up"></span></a>
                                                </c:if>

                                            </c:if>

                                        </td>

                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>
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
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!--bootstrap-datetimepicker-master-->
<script src="/resources/vendor/bootstrap-datetimepicker-master/bootstrap-datetimepicker.min.js"></script>
<script src="/resources/vendor/bootstrap-datetimepicker-master/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script type="application/javascript">
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true,
            select: true,
            "oLanguage": {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条记录",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "查询:  ",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                }
            },
            initComplete: function() {
                this.api().columns().every(function() {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo($(column.footer()).empty())
                        .on('change', function() {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );

                            column
                                .search(val ? '^' + val + '$' : '', true, false)
                                .draw();
                        });

                    column.data().unique().sort().each(function(d, j) {
                        select.append('<option value="' + d + '">' + d + '</option>')
                    });
                });
            }
        });
    });
    
    $("#newBt").click(function () {
        window.location.href = "newFirst.do?codeType=${codeType}";
    });
    
    function doDel(id) {

        $.post("beforeDel.do",{id:id},function(date){
            if(date.fundsCount==0&&date.memberCount==0&&date.subsidiaryCount==0){
                if(confirm("是否确认删除？")){
                    window.location.href = "del.do?id="+id+"&codeType=${codeType}";
                }
            }else{
                if(confirm("此条记录关联"+date.fundsCount+"条成员记录"+date.memberCount+"条经费记录"+date.subsidiaryCount+"条其他编码记录，删除操作将会将此彻底清空，是否确认？")){
                    window.location.href = "del.do?id="+id+"&codeType=${codeType}";
                }
            }
        },"json");


    }

    function doEdit(id) {
        window.location.href = "edit.do?id="+id+"&codeType=${codeType}";
    }

    function goMember(id) {
        window.location.href = "../member/list.do?projectId="+id+"&codeType=${codeType}";
    }

    function goFunds(id) {
        window.location.href = "../funds/list.do?projectId="+id+"&codeType=${codeType}";
    }

    function doPrint(id,tableType){
        window.location.href = "/workFlow/printTable.do?id="+id+"&tableType="+tableType;
    }

    function doCompelete(id) {
        window.location.href = "goTradeUpload.do?codeType=${codeType}&id="+id;
    }
    
</script>
</body>



</html>
