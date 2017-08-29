var KE = parent.KindEditor;
location.href.match(/\?id=([\w-]+)/i);
var id = RegExp.$1;
KE.event.ready(function() {
	var html = KE.html(id);
	html = "<div class='contain'>" + html + "</div>"
	document.body.innerHTML = html;
	KE.util.pluginLang('preview', document);
	KE.util.hideLoadingPage(id);
}, window, document);

$(document).ready(function(){
	stretch();
	imagePreview();
	flashPreview(); 
})
/**ͼƬ���*/
this.imagePreview = function(){	
	xOffset = -10;
	yOffset = -100;
	$("img.point").hover(function(e){
		$("body").append("<p id='preview'><img src='"+ this.src +"' /></p>");
		$("#preview")
		.css("top",(e.pageY - xOffset) + "px","left",
			(e.pageX + yOffset) + "px")
			.fadeIn("fast");						
	},
	function(){
		$("#preview").remove();
	});	
	$("img.point").mousemove(function(e){
		$("#preview")
		.css("top",(e.pageY - xOffset) + "px")
		.css("left",(e.pageX + yOffset) + "px");
	});			
};
/**��������*/
this.stretch = function(){
	var stretch;//���������ť���
	if($.browser.msie){//ie
		$(".stretch > pre").each(function(){ //��֪Ϊʲôie��pre��dd����Ԫ��
			$(this).css("visibility","hidden");
		});
		stretch = $(".stretch .point");
	}else{ //����
		$(".stretch ~ pre").each(function(){ //dd��ͬ��Ԫ��
			$(this).css("visibility","hidden");
		});
		stretch = $(".stretch");
	}
	stretch.click(function(){
		var pre = $(this).nextAll("pre:first");//��һ��preԪ��
		var img = $(this).find(".point img");
		var src = img.attr("src");
		if(pre.css("visibility")=="hidden"){
			pre.css("visibility","inherit");
			src = src.replace("images/expand.gif","images/collapse.gif");
			img.attr("src",src);
		}else{
			pre.css("visibility","hidden");
			src = src.replace("images/collapse.gif","images/expand.gif");
			img.attr("src",src);
		}
		return false;
	});
};
/**�������*/
this.flashPreview = function(){
	$("a.flash").click(function(e){
		if($("#flash").length>0){$("#flash").remove()};//flash������ȥ��
		var win = $(window.parent).length>0 ? $(window.parent) : $(window);//�ж��Ƿ���iframe������
		var sTop,sLeft;
		if(window.parent.document!=document){
			var pdoc = $(window.parent.document);//ȡ������document
			var iframeTop = $("#iframe",pdoc).position().top;
			var iframeLeft = $("#iframe",pdoc).position().left;
			if(pdoc.scrollLeft()>iframeLeft){
				sLeft = pdoc.scrollLeft() - $(document).scrollLeft() - iframeLeft;
			}else{
				sLeft = - 2*iframeLeft/3;
			}
			if(pdoc.scrollTop()>iframeTop){
				sTop = pdoc.scrollTop() - $(document).scrollTop() - iframeTop;
			}else{
				sTop = - iframeTop/2;
			}
		}else{
			sLeft = $(document).scrollLeft();
			sTop = $(document).scrollTop();
		}
		//���뵽body��
		$("body").append("<div id='flash'>"+
			             "<a href='#' class='closeView'></a>"+
		                 "<div id='flashView'></div></div>");
		$("#flash").css({//��ʾflashλ��
			position:'absolute',
			left: (win.width()/2 - $(this).outerWidth())/2 + sLeft, 
			top: (win.height()/2 - $(this).outerHeight())/2 + sTop,
			display:'block'
		});
		//flash��С
		if($(this).attr("alt")=="game"){
			$("#flash").css({
				width: win.width()/2,
				height:4*win.height()/5
			});
		}else{
			if($.browser.msie){//ie
				$("#flash").css({
					width:5*win.width()/9,
					height:2*win.height()/3
				});
			}else{
				$("#flash").css({
					width:12*win.width()/25,
					height:win.height()/2
				});
			}
		}
		//flash·��
		var src = $(this).attr("href");							 
		$("#flashView").flash(
			{ src: src,
				width: '100%',
				height: '100%' }
		);
		//e.preventDefault();
		//e.stopPropagation();
		$(".closeView").click(function(e){//�رհ�ť
			$("#flash").remove();
			e.preventDefault();
			return false;
		});
		return false;					
	});
};