
	
	function goPage(id, totalPage, getDataFunc)
	{
		var obj = document.getElementById(id);
		var value = Number(obj.value);
		if (isNaN(value) || value <=0 || value > totalPage)
			open_popover("error", "error page number", 3);
		else
			getDataFunc(value);
	}
	function goToHome(){
		self.location=homeLocationPath;
	}
	$.ajaxSetup( {
		ifModified:true,
		cache:false,
		error: function(XMLHttpRequest, textStatus, errorThrown) {
    		//closeBlockUI();
			if(XMLHttpRequest.status==400){
				open_popover("error", XMLHttpRequest.responseText);
				return;
			}else if(XMLHttpRequest.status==203){
				top.window.location="./login.do";
				return;
			}else if(XMLHttpRequest.status==500){
				$('<form action="./500.do?v=123" method="post"><input type="hidden" name="errorInfo" value="'+XMLHttpRequest.responseText+'"/></form>').submit();
				return;
			}else if(XMLHttpRequest.status==404){
				top.window.location="404.do";
				return;
			} else if(XMLHttpRequest.status==403){
				open_popover("error", error403);
				setTimeout("goToHome()", 1000 )	; 
				return;
			}
			open_popover("error", XMLHttpRequest.responseText);
    	} 
	});
	$(document).ready(function() {
		// (input)全局修改全角字符修改为半角字符
		$(":text,:password").bind("blur",function(){
			var val = $(this).val();
			val = fullWidthToHalfWidth(val);
			$(this).val(val);
		});
		// (textarea)全局修改全角字符修改为半角字符
		$("textarea").bind("blur",function(){
			var val = $(this).val();
			val = fullWidthToHalfWidth(val);
			$(this).val(val);
		});
	});


	/**
	 * 初始化上传文件按钮
	 * @param suffix 上传文件form中的元素后缀，以保证同时出现在一个页面时名称区别
	 * ，在share作为附件的区域，suffix参数应当为被添加附件的form的id，以保证在该form中动态添加hidden元素
	 */
	function initFileUpload(suffix,butId) {
	     $('#file_upload_' + suffix).fileUploadUI({
	         namespace: 'file_upload_'+ suffix,
	         fileInputFilter: '#file_'+ suffix,
	         dropZone: $('#drop_zone_'+ suffix),
	         uploadTable: $('#files_'+ suffix ),
	         downloadTable: $('#files_'+ suffix),
	         buildUploadRow: function (files, index) {
	        	 //$("#"+butId).attr("disabled","disabled").addClass("white");
	        	 var fileName = subStr(files[index].name);
	             return $('<tr class="tr_border_bottom"><td style="width:21px;"><\/td><td>' + fileName + '<\/td>' +
	                     '<td class="file_upload_progress" width="177px"><div><\/div><\/td>' +
	                     '<td class="file_upload_cancel"><span class="ui-icon-cancel"><img class="cursor png_bg" src="'+templateImageUrl+'/css/fileupload/share_link_file_delete.png" \/><\/span>' +
	                     '<\/td><\/tr>');
	         },
	         buildDownloadRow: function (jsonList) {
	         	var rtn = "";
	         	for(var i=0;i<jsonList.length;i++)
	         	{
	         		var fileName = subStr(jsonList[i].fileName);
	         		//动态添加hidden对象
	         		//var typeFile = jsonList[i].type;
	         		//var tdHtml = '<td style="padding-bottom:10px;"><img src="'+jsonList[i].areaCode+'/'+jsonList[i].path+'"\/><\/td>';
	         		//if(typeFile == "file")
	         		var tdHtml = '<td style="width:21px;"><img class="png_bg" src="'+templateImageUrl+'/images/document/'+jsonList[i].path+'"\/><\/td>';
	         		var tdHtmlDel = '<td style="width:14px;text-align:right;"><img class="cursor png_bg" src="'+templateImageUrl+'/css/fileupload/share_link_file_delete.png" onclick="delAttach(this,\''+jsonList[i].id+'\')" \/><\/td>';
	         		$("<input>", {type: 'hidden',name: 'attach_id', val: jsonList[i].id}).appendTo($('#'+ suffix));
	         		rtn += '<tr class="tr_border_bottom">'+tdHtml+'<td style="max-width:230px">' + fileName + '<\/td><td width="177px"><\/td>'+tdHtmlDel+'<\/tr>';
	         	}
	         	$("#"+butId).removeAttr("disabled").removeClass("white");
	            return $(rtn);
	         },
	         onProgress:function(event, files, index, xhr, handler){
	        	 if (handler.progressbar) {
	                 handler.progressbar.progressbar(
	                     'value',
	                     parseInt(event.loaded / event.total * 100, 10)
	                 );
	             }
	        	 $("#"+butId).attr("disabled","disabled").addClass("white");
	         }
	     });
	 }
	
	function delAttach(thiz,attachId){
		var bool = false;
		$('input[name=attach_id]:hidden').each(function(){
			var valObj = $(this).val();
			if(valObj == attachId){
				$(this).remove();
				bool = true;
			}
		});
		if(bool){
			$(thiz).parent('td').parent('tr').remove();
		}
	}
	
	function subStr(str){
		var sizeStr = 20;
		if(str == null || str == "")
			return "";
		var icLength = str.lastIndexOf(".");
		var lastLength = str.length - (str.length - icLength);
		var fileType = str.substring(icLength, str.length);
		//str = str.substring(0, sizeStr);
		if(str.length > sizeStr){
			if(lastLength > (sizeStr - 2 - fileType.length)){
				fileType = str.substring(((icLength - sizeStr - fileType.length) > 2 ? icLength - 2 : (icLength - 2) > 0 ? (icLength - 2) : icLength), str.length);
				str = str.substring(0, (sizeStr - fileType.length - 1)) + " ... " + fileType;
			}
		}
		return str;
	}	    

	function HTMLEncode ( input ){
		var converter = $(document.createElement("DIV"));
		converter.text(input);
		return converter.html();
	}

	function HTMLDecode ( input ){
		var converter = $(document.createElement("DIV"));
		converter.html(input);
		return converter.text();
	}
	
	function copyUrl(txt)
	{
		
		if(txt==""||txt==null)
			txt = window.location;
		
		 if(window.clipboardData) { 
             window.clipboardData.clearData(); 
             window.clipboardData.setData("Text", txt); 
		 } else if(navigator.userAgent.indexOf("Opera") != -1) { 
			 window.location = txt; 
		 } else if (window.netscape) { 
          try { 
               netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
          } catch (e) { 
               alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'"); 
          } 
          var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard); 
          if (!clip) 
               return; 
          var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable); 
          if (!trans) 
               return; 
          trans.addDataFlavor('text/unicode'); 
          var str = new Object(); 
          var len = new Object(); 
          var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString); 
          var copytext = txt; 
          str.data = copytext; 
          trans.setTransferData("text/unicode",str,copytext.length*2); 
          var clipid = Components.interfaces.nsIClipboard; 
          if (!clip) 
               return false; 
          clip.setData(trans,null,clipid.kGlobalClipboard); 
		 }
	}
	
function getTexboxListValues(texboxListObject){
	var texboxListObjectValues = texboxListObject.getValues();
	var values = new Array();
	for(var i=0;i<texboxListObjectValues.length;i++){
		values[i]=texboxListObjectValues[i][0];
	}
	return values.join(",");
}

function curDateTime() {
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var day = d.getDay();
	var hours = d.getHours();
	var minutes = d.getMinutes();
	var seconds = d.getSeconds();
	var ms = d.getMilliseconds();
	var curDateTime = year;
	if (month > 9)
		curDateTime = curDateTime + "-" + month;
	else
		curDateTime = curDateTime + "-0" + month;
	if (date > 9)
		curDateTime = curDateTime + "-" + date;
	else
		curDateTime = curDateTime + "-0" + date;
	if (hours > 9)
		curDateTime = curDateTime + " " + hours;
	else
		curDateTime = curDateTime + " 0" + hours;
	if (minutes > 9)
		curDateTime = curDateTime + ":" + minutes;
	else
		curDateTime = curDateTime + ":0" + minutes;
	if (seconds > 9)
		curDateTime = curDateTime + ":" + seconds;
	else
		curDateTime = curDateTime + ":0" + seconds;
	return curDateTime;
}

function objectParsetString(obj){
	if(obj === undefined || obj === null || obj === "" || obj === "undefined")
		return "";
	return obj;
}

function HTMLReplace(str){
	str=str.replace(/\&/,"&amp;");
	str=str.replace(/"/g,"&quot;");
    str=str.replace(/'/g,"&apos;");
	str=str.replace(/\</ig,"&lt;");
    str=str.replace(/\>/ig,"&gt;");
    str=str.replace(/ /ig,"&nbsp;");
    return str;
}

/**
 * 字符串转JSON
 * 
 * @param strData
 * @returns
 */
function parseJSON(strData) {
	return (new Function("return " + strData))();
}

function goBack(){
	window.history.back();
}

function  forDight(Dight,How)  {  
	var d = Math.round(Dight*Math.pow(10,How))/Math.pow(10,How);
	return d.toFixed(How);  
}  
function changeTab(tabTitleDivId,currentTabTitleDivId,tabClass,currentTabDivId){
		$("li",$("#"+tabTitleDivId)).each(function(i){
			if(this.id==currentTabTitleDivId){
				$(this).addClass('on');
			}else{
				$(this).removeClass('on');
			}
		});
		$("."+tabClass).each(function(i){
			if(this.id==currentTabDivId){
				$(this).show();
			}else{
				$(this).hide();
			}
		});
}

function open_popover(type,content,ishtml){
	var type_css="";
	if(type=='success'){
		type_css="popover-content-success";
	}
	if(type=="error"){
		type_css="popover-content-error";
	}
	$('body').popover({
		html:ishtml,
		placement:'auto',
		container:'body',
		content:content,
		trigger:'manual',
		template:'<div class="popover-f fade  in"><div class="popover-content popover-content-f '+type_css+'"></div></div>'
			});
	$('body').on('shown.bs.popover', function () {
		 setTimeout(function () {$('body').popover('hide');$('body').popover('destroy');}, 2000);
		});
	$('body').popover('show');
	$('.popover-f').css('top',$(document).scrollTop()+50+'px');
}
function open_popover_success(content){
	open_popover('success',content,false);
}
function open_popover_error(content){
	open_popover('error',content,false);
}

function initTips(selector){
	$(selector).tooltip({
		//placement:'auto',
		template:'<div class="tooltip"><div class="tooltip-arrow tooltip-arrow-info"></div><div class="tooltip-inner tooltip-inner-info"></div></div>'
	});
}

function open_float_div(selector,ishtml,content,bodyclass){
	$(selector).popover({html:ishtml,
		trigger:'manual',
		placement:'bottom',
		template:'<div class="popover-d fade  in"><div class="popover-content '+bodyclass+'"></div></div>',
		content:content
		});
	$(selector).popover('show');
	var popover=$(selector).next(".popover-d");
	popover[0].style.left=null;
}

function modal_confirm(content,sureAction){
	 $.teninedialog({
         title:'系统提示',
         content:content,
         showCloseButton:false,
         otherButtons:["确定","取消"],
         otherButtonStyles:['btn-primary','btn-default'],
         clickButton:function(sender,modal,index){
        	 if(index==0){
        		 sureAction();
        	 }
        	 $(this).closeDialog(modal);
        	 $(modal).remove();
        	 $(".modal-backdrop").remove();
           
         }
     });
}