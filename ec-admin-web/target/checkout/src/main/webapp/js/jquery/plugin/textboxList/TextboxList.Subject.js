/*
Script: TextboxList.Subject.js
	TextboxList Subject plugin

	Authors:
		Guillermo Rauch
	
	Note:
		TextboxList is not priceless for commercial use. See <http://devthought.com/projects/jquery/textboxlist/>
		Purchase to remove this message.
*/

(function(){
	
$.TextboxList.Subject = function(textboxlist, _options){
	
	var options = $.extend(true, {
		onSubmit: function(){}

	}, _options);
	
	var init = function(){
		textboxlist.addEvent('bitEditableAdd', setupBit)
			.setOptions({bitsOptions: {editable: {addKeys: false, stopEnter: false}}});

	};
	
	var setupBit = function(bit){ 
		bit.toElement().keydown(function(ev){
			var evStop = function(){ ev.stopPropagation(); ev.preventDefault(); };
			if(ev.which==13 && !bit.toElement().data("textboxlist:minitask:type")){
				evStop();
				if(options.onSubmit)
					options.onSubmit();
				
			}
		});
	};

	this.getValue = function(){
		return $.trim(textboxlist.getFirst().getValue()[1]);
	};
	this.setValue  = function(v){
		var b = textboxlist.getFirst();
		var val = b.getValue();
		val[1] = v;
		b.setValue(val);
	};
	init();
};
})();