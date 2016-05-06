$(document).ready(function(){

    $(":password").bind('input propertychange',function(){
        len = $(this).val().length;
        if (len != 10) {
            //alert("false");
            $(this).next().show();
        }else {
            $(this).next().hide();
        }
    });

});