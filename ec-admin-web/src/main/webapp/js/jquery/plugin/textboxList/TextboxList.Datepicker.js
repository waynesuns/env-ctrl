/*
Script: TextboxList.Datepicker.js
	TextboxList Datepicker plugin

	Authors:
		Guillermo Rauch
	
	Note:
		TextboxList is not priceless for commercial use. See <http://devthought.com/projects/jquery/textboxlist/>
		Purchase to remove this message.
*/

(function(){
	
$.TextboxList.Datepicker = function(textboxlist, _options){
	
  var index, prefix, method, container, list, values = [],  current, currentInput, hidetimer, doAdd, currentSearch,datepicker="";
	var options = $.extend(true, {
		minLength: 0,
		maxResults: 10,
		insensitive: true,
		highlight: false,
		highlightSelector: null,
		mouseInteraction: true,
		onlyFromValues: false,
		method: 'standard',
		firstDate:new Date(),
		
		today:"今天",
		tomorrow:"明天",
		thisFriDay:"本周5",
		nextMonDay:"下周1",
		nextFriDay:"下周5"
	}, _options);
	
	var init = function(){
		textboxlist.addEvent('bitEditableAdd', setupBit)
			.addEvent('bitEditableFocus', search)
			.addEvent('bitEditableBlur', hide)
			.addEvent('bitBoxRemove', onBitBoxRemove)
			.setOptions({bitsOptions: {editable: {addKeys: false, stopEnter: false}}});
		if ($.browser.msie) textboxlist.setOptions({bitsOptions: {editable: {addOnBlur: false}}});
		prefix = textboxlist.getOptions().prefix + '-datepicker';
		method = $.TextboxList.Datepicker.Methods[options.method];
		container = $('<div style="position:relative;" class="'+ prefix +'" />').width(textboxlist.getContainer().actual( 'width' )).appendTo(textboxlist.getContainer());
		list = $('<ul class="'+ prefix +'-results" />').appendTo(container).click(function(ev){
			ev.stopPropagation(); ev.preventDefault();
		});
		initValues(options.firstDate);
	};
	
	var initValues = function(today){
		
		var dates  = [];
		dates[dates.length] = [today,options.today];
		//[31, 'Bit Plain Text', 'Bit html', 'Suggestion item html']
		var theDay = today.getDay();
		if(theDay<5){
			var tomorrow = new Date(today);
			tomorrow.setDate(today.getDate()+1);
			dates[dates.length] = [tomorrow,options.tomorrow];
			if(theDay<4){
				var thisFriDay = new Date(today);
				thisFriDay.setDate(today.getDate()+5-theDay);
				dates[dates.length] = [thisFriDay,options.thisFriDay];
			}
		}
		var nextMonDay = new Date(today);
		nextMonDay.setDate(today.getDate()+8-theDay);
		dates[dates.length] = [nextMonDay,options.nextMonDay];
		var nextFriDay = new Date(today);
		nextFriDay.setDate(today.getDate()+12-theDay);
		dates[dates.length] = [nextFriDay,options.nextFriDay];
		var val = [];
		for(var i=0;i<dates.length;i++){
			var theDate = dates[i];
			val[i]=[theDate[0].toString("yyyy-MM-dd"), theDate[0].toString("yyyy-MM-dd"), theDate[0].toString("yyyy-MM-dd"), theDate[0].toString("yyyy-MM-dd")+"("+theDate[1]+")"];
		}
		values = val;
	};
	var setupBit = function(bit){ 
		bit.toElement().keydown(function(ev){
			var evStop = function(){ ev.stopPropagation(); ev.preventDefault(); };
			if(ev.which==51 && ev.shiftKey && !datepicker&&!currentInput.toElement().data("textboxlist:minitask:type")){
				evStop();
				/*var val = bit.getValue();
				val[1]=val[1].substring(0,val[1].length);
				bit.setValue(val);*/
				var b = textboxlist.create('editable',["#",options.firstDate.toString("yyyy-MM-dd")],{bitPrefix:"-bit-datepicker",growingOptions:{startWidth:89}});
				b.inject(currentInput.toElement(), 'after');
				b.toElement().data("textboxlist:minitask:type","-bit-datepicker");
				currentInput = b;
				textboxlist.getBit(currentInput).focus();
				b.toElement().keydown(navigate).keyup(function(b){
					search();
				});

				$("input",$(b.toElement())).mask("9999-99-99");
				search();
				
				
			}
		});
	};
	
	var search = function(bit){
		if (bit) {
			currentInput = bit;
			return;
		}
		if (!values.length) return;
		var search = $.trim(currentInput.getValue()[1]);
		if (search == currentSearch) return;
		currentSearch = search;
		list.css('display', 'none');
		if (search.length < options.minLength) return;
		
		showResults(search);
	};
	
	var showResults = function(search){
		var results = method.filter(values, search, options.insensitive, options.maxResults);
		if (textboxlist.getOptions().unique){
			results = $.grep(results, function(v){ return textboxlist.isDuplicate(v) == -1; });		
		}
		if (!results.length) return;
		blur();
		list.empty().css('display', 'block');
		$.each(results, function(i, r){ addResult(r, search); });
		if (options.onlyFromValues) focusFirst();
		results = results;
	};
	
	var addResult = function(r, searched){
		var element = $('<li class="'+ prefix +'-result" />').html(r[3] ? r[3] : r[1]).data('textboxlist:auto:value', r);		
		element.appendTo(list);
		if (options.highlight) $(options.highlightSelector ? element.find(options.highlightSelector) : element).each(function(){
			if ($(this).html()) method.highlight($(this), searched, options.insensitive, prefix + '-highlight');
		});
		if (options.mouseInteraction){
			element.css('cursor', 'pointer').hover(function(){ focus(element); }).mousedown(function(ev){
				ev.stopPropagation(); 
				ev.preventDefault();
				clearTimeout(hidetimer);
				doAdd = true;
			}).mouseup(function(){
				if (doAdd){
					addCurrent();
					currentInput.focus();
					search();
					doAdd = false;
				}
			});
			if (!options.onlyFromValues) element.mouseleave(function(){ if (current && (current.get(0) == element.get(0))) blur(); });	
		}
	};
	
	var hide = function(bit){
		if(bit.toElement().data("textboxlist:minitask:type")){
			bit.remove();
		}
		
		hidetimer = setTimeout(function(){
			list.css('display', 'none');
			currentSearch = null;			
		}, $.browser.msie ? 150 : 0);
	};

	var onBitBoxRemove = function(bit){
		var data = bit.options.bitPrefix;
		if(data){
			if(data=="-bit-datepicker"){
				datepicker="";
			}
		}
	};
	var focus = function(element){
		if (!element || !element.length) return;
		blur();
		current = element.addClass(prefix + '-result-focus');
	};
	
	var blur = function(){
		if (current && current.length){
			current.removeClass(prefix + '-result-focus');
			current = null;
		}
	};
	
	var focusFirst = function(){
		return focus(list.find(':first'));
	};
	
	var focusRelative = function(dir){
		if (!current || !current.length) return self;
		return focus(current[dir]());
	};
	
	var addCurrent = function(){
		var value = current.data('textboxlist:auto:value');
		datepicker=value[0];
		var b = textboxlist.create('box', value.slice(0, 3),{bitPrefix:currentInput.toElement().data("textboxlist:minitask:type")});
		if (b){
			b.autoValue = value;
			if ($.isArray(index)) index = [value];
			b.inject(currentInput.toElement(), 'before');
			currentInput.remove();
			textboxlist.focusFirst();
		}
		blur();
		return self;
	};
	
	var navigate = function(ev){
		var evStop = function(){ ev.stopPropagation(); ev.preventDefault(); };
		switch (ev.which){
			case 8:
			case 46:
				if(currentInput.getValue()[1].length==0){
					var prev = textboxlist.getBit(currentInput.toElement().prev());
					if((prev && prev.is('editable'))||!currentInput.is('box')){
						if(prev && prev.is('editable')){
							var val = prev.getValue();
							val[1] += "#";
							prev.setValue(val);
						}
						currentInput.remove();
						prev.focus();
					}else{
						currentInput.remove();
					}
				}
				break;
			case 38:			
				evStop();
				(!options.onlyFromValues && current && current.get(0) === list.find(':first').get(0)) ? blur() : focusRelative('prev');
				break;
			case 40:			
				evStop();
				(current && current.length) ? focusRelative('next') : focusFirst();
				break;
			case 13:
				evStop();
				if (current && current.length) addCurrent();
				else if (!options.onlyFromValues){
					var value = currentInput.getValue();	
					var d = Date.parse(value[1]);
					if(!d || d<Date.today()){
						return;
					}
						
					datepicker=value[1];
					var b = textboxlist.create('box', value,{bitPrefix:currentInput.toElement().data("textboxlist:minitask:type")});
					if (b){
						b.inject(currentInput.toElement(), 'before');
						currentInput.remove();
						textboxlist.focusFirst();
					}
				}
		}
	};

	this.getValue = function(){
		return datepicker;
	};
	this.setValue = function(v){
		var d = Date.parse(v);
		if(!d || d<Date.today()){
			return;
		}
		datepicker=v;
		if(v){
			var value=new Array();
			value[0]=v;
			value[1]=v;
			value[2]=v;
			var b = textboxlist.create('box', value,{bitPrefix:"-bit-datepicker"});
			if (b){
				textboxlist.focusFirst();
				b.autoValue = value;
				if ($.isArray(index)) {
					index = [value];
				}
				b.inject(currentInput.toElement(), 'after');
			}
			blur();
		}else{
			datepicker="";
			if ($.isArray(index)) {
				index = [];
			}
		}
		return self;
	};
	this.setValues = function(v){
		values = v;
	};
	
	init();
};

$.TextboxList.Datepicker.Methods = {
	
	standard: {
		filter: function(values, search, insensitive, max){
			/*var newvals = [], regexp = new RegExp(escapeRegExp(search));  
			//var newvals = [], regexp = new RegExp('\\b' + escapeRegExp(search), insensitive ? 'i' : '');
			for (var i = 0; i < values.length; i++){
				if (newvals.length === max) break;
				if (regexp.test(values[i][1])) newvals.push(values[i]);
			}
			*/
			return values;
		},
		
		highlight: function(element, search, insensitive, klass){
			var regex = new RegExp(search);  
		    return element.html(element.html().replace(regex, '<strong class="'+ klass +'">' + search + '</strong>'));
/*			var regex = new RegExp('(<[^>]*>)|(\\b'+ escapeRegExp(search) +')', insensitive ? 'ig' : 'g');
			return element.html(element.html().replace(regex, function(a, b, c){
				return (a.charAt(0) == '<') ? a : '<strong class="'+ klass +'">' + c + '</strong>'; 
			}));*/
		}
	}
	
};

var chk = function(v){ return !!(v || v === 0); };
var escapeRegExp = function(str){ return str.replace(/([-.*+?^${}()|[\]\/\\])/g, "\\$1"); };

})();