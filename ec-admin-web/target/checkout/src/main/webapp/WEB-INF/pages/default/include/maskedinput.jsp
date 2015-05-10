<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
/**
 * 默认的输入框格式化
 * inputid:输入框id，不带"#"
 * maskstr:输入框的格式;definitions: {
			'9': "[0-9]",//9代表数字
			'a': "[A-Za-z]",//a代表字母
			'*': "[A-Za-z0-9]",//*代表数字和字母,只匹配一位
		},比如:"99/99/9999"
 */
function maskInput(inputid,maskstr){
	$("#"+inputid).mask(maskstr);
}
/**
 * 带参数的输入框格式化
 * inputid:输入框id，不带"#"
 * maskstr:输入框的格式
 * settings:格式化参数,比如:{
	              "placeholder":"==",;//自定义maskstr中的definitions在没有输入之前的代表符
	              "completed":function(){}//定义在输入框输入结束后的函数
                }
 */
function maskInput(inputid,maskstr,settings){
	$("#"+inputid).mask(maskstr,settings);
}
 /**
 *默认格式化日期:yyyy-MM-dd
 */
function maskInputDate(inputid){
	$("#"+inputid).mask("9999-99-99");
}
/**
 *按指定分隔符格式化日期
 */
function maskInputDate(inputid,split){
	$("#"+inputid).mask("9999"+split+"99"+split+"99");
}

 /**
 *取消输入框格式化
 */
function unmask(inputid){
	$("#"+inputid).unmask();
}
</script>