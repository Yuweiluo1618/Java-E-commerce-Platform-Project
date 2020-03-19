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
	
	var msgBox = $(obj).next('span');
	
	switch($(obj).attr('name')){
		case "username":
			if(obj.value == ""){
				msgBox.html('required username');
				msgBox.addClass('error');
			}
			break;
		
		case "name":
			if(obj.value == ""){
				msgBox.html('required name');
				msgBox.addClass('error');
			}
			break;
		
		case "password":
			if(obj.value == ""){
				msgBox.html('required passworrd');
				msgBox.addClass('error');
			}
			break;
		
		case"repassword":
			if(obj.value == ""){
				msgBox.html('required repassworrd');
				msgBox.addClass('error');
			}else if($(obj).val() != $('input[name="password"]').val()){
				msgBox.html('password not match');
				msgBox.addClass('error');
			}
			break;
		
		case"verycode":
			var numShow = $(obj).next().next();
			if(obj.value == ""){
				numShow.html('required verify code');
				numShow.addClass('error');
			}
			
			break;
	
	}
	
}