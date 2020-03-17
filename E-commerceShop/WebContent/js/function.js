function change(img){
	img.src = "getcode?"+new Date().getTime();
}

function FocusItem(obj){
	if($(obj).attr('name') == 'verycode'){
		$(obj).next().next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}
		
}

function CheckItem(obj){
	
	
}