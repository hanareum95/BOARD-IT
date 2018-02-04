function btnSubmitClicked() {
	var opener = window.opener.name;
	var value = document.c_form.c_txt.value;
	
	window.opener.setBoardName(opener, value);
	self.close();
}

function btnCancelClicked() {
	self.close();
}