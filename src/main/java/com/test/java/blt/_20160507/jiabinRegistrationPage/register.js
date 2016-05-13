/**
 * Created by binjia on 2016/5/12.
 */

function v_name() {
    var reg_name =/^[0-9]/;
    var name = $("#name").val();
    if (name.length == 0) {
        $("#labname").html("用户名不能为空！");
        return false;
    } else {$("#labname").html("");}
    if (!reg_name.test(name)) {
        $("#labname").html("用户名必须以数字开头！ ");
        return false;
    } else {
        $("#labname").html("");
        return true;
    }
}

function v_passpord() {
    var pw1 = $("#pw1").val();
    var pw2 = $("#pw2").val();
    if (pw1.length == 0){
        $("#labpw1").html("密码不能为空！");
        return false;
    } else if (pw1.length < 8) {
        $("#labpw1").html("密码位数不能小于8位！");
        return false;
    } else if (pw1 != pw2){
        $("#labpw1").html("两次密码输入的不一致！");
        return false;
    } else {$("#labpw1").html("");return true;}
}

function v_city(){
    var city = $("#choosecity").val();
    if (city == "qingxuanze") {
        $("#labcity").html("请选择您所在的城市！");
        return false;
    } else {
        $("#labcity").html("");
        return true;
    }
}

function saveData(){
    var name = $("#name").val();
    var sex = $("input[name='sex']:checked").val();
    var city = $("#choosecity").val();

    document.cookie="name="+ name;
    document.cookie="sex="+ sex;
    document.cookie="city="+ city;
}

function v_submit() {
    if (v_name() && v_passpord() && v_city()) {
        saveData();
        return true
    } else {
        return false
    }
}
