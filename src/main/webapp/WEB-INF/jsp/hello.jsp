<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/test.js"></script>
    <style type="text/css" media="screen">
        body {
            padding: 20px;
            font-size: 0.85em;
            font-family: georgia, serif;
        }

        .btn {
            display: block;
            position: relative;
            background: #aaa;
            padding: 5px;
            float: left;
            color: #fff;
            text-decoration: none;
            cursor: pointer;
        }

        .btn * {
            font-style: normal;
            background-repeat: no-repeat;
            display: block;
            position: relative;
        }

        .btn i {
            background-position: top left;
            position: absolute;
            margin-bottom: -5px;
            top: 0;
            left: 0;
            width: 5px;
            height: 5px;
        }

        .btn span {
            background-position: bottom left;
            left: -5px;
            padding: 0 0 5px 10px;
            margin-bottom: -5px;
        }

        .btn span i {
            background-position: bottom right;
            margin-bottom: 0;
            position: absolute;
            left: 100%;
            width: 10px;
            height: 100%;
            top: 0;
        }

        .btn span span {
            background-position: top right;
            position: absolute;
            right: -10px;
            margin-left: 10px;
            top: -5px;
            height: 0;
        }

        * html .btn span,
        * html .btn i {
            float: left;
            width: auto;
            background-image: none;
            cursor: pointer;
        }

        .btn.blue {
            background: #2ae;
        }

        .btn.green {
            background: #9d4;
        }

        .btn.pink {
            background: #e1a;
        }

        .btn:hover {
            background-color: #a00;
        }

        .btn:active {
            background-color: #444;
        }

        .btn[class] {
            background-image: background-position: bottom;
        }

        * html .btn {
            border: 3px double #aaa;
        }

        * html .btn.blue {
            border-color: #2ae;
        }

        * html .btn.green {
            border-color: #9d4;
        }

        * html .btn.pink {
            border-color: #e1a;
        }

        * html .btn:hover {
            border-color: #a00;
        }

        p {
            clear: both;
            padding-bottom: 2em;
        }

        form {
            margin-top: 2em;
        }

        form p .btn {
            margin-right: 1em;
        }

        textarea {
            margin: 1em 0;
        }
    </style>

</head>
<body>
<div>
    客户手机号：
    <input type="text" id="phone" name="phone"/>
    <p>
        <input type="Button" value="重置登录密码" class="btn blue" onclick="resetPwd('01')"/>
        <input type="Button" value="重置交易密码" class="btn green" onclick="resetPwd('02')"/>
        <input type="Button" value="解冻客户" class="btn blue" onclick="resetPwdStat('01')"/>
        <input type="Button" value="解绑用户设备" class="btn green" onclick="unbindDevice()"/>
    </p>
</div>

</body>
</html>