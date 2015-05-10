function showFitting(thiz){
	$("div[class^='sub_nav']").show();
	$("div.left_c").find("li").each(function(){
		$(this).removeClass("current");
	});
	$(thiz).addClass("current");
	jump('fitting_main.html');
}