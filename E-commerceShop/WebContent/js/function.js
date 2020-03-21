//check success for all conditions
var flag;

function change(img) {
	img.src = "getcode?" + new Date().getTime();
}

function FocusItem(obj) {
	if ($(obj).attr('name') == 'verycode') {
		$(obj).next().next().html('').removeClass('error');
	} else {
		$(obj).next('span').html('').removeClass('error');
	}

}

function CheckItem(obj) {

	var msgBox = $(obj).next('span');

	switch ($(obj).attr('name')) {
	case "username":
		if (obj.value == "") {
			msgBox.html('required username');
			msgBox.addClass('error');
			flag = false;
		} else {
			var url = "usernamecheck?name=" + encodeURI($(obj).val()) + "&"
					+ new Date().getTime();
			$.get(url, function(date) {
				if (date == "false") {
					msgBox.html('username already been used');
					msgBox.addClass('error');
					flag = false;
				} else {
					msg.box.html().removeClass('error');
					flag =true;
				}
			});
		}
		break;

	case "name":
		if (obj.value == "") {
			msgBox.html('required name');
			msgBox.addClass('error');
			flag = false;
		}else{
			flag = true;
		}
		break;

	case "password":
		if (obj.value == "") {
			msgBox.html('required passworrd');
			msgBox.addClass('error');
			flag = false;
		}else{
			flag = true;
		}
		break;

	case "repassword":
		if (obj.value == "") {
			msgBox.html('required repassworrd');
			msgBox.addClass('error');
			flag = false;
		} else if ($(obj).val() != $('input[name="password"]').val()) {
			msgBox.html('password not match');
			msgBox.addClass('error');
			flag = false;
		}else{
			flag = true;
		}
		break;

	case "verycode":
		var numShow = $(obj).next().next();
		if (obj.value == "") {
			numShow.html('required verify code');
			numShow.addClass('error');
			flag = false;
		} else {
			var url = "checkusernum?num=" + encodeURI($(obj).val()) + "&"
					+ new Date().getTime();
			$.get(url, function(numdate) {
				if (numdate == "false") {
					numShow.html('verify code wrong');
					numShow.addClass('error');
					flag = false;
				} else {
					numShow.html().removeClass('error');
					flag = true;
				}
			});
		}

		break;

	}

}

function checkForm(frm) {
	var els = frm.getElementsByTagName('input');
	for(var i = 0; i < els.length; i++){
		if(els[i] != null){
			if(els[i].getAttribute('onblur')){
				CheckItem(els[i]);
			}
		}
	}

	return flag;

}