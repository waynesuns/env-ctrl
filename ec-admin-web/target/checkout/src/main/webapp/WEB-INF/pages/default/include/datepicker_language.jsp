<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
var dayNamesLanguage = ['<fmt:message key="common.week.Sunday"/>','<fmt:message key="common.week.Monday"/>','<fmt:message key="common.week.Tuesday"/>','<fmt:message key="common.week.Wednesday"/>','<fmt:message key="common.week.Thursday"/>','<fmt:message key="common.week.Friday"/>','<fmt:message key="common.week.Saturday"/>'];
var dayNamesMinLanguage = ['<fmt:message key="common.week.Sun"/>','<fmt:message key="common.week.Mon"/>','<fmt:message key="common.week.Tue"/>','<fmt:message key="common.week.Wed"/>','<fmt:message key="common.week.Thu"/>','<fmt:message key="common.week.Fri"/>','<fmt:message key="common.week.Sat"/>'];
var monthNamesLanguage = ['<fmt:message key="common.month.Jan"/>','<fmt:message key="common.month.Feb"/>','<fmt:message key="common.month.Mar"/>','<fmt:message key="common.month.Apr"/>','<fmt:message key="common.month.May"/>','<fmt:message key="common.month.Jun"/>','<fmt:message key="common.month.Jul"/>','<fmt:message key="common.month.Aug"/>','<fmt:message key="common.month.Sep"/>','<fmt:message key="common.month.Oct"/>','<fmt:message key="common.month.Nov"/>','<fmt:message key="common.month.Dec"/>'];
var monthNamesMinLanguage = ['<fmt:message key="common.month.Jan"/>','<fmt:message key="common.month.Feb"/>','<fmt:message key="common.month.Mar"/>','<fmt:message key="common.month.Apr"/>','<fmt:message key="common.month.May"/>','<fmt:message key="common.month.Jun"/>','<fmt:message key="common.month.Jul"/>','<fmt:message key="common.month.Aug"/>','<fmt:message key="common.month.Sep"/>','<fmt:message key="common.month.Oct"/>','<fmt:message key="common.month.Nov"/>','<fmt:message key="common.month.Dec"/>'];

$.datepicker.regional['zh-CN'] = {
	closeText: '<fmt:message key="common.close"/>',
	prevText: '<fmt:message key="common.datepicker.prevText"/>',
	nextText: '<fmt:message key="common.datepicker.nextText"/>',
	currentText: '<fmt:message key="common.datepicker.today"/>',
	monthNames: monthNamesLanguage,
	monthNamesShort: monthNamesMinLanguage,
	dayNames: dayNamesLanguage,
	dayNamesShort: dayNamesMinLanguage,
	dayNamesMin: dayNamesMinLanguage,
	weekHeader: '<fmt:message key="common.week.title"/>',
	dateFormat: 'yy-mm-dd',
	firstDay: 1,
	isRTL: false,
	showMonthAfterYear: true,
	yearSuffix: '<fmt:message key="common.year.title"/>'
};
$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
$.timepicker.regional['zh-CN'] = {
	timeOnlyTitle: '<fmt:message key="common.datepicker.time.select.title"/>',
	timeText: '<fmt:message key="common.time"/>',
	hourText: '<fmt:message key="common.hour"/>',
	minuteText: '<fmt:message key="common.minute"/>',
	secondText: '<fmt:message key="common.second"/>',
	millisecText: '<fmt:message key="common.millisecond"/>',
	currentText: '<fmt:message key="common.datepicker.today"/>',
	closeText: '<fmt:message key="common.define"/>',
	ampm: false
};
$.timepicker.setDefaults($.timepicker.regional['zh-CN']);
$.datepick.setDefaults($.datepick.regional['<fmt:message key="common.datepick"/>']);
$.datepick.setDefaults({dateFormat:'yyyy-mm-dd'});

// 将输入框变为日期选择
// 参数：输入框的ID，不包括#号
function initDatepickerNextDay(obj) {
	$('#'+obj).datepicker({
		showTrigger: '#calImg',
		minDate : 0
	});
	addObjDisabled(new Array(obj));
}
// 报表，没有时间限制的时间  
function initStatDatepickerNextDay(obj) {
	$('#'+obj).datepicker({
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}
function initDatepicker(obj) {
	$('#'+obj).datepick({
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}

function initDatepickerAndSelect(obj,inputId) {
	$('#'+obj).datepick({
		onSelect : function(dates){
			$("#"+inputId).val($('#'+obj).val());
		},
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}
function initDatepickerByMinAndMax(obj,minDate,maxDate) {
	$('#'+obj).datepick({
		minDate : minDate,
		maxDate : maxDate,
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}
function initDatepickerByMax(obj,obj2,minDate,maxDate){
	$('#'+obj).datepick({
		onSelect : function(dates){
			$("#"+obj2).removeClass("hasDatepick");
			initDatepickerByMinAndMax(obj2,$('#'+obj).val(),0);
		},
		maxDate : maxDate,
		minDate : minDate,
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}

// 此方法用于两个输入框，日期从第一个输入框开始，到第二个输入框结束并且第二个输入框日期必须晚于第一个输入框
// 参数：输入框的ID，不包括#号
function initDatepickerM(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		minDate : 0,
		changeMonth:false,
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function initDatepickerMT(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		minDate : 0,
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
			
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}


function initDatepickerMTNoMin(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}
function initDatepickerMTNoMinByNow(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		minDate : 0,
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}
//初始化日历之间相隔不超过一个月
function initDatepickerMTNoOverMonth(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		onSelect: function(dates){
			var showDate = dates[0];
			if(showDate == null || showDate == undefined){
					if (this.id == objFrom) { 
				        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
				    } 
				    else { 
				        $('#'+objFrom).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
				    } 
			}else{
				var year=dates[0].getFullYear();
				var month=dates[0].getMonth()+1;
				var day=dates[0].getDate();
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', new Date(year+"/"+month+"/"+day) || null); 
				dates[0].addMonths(1);
		        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		    else { 
		    	$('#'+objFrom).datepick('option', 'maxDate', new Date(year+"/"+month+"/"+day) || null); 
		    	dates[0].addMonths(-1);
		    	$('#'+objFrom).datepick('option', 'minDate', dates[0]|| null); 
		    } 
			}
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function initDatepickerMTNoOverThreeMonth(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		onSelect: function(dates){
			var showDate = dates[0];
			if(showDate == null || showDate == undefined){
					if (this.id == objFrom) { 
				        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
				    } 
				    else { 
				        $('#'+objFrom).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
				    } 
			}else{
				var year=dates[0].getFullYear();
				var month=dates[0].getMonth()+1;
				var day=dates[0].getDate();
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', new Date(year+"/"+month+"/"+day) || null); 
				dates[0].addMonths(3);
		        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		    else { 
		    	$('#'+objFrom).datepick('option', 'maxDate', new Date(year+"/"+month+"/"+day) || null); 
		    	dates[0].addMonths(-3);
		    	$('#'+objFrom).datepick('option', 'minDate', dates[0]|| null); 
		    } 
			}
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function initDatepickerMTNoMinYearMonth(objFrom, objTo){
	$('#' + objFrom + ', #' + objTo).datepick({dateFormat:"yyyy-mm",
		onSelect: function(dates){
			var showDate = dates[0];
			if(showDate == null || showDate == undefined){
					if (this.id == objFrom) { 
				        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
				    } 
				    else { 
				        $('#'+objFrom).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
				    } 
			}else{
				var fullYear = showDate.getFullYear();
				var month = showDate.getMonth()+1;
				var date = showDate.getDate();
				if (this.id == objFrom) { 
					
			        $('#'+objTo).datepick('option', 'minDate', new Date(fullYear+"/"+month+"/"+date));
			        if(month!=1){
						fullYear = fullYear+1;
					}
			        if(month==1){
			        	month=13;
			        }
			        $('#'+objTo).datepick('option', 'maxDate', new Date(fullYear+"/"+(month-1)+"/"+date)); 
			    } 
			    else { 
			        $('#'+objFrom).datepick('option', 'maxDate', new Date(fullYear+"/"+month+"/"+date)); 
			        if(month!=12){
			    		fullYear = fullYear-1;
					}
			        if(month==12){
			        	month=0;
					}
			        $('#'+objFrom).datepick('option', 'minDate', new Date(fullYear+"/"+(month+1)+"/"+date)); 
			    } 
			}
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function initDatepickerMTNoMinYearFormat(objFrom, objTo,dateFormat){
	$('#' + objFrom + ', #' + objTo).datepick({dateFormat:dateFormat,
		onSelect: function(dates){
			var showDate = dates[0];
			if(showDate == null || showDate == undefined){
					if (this.id == objFrom) { 
				        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objTo).datepick('option', 'maxDate', dates[0] || null); 
				    } 
				    else { 
				        $('#'+objFrom).datepick('option', 'minDate', dates[0] || null); 
				        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
				    } 
			}else{
				var fullYear = showDate.getFullYear();
				var month = showDate.getMonth()+1;
				var date = showDate.getDate();
				if (this.id == objFrom) { 
			        $('#'+objTo).datepick('option', 'minDate', new Date(fullYear+"/"+month+"/"+date)); 
			        fullYear = fullYear+1;
			        $('#'+objTo).datepick('option', 'maxDate', new Date(fullYear+"/"+month+"/"+date)); 
			    } 
			    else { 
			        $('#'+objFrom).datepick('option', 'maxDate', new Date(fullYear+"/"+month+"/"+date)); 
			        fullYear = fullYear-1;
			        $('#'+objFrom).datepick('option', 'minDate', new Date(fullYear+"/"+month+"/"+date)); 
			    } 
			}
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}
function initDatepickerMTNoMinYear(objFrom, objTo) {
	initDatepickerMTNoMinYearFormat(objFrom,objTo,'yyyy-mm-dd');
}
// 报表的日历初始化 
function initDatepickerMTNoMinStat(objFrom, objTo) {
	var dates = $('#' + objFrom + ', #' + objTo).datepicker(
			{
				dateFormat : 'yy-mm-dd',
				autoSize : true,
				changeMonth: true,
				changeYear: true,
				onSelect : function(selectedDate,inst){
					/* var timeStr = $('#timeStr').val(); 
					var year = selectedDate.split('-')[0];
					var month = selectedDate.split('-')[1];
					var day = selectedDate.split('-')[2];
					if(inst.id=="startDateInput"){
						// 按月查询默认开始时间为当月1号 ,年份和月份不变 
						if(timeStr=="month"){
							day = "01"; 
						}
						// 按周查询开始时间默认填充到星期一 ，有可能年份和月份要变化 
						if(timeStr=="week"){
							var time = getDayByWeek(selectedDate)[0].split('-');
							year = time[0];
							month = time[1];
							day = time[2];
						}
						$('#startDateInput').val(year+'-'+month+'-'+day);
						selectedDate = year+'-'+month+'-'+day;
					}
					if(inst.id=="endDateInput"){
						if(timeStr=="month"){
							// 计算出月的最后一天 
							var currentMonth=NewDateParm(year,month,1);  
					        var lastMonth=NewDateParm(year,month-1,1);  
					        var diffDays=currentMonth-lastMonth;
					        var day = (diffDays/( 24 * 60 * 60 * 1000))
						}
						// 按周查询开始时间默认填充到星期一 ，有可能年份和月份要变化 
						if(timeStr=="week"){
							var time = getDayByWeek(selectedDate)[1].split('-'); 
							year = time[0];
							month = time[1];
							day = time[2];
						}
						$('#endDateInput').val(year+'-'+month+'-'+day);
						selectedDate = year+'-'+month+'-'+day;
					} */
					var option = this.id == objFrom ? "minDate" : "maxDate", instance = $(this).data("datepicker"), date = $.datepicker
						.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
					dates.not(this).datepicker("option", option, date);
				}
			});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

//此方法用于两个输入框，日期从第一个输入框开始，到第二个输入框结束并且第二个输入框日期必须晚于第一个输入框
//参数：输入框的ID，不包括#号
function initDatepickerNotMin(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		changeMonth:false,
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function initDatepickerNotMinYM(objFrom, objTo) {
	$('#' + objFrom + ', #' + objTo).datepick({
		onSelect: function(dates){
			if (this.id == objFrom) { 
		        $('#'+objTo).datepick('option', 'minDate', dates[0] || null); 
		    } 
		    else { 
		        $('#'+objFrom).datepick('option', 'maxDate', dates[0] || null); 
		    } 
		},onClose:function(){
			$('#' + objFrom + ', #' + objTo).click();
		},showTrigger: '#calImg'
	});
	var objInput = new Array(objFrom,objTo);
	addObjDisabled(objInput);
}

function addObjDisabled(obj){
	for(var i=0;i<obj.length;i++){
		$('#'+obj[i]).attr('readonly','readonly');
	}
}

//所选日期要早于当前日期，比如生日
function initDatepickerBeforeToday(obj) {
	$('#'+obj).datepick({
		maxDate : 0,
		showTrigger: '#calImg'
	});
	addObjDisabled(new Array(obj));
}

$(document).ready(function() {
	$.datepicker.setDefaults({
		beforeShow : function() {
			setTimeout(function() {
				$('#ui-datepicker-div').css("z-index", 1013);
			}, 100);
		}
	});
});
// 根据日期获取星期一的时间 
function getDayByWeek(date){
		var dateStr = date.split("-");
		var oldDate = NewDateParm(dateStr[0], dateStr[1]-1 ,dateStr[2]);
		var returnDateArr = new Array(2);
		var day = oldDate.getDay();
		if(day == 0){
		var temp1 = oldDate.getTime() -  6 * 24 * 60 * 60 * 1000;
			var temp3 = new Date();
			temp3.setTime(temp1);
		returnDateArr[0] = dateToString(temp3);
		returnDateArr[1] = dateToString(oldDate);
		} else {
			var temp1 = oldDate.getTime() -  (day-1) * 24 * 60 * 60 * 1000;
			var temp2 = temp1 +  6 * 24 * 60 * 60 * 1000;
			var temp3 = new Date();
			var temp4 = new Date();
			temp3.setTime(temp1);
			temp4.setTime(temp2);
		returnDateArr[0] = dateToString(temp3);
		returnDateArr[1] = dateToString(temp4);
		}
		return returnDateArr;
}
function dateToString(date){
	var month = date.getMonth() + 1 + "";
	var day =  date.getDate() + "";
	if(month.length==1)
		month = "0"+month;
	if(day.length==1)
		day = "0"+day;
	return date.getFullYear() + "-" + month + "-" + day ;
}
</script>