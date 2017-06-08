<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/27
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <title>404 - Monochrome</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="JoashPereira">
    <link rel="stylesheet" href="/resources/css/monochrome-404.css" />
    <script src="/resources/js/common/modernizr.js"></script>
</head>

<body>
<div id="container">
    <div class="overlay"></div>
    <div class="item-title">
        <div id="message"></div>
        <div class="link-bottom">
            <a class="link-icon" href="/index.do"><i class="icon ion-ios-home"></i> 主页</a>
            <a class="link-icon" href="#" onclick="history.go(-1);"><i class="icon ion-ios-compose"></i> 返回</a>
        </div>
    </div>
</div>
<script src="/resources/js/common/jquery.min.js"></script>
<script src="/resources/js/common/jquery.easings.min.js"></script>
<script src="/resources/js/common/bootstrap.min.js"></script>
<script src="/resources/js/monochrome-404.js"></script>
</body>

</html>