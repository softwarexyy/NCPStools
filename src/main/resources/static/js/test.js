function resetPwd(type) {
    var result = confirm("确认重置" + $("#phone").val() + "客户的密码吗？");
    if (result) {   //确认后重置登录密码 ajax发送json请求
        var param = {phone: $("#phone").val(), pwdTyp: type}  // 准备发送的数据
        $.ajax({
            type: 'POST',
            url: "/resetPwd",
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            // data:{
            //     phone:$("#phone").val()
            // },
            data: JSON.stringify(param),
            success: function (data) {
                alert(data["message"]);
            },
            error: function (data) {
                alert("页面调用失败");
            }
        });
    }
}

function resetPwdStat(type) {
    var result = confirm("确认解冻" + $("#phone").val() + "客户吗？");
    if (result) {   //确认后重置登录密码 ajax发送json请求
        var param = {phone: $("#phone").val(), pwdTyp: type}  // 准备发送的数据
        $.ajax({
            type: 'POST',
            url: "/resetPwdStat",
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            // data:{
            //     phone:$("#phone").val()
            // },
            data: JSON.stringify(param),
            success: function (data) {
                alert(data["message"]);
            },
            error: function (data) {
                alert("页面调用失败");
            }
        });
    }
}

function unbindDevice() {
    var result = confirm("确认解绑" + $("#phone").val() + "客户的设备吗？");
    if (result) {   //确认后重置登录密码 ajax发送json请求
        var param = {phone: $("#phone").val()}  // 准备发送的数据
        $.ajax({
            type: 'POST',
            url: "/unbindDevice",
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            // data:{
            //     phone:$("#phone").val()
            // },
            data: JSON.stringify(param),
            success: function (data) {
                alert(data["message"]);
            },
            error: function (data) {
                alert("页面调用失败");
            }
        });
    }
}