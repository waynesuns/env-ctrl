var theLockScreen;
function lockScreen(html){
	if(theLockScreen!=null){
		openScreen();
	}
	theLockScreen = $('<div/>').qtip(
	{
		id: 'login', // Since we're only creating one modal, give it an ID so we can style it
		content: {
			text: html
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
			tip: false
		},
		events: {
		}
	});
}
function openScreen(){
	$(theLockScreen).remove();
	theLockScreen=null;
	if($("#qtip-overlay")!=null){
		$("#qtip-overlay").css("z-index",16000);
	}
}