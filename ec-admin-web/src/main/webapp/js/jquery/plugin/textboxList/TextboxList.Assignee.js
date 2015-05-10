/*
Script: TextboxList.Assignee.js
	TextboxList Assignee plugin

	Authors:
		Guillermo Rauch
	
	Note:
		TextboxList is not priceless for commercial use. See <http://devthought.com/projects/jquery/textboxlist/>
		Purchase to remove this message.
*/

(function(){
	
$.TextboxList.Assignee = function(textboxlist, _options){
	
	var index, prefix, method, container, list, assignees=[], values = [], searchValues = [],currentKey="scopes",remoteDatas = [], results = [],scopeId, current, currentInput, hidetimer, doAdd, currentSearch, currentRequest;
	var options = $.extend(true, {
		minLength: 0,
		maxResults: 10,
		insensitive: true,
		highlight: true,
		highlightSelector: null,
		mouseInteraction: true,
		onlyFromValues: false,
		queryRemote: false,
	    remote: {
				scopeUrl: '',
				assigneeUrl: '',
				scopeParam: {},
				loadPlaceholder: 'Please wait...'
	    },
		method: 'standard',
		scopeId:'',
		
		assigneeId:""
	}, _options);
	
	var init = function(){
		textboxlist.addEvent('bitEditableAdd', setupBit)
			.addEvent('bitEditableFocus', search)
			.addEvent('bitEditableBlur', hide)
			.addEvent('bitBoxRemove', onBitBoxRemove)
			.setOptions({bitsOptions: {editable: {addKeys: false, stopEnter: false}}});
		if ($.browser.msie) textboxlist.setOptions({bitsOptions: {editable: {addOnBlur: false}}});
		prefix = textboxlist.getOptions().prefix + '-assignee';
		method = $.TextboxList.Assignee.Methods[options.method];
		container = $('<div style="position:relative;" class="'+ prefix +'" />').width(textboxlist.getContainer().actual( 'width' )).appendTo(textboxlist.getContainer());
		list = $('<ul class="'+ prefix +'-results" />').appendTo(container).click(function(ev){
			ev.stopPropagation(); ev.preventDefault();
		});
		initScopes();
	};

	var initScopes = function(){
		if((!remoteDatas["scopes"])||remoteDatas["scopes"].length==0){
			if (currentRequest) currentRequest.abort();
			currentRequest = $.ajax({
				url: options.remote.scopeUrl,
				data: options.remote.scopeParam,
				dataType: 'json',
				success: function(data){
					remoteDatas["scopes"] = new Array();
					var scopes = remoteDatas["scopes"];
					for(var i=0;i<data.length;i++){
						var scopeList = data[i].data;
						for(var j=0;j<scopeList.length;j++){
							var scope = new Array();
							var id = scopeList[j].id;
							var dataScope = data[i].dataScope;
							var name = data[i].isShowFollowedObjectType=="false"?dataScope:scopeList[j].name;
							var followedObjectClazz = data[i].followedObjectClazz;
							scope[0]=id;
							scope[1]=name;
							scope[2]=name;
							scope[3]=name;
							scope[4]=followedObjectClazz;
							
							scopes[scopes.length]=scope;
						}
					}
				}
			});
		}
	};
	var initAssignees =  function(scopeId,followedObjectClazz,scopeName){
		if((!remoteDatas[scopeId])||remoteDatas[scopeId].length==0){
			if (currentRequest) currentRequest.abort();
			currentRequest = $.ajax({
				url: options.remote.assigneeUrl,
				data: {followedType:followedObjectClazz,followedId:scopeId},
				dataType: 'json',
				success: function(json){
					var datas = new Array();
					for(var i=0;i<json.length;i++){
						var data = new Array();
						data[0]=json[i].value;
						data[1]=json[i].indexName;
						data[2]=(json[i].name+"&nbsp;@"+scopeName);
						data[3]=json[i].name;
						datas[i]=data;
					}
					remoteDatas[scopeId]=datas;
					showResults("");
					
				}
			});
		}else{
			showResults("");
		}
	};
	var setupBit = function(bit){ 
		bit.toElement().keydown(function(ev){
			var evStop = function(){ ev.stopPropagation(); ev.preventDefault(); };
			if(ev.which==50 && ev.shiftKey && !$(options.assigneeId).val()&&!currentInput.toElement().data("textboxlist:minitask:type")){
				evStop();
				var b = textboxlist.create('editable',["@",""],{bitPrefix:"-bit-assignee"});
				b.inject(currentInput.toElement(), 'after');
				b.toElement().data("textboxlist:minitask:type","-bit-assignee");
				currentInput = b;
				textboxlist.getBit(currentInput).focus();
				b.toElement().keydown(navigate).keyup(function(b){
					search();
				});
				search();
			}
		});
	};
	
	var search = function(bit){
		if (bit) {
			currentInput = bit;
			return;
		}
		values = remoteDatas[currentKey];
		if (!values||!values.length) return;
		var search = $.trim(currentInput.getValue()[1]);
		if (search == currentSearch) return;
		currentSearch = search;
		list.css('display', 'none');
		if (search.length < options.minLength) return;
		showResults(search);
	};
	
	var showResults = function(search){
		var results = method.filter(values, search, options.insensitive, options.maxResults);
			results = $.grep(results, function(v){ return (!assignees[v[0]])||assignees[v[0]]==0; });		
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
			if(data=="-bit-assignee"){
				assignees[bit.getValue()[0]]=0;
				if($("li.textboxlist-bit-assignee",textboxlist.list).length==0)
					currentKey="scopes";
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
		if(currentKey=="scopes"){
			currentKey=value[0];

			values =[];
				list.css('display', 'none');
				currentSearch = null;		

			var val = currentInput.getValue();
			val[1]="";
			currentInput.setValue(val);
			initAssignees(value[0],value[4],value[1]);
		}else{
			//$(options.assigneeId).val(value[0]);

			var b = textboxlist.create('box', value.slice(0, 3),{bitPrefix:currentInput.toElement().data("textboxlist:minitask:type")});

			if (b){
				assignees[value[0]]=1;
				b.autoValue = value;
				if ($.isArray(index)) index.push(value);
				b.inject(currentInput.toElement(), 'before');
				currentInput.remove();
				textboxlist.focusFirst();
			}
			blur();
			return self;
		}
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
							val[1] += "@";
							prev.setValue(val);
						}
						currentInput.remove();
						prev.focus();
					}else{
						currentInput.remove();
					}
					if($("li.textboxlist-bit-assignee",textboxlist.list).length==0)
						currentKey="scopes";
					return false;
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
		}
	};

	this.addAssignee = function(value){
		var b = textboxlist.create('box', value.slice(0, 3),{bitPrefix:"-bit-assignee"});

		if (b){
			textboxlist.focusFirst();
			assignees[value[0]]=1;
			b.autoValue = value;
			if ($.isArray(index)) index.push(value);
			b.inject(currentInput.toElement(), 'after');
		}
		blur();
		return self;
	};
	this.getAssignees = function(){
		var values = [];
		$("li.textboxlist-bit-assignee",textboxlist.list).each(function(){
			var bit = textboxlist.getBit(this);
			if (!bit.is('editable')) values.push(bit.getValue());
		});
		return values;
	};
	this.reset = function(){
		assignees = [];
		index = [];
		currentKey="scopes";
	};
	this.setValues = function(v){
		values = v;
	};
	this.getScopeId = function(){
		return currentKey;
	};
	
	init();
};

$.TextboxList.Assignee.Methods = {
	
	standard: {
		filter: function(values, search, insensitive, max){
			var newvals = [], regexp = new RegExp(escapeRegExp(search));  
			//var newvals = [], regexp = new RegExp('\\b' + escapeRegExp(search), insensitive ? 'i' : '');
			for (var i = 0; i < values.length; i++){
				if (newvals.length === max) break;
				if (regexp.test(values[i][1])) newvals.push(values[i]);
			}
			
			return newvals;
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