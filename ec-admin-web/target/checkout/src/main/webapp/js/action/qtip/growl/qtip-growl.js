$(document).ready(function() {
	window.createGrowl = function(persistent, text, styleCss, time) {
		var target = $('.qtip.jgrowl:visible:last');
		$(document.body).qtip({
			content : {
				text : text
			},
			position: {
				my : 'top middle',
				at : (target.length ? 'bottom' : 'top') + ' middle',
				target: $(window),
				viewport: $(window.top),
				adjust: {
			       y: 70
				}
			},
			show : {
				event : false,
				ready : true,
				effect : function() {
					$(this).stop(0, 1).fadeIn(400);
				},
				delay : 0,
				persistent : persistent
			},
			hide : {
				event : "mousedown",
				effect : function(api) {
					$(this).stop(0, 1).fadeOut(400).queue(function() {
						api.destroy();
						updateGrowls();
					});
				}
			},
			style : {
				
				classes : styleCss,
				tip : false
			},
			events : {
				render : function(event, api) {
					timer.call(api.elements.tooltip, event, time);
				}
			}
		}).removeData('qtip');
	};
	window.createModal=function(titleText,text,styleCss){
		var target = $('.qtip.jgrowl:visible:last');
		$(document.body).qtip(
				   {
					   id: 'qtipModaldiv',
				      content: {
				         title: {
				            text: titleText,
				            button: '关闭'
				         },
				         text: text
				      },
						position: {
							my : 'top middle',
							at : (target.length ? 'bottom' : 'top') + ' middle',
							target: $(window),
							viewport: $(window.top),
							adjust: {
						       y: 70
							}
						},
				      show: {
				    	  event : false, 
							ready : true
				      },
				      hide: false,
				      events : {
							render : function(event, api) {
								$("div[role='alert']").css("line-height",1.5);
								$("div[role='alert'] a").attr("class","qtip_close");
								$("div[role='alert'] span ").attr("class","");
								$("div[role='alert'] div.ui-tooltip-content").css("max-height","400px");
								$("div[role='alert'] div.ui-tooltip-content").css("overflow-y","auto");
							}
						},
				      style: {
				    	  classes:styleCss,
				    	  tip : false
				      }});
	};
	window.updateGrowls = function() {
		var each = $('.qtip.jgrowl:not(:animated)');
		each.each(function(i) {
			var api = $(this).data('qtip');
			api.options.position.target = !i ? $(document.body) : each.eq(i - 1);
			api.set('position.at', (!i ? 'top' : 'bottom') + ' middle');
		});
	};
	function timer(event, time) {
		var api = $(this).data('qtip'), lifespan = time;
		if (api.get('show.persistent') === true) {
			return;
		}
		clearTimeout(api.timer);
		if (event.type !== 'mouseover') {
			api.timer = setTimeout(api.hide, lifespan);
		}
	}
	$(document).delegate('.qtip.jgrowl', 'mouseover mouseout', timer);
});
// 信息提示
function qtipInfo(text) {
	createGrowl(false, text, 'ui-tooltip-tips-info', 4000);
}
// 成功提示
function qtipSuccess(text) {
	createGrowl(false, text, 'tiny_tip_wrapper ui-tooltip-tips-success', 4000);
}
// 错误提示
function qtipError(text) {
	createGrowl(false, text, 'tiny_tip_wrapper ui-tooltip-tips-error', 6000);
}
// 警告提示
function qtipWarning(text) {
	createGrowl(false, text, 'tiny_tip_wrapper ui-tooltip-tips-warning', 6000);
}

function qtipModalInfo(titleText,text){
	createModal(titleText,text,'ui-tooltip-tips-info');
}
function qtipModalSuccess(titleText,text){
	createModal(titleText,text,'tiny_tip_wrapper ui-tooltip-tips-success');
}
function qtipModalError(titleText,text){
	createModal(titleText,text,'tiny_tip_wrapper ui-tooltip-tips-error');
}
function qtipModalWarning(titleText,text){
	createModal(titleText,text,'tiny_tip_wrapper ui-tooltip-tips-warning');
}
