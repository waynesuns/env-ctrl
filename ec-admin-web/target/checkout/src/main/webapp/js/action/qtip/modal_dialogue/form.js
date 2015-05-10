var theModalForm;
function showModalForm(html,title,width,callbacks){
	if(theModalForm!=null){
		destoryModalForm();
	}
	if(width==null)
		width = 400;
	theModalForm = $('<div/>').qtip(
	{
		id: 'login', // Since we're only creating one modal, give it an ID so we can style it
		content: {
			text: html,
			title: {
				text: title,
				button: false
			}
		},
		position: {
			my: 'center', // ...at the center of the viewport
			at: 'center',
			target: $(window),
			viewport: $(window.top),
			adjust: {
		       y: ((window.top==window)?0:-700)
			}


		},
		show: {
			event: 'click', // Show it on click...
			ready: true, // Show it immediately on page load.. force them to login!
			modal: {
				on: true,

				// Don't let users exit the modal in any way
				blur: false, escape: false
			}
		},
		hide: false,
		style: {
			classes: 'qtip-light qtip-rounded',
			width: width, // Overrides width set by CSS (but no max-width!)
			tip: false
		},
		events: {
			 render: function(event, api) {
				 if(callbacks!=null){
					 if(typeof(callbacks)=="function"){
						 callbacks();
					 }else if(typeof(callbacks)=="object"){
						 var length = callbacks.length;
						 if(length!=null){
							 for(var i=0;i<length;i++){
								 callbacks[i]();
							 }
						 }
					 }
				 }
			 },
		 	 show: function(event, api) {
			 }
		}
	});
}
function destoryModalForm(){
	$(theModalForm).remove();
	theModalForm=null;
}

function showStaticModalForm(html,title,width,callbacks){
	if(theModalForm!=null){
		destoryModalForm();
	}
	if(width==null)
		width = 400;
	theModalForm = $('<div/>').qtip(
	{
		id: 'login', // Since we're only creating one modal, give it an ID so we can style it
		content: {
			text: html,
			title: {
				text: title,
				button: false
			}
		},
		position: {
			my : 'top middle',
			at : 'top middle',
			target: $(window),
			viewport: $(window),
			adjust: {
		       y: 70
			}

		},
		show: {
			event: 'click', // Show it on click...
			ready: true, // Show it immediately on page load.. force them to login!
			modal: {
				on: true,

				// Don't let users exit the modal in any way
				blur: false, escape: false
			}
		},
		hide: false,
		style: {
			classes: 'qtip-light qtip-rounded',
			width: width, // Overrides width set by CSS (but no max-width!)
			tip: false
		},
		events: {
			 render: function(event, api) {
				 if(callbacks!=null){
					 if(typeof(callbacks)=="function"){
						 callbacks();
					 }else if(typeof(callbacks)=="object"){
						 var length = callbacks.length;
						 if(length!=null){
							 for(var i=0;i<length;i++){
								 callbacks[i]();
							 }
						 }
					 }
				 }
			 },
		 	 show: function(event, api) {
			 }
		}
	});
}