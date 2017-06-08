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

    <title>浙江省农业科学院科技成果与四技服务转化系统-合同上传</title>

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
                        ${projectName}&nbsp;<i class="fa fa-angle-double-right"></i>&nbsp;上传合同PDF正本&nbsp;录入成交金额
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">

                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <%--@declare id="exampleinputname2"--%><label for="exampleInputName2">
                                        项目编号
                                    </label>
                                    ${projectNum}
                                    <input type="hidden" id="id" value="${id}"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">请选择合同路径</label>
                                    <input type="file" id="myfile" name="myfile" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label for="exampleInputName2">最终成交金额</label>
                                    <input type="text" id="signAmount" class="form-control">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <input type="button" class="btn btn-default" value="返回" onclick="doList();"/>&nbsp;&nbsp;
                                <input type="button" class="btn btn-primary" id="submit" value="上传" onclick="upload();"/>
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

        }
    );

    $("#signAmount").blur(function () {
        var funds = $("#signAmount").val();
        funds = Number(funds).toFixed(2);
        $("#signAmount").val(funds);
        var funds_cn = Arabia_to_Chinese(funds);
        $("#signAmount").attr("title",funds_cn);
    });

    function upload() {
        var formData = new FormData();
        formData.append("myfile", $("#myfile").get(0).files[0]);
        formData.append("id", $("#id").val());
        formData.append("signAmount", $("#signAmount").val());

        if($("#myfile").val()==null||$("#myfile").val()==""){
            $("#tips").html("您还没有选择文件");
            return false;
        }
        //alert($("#id").val()+"---"+$("#signAmount").val());

        $("#tips").html("正在上传中,请稍等....");

        $.ajax({
            type: 'POST',
            url: "saveTradeComplete.do",
            cache: false,
            data: formData,
            dataType: "json",
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
            processData: false,  // 告诉jQuery不要去处理发送的数据
            success: function (data) {
                if(data.code==1){
                    $("#tips").html("上传成功");
                }else if(data.msg!=""){
                    $("#tips").html(data.msg);
                }else {
                    $("#tips").html("未知错误");
                }


                //window.location.href = "list.do?codeType=${codeType}";
            }
        });
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

    function doList() {
        window.location.href = "list.do?codeType=${codeType}";
    }

</script>

</html>