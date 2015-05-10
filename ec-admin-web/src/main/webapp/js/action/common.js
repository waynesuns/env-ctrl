/** ********** 下拉列表多选 *********** */
function initMultiselect(id,menuWidth) {
	initMultiselectAll(id, selectedMessage, checkAllText, unCheckAllText,menuWidth);
}
function initMultiselectWithOutFilter(id,menuWidth) {
	$("#" + id).multiselect({
		noneSelectedText : selectedMessage,
		checkAllText : checkAllText,
		uncheckAllText : unCheckAllText,
		selectedText : "# " + selectedText,
		selectedList : 3,
		menuWidth : menuWidth
	})
}
function initMultiselectJQuery(obj,menuWidth) {
	$(obj).multiselect({
		noneSelectedText : mes,
		checkAllText : checkAllText,
		uncheckAllText : unCheckAllText,
		selectedText : "# " + selectedText,
		selectedList : 3,
		menuWidth : menuWidth
	}).multiselectfilter({
		label : filterText
	});
}
function submitFromTrimZero(formId){
	var list = $("#" + formId).find("input:text");
	for ( var i = 0; i < $(list).length; i++) {
		var val = $(list[i]).val();
		var strP=/^\d+$/; 
		if(strP.test(val)){
			$(list[i]).val(parseInt(val,10));
		}
	}
}
function initMultiselectAll(id, mes, checkAllText, unCheckAllText,menuWidth) {
	$("#" + id).multiselect({
		noneSelectedText : mes,
		checkAllText : checkAllText,
		uncheckAllText : unCheckAllText,
		selectedText : "# " + selectedText,
		selectedList : 3,
		minWidth : menuWidth,
		position:{
			  my: " top",
			  at: " bottom"
			}
	}).multiselectfilter({
		label : filterText,
		placeholder: '请输入...',
		width:$("#" + id).width()-50
	});
}
/** ********** 下拉列表多选 *********** */
/** ********** 表单提交去两端空格 *********** */
function submitFromTrim(formId) {
	var list = $("#" + formId).find("input:text");
	textFieldTrim(list);
	var list = $("#" + formId).find("textarea");
	textFieldTrim(list);
}
function textFieldTrim(list) {
	for ( var i = 0; i < $(list).length; i++) {
		var val = $(list[i]).val();
		$(list[i]).val($.trim(val));
	}
}
/** ********** 表单提交后清空输入栏 *********** */
function clearnText(formId) {
	$("#" + formId).find("input:text").val("");
	$("#" + formId).find("textarea").val("");
	$("#" + formId).find(":checkbox").removeAttr("checked");
}

/** ********** 全角字符转半角字符 *********** */
function fullWidthToHalfWidth(str) {
	var result = "";
	for ( var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) == 12288) {
			result += String.fromCharCode(str.charCodeAt(i) - 12256);
			continue;
		}
		if (str.charCodeAt(i) > 65280 && str.charCodeAt(i) < 65375)
			result += String.fromCharCode(str.charCodeAt(i) - 65248);
		else
			result += String.fromCharCode(str.charCodeAt(i));
	}
	return result;
}