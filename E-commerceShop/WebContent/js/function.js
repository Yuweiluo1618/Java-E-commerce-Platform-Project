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
			}else{
				var url = "usernamecheck?name="+encodeURI($(obj).val()) +"&"+ new Date().getTime();
				$.get(url,function(date){
					if(date == "false"){
						msgBox.html('username already been used');
						msgBox.addClass('error');
					}else{
						msg.box.html().removeClass('error');
					}
				});
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
			}else{
				var url = "checkusernum?num="+ encodeURI($(obj).val()) +"&"+ new Date().getTime();
				$.get(url, function(numdate){
					if(numdate == "false"){
						numShow.html('verify code wrong');
						numShow.addClass('error');
					}else{
						numShow.html().removeClass('error');
					}
				});
			}
			
			break;
	
	}
	
}