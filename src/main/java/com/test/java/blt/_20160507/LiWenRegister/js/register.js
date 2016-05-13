$(document).ready(function(){

    /*作业：注册表单完善，包含JavaScript交互: 提交后验证下列字段：
     用户名不能为空、
     用户名不能以数字0开头
     密码不少于8位 密码和确认密码相同
     注册提交后，用户输入的信息展示：用户名，性别，所在省市 要求使用jquery方式验证

     TODO AJAX异步请求：1.观察获取异步请求 - baidu search 2.JQUERY AJAX异步请求方式
     */

    $("#submit").click(function(){
        $(".notice").remove();
        var flag = true;
        var username = $("#username").val();
        var pwd = $("#password").val();
        var repwd = $("#repassword").val();
        var sex = $("input:checked").val();
        var province = $("#province").val();

        var first = username.charAt(0);
        if (username == null || username == "" || first == "0" || first == " ") {
            $("#username").after("<span class='notice'>用户名不能为空且不能以数字0开头</span>");
            flag = false;
        }
        var pwdlen = ($.trim(pwd)).length;

        if (pwdlen == 0 || pwdlen < 8) {
            flag = false;
            $("#password").after("<span class='notice'>密码长度为8-10个字符！</span>");
        }

        if (($.trim(repwd)).length == 0) {
            $("#repassword").after("<span class='notice'>密码长度为8-10个字符！</span>");
            flag = false;
        }else {
            if (pwd != repwd) {
                $("#repassword").after("<span class='notice'>两次输入密码不一致</span>");
                flag = false;
            }
        }

        if (flag) {
            $.ajax({
                type:"POST",
                url:"success.html",
                async:false,
                complete : function (xhr, status) {
                    //alert(xhr.responseText);
                    $("#result").html(xhr.responseText);
                    $("#username").text(username);
                    $("#pwd").text(pwd);
                    $("#sex").text(sex);
                    $("#province").text(province);
                }
            });
        } else {
            return flag;
        }
    });
});