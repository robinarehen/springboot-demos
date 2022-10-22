window.onload = function() {
	initMaterialize();
	validarLogin();
}

function validarLogin() {
	var url = window.location.search;
	if (url.includes('error')) {
		var information = {
			code : httpStatus.badRequest,
			message : 'Usuario o Contraseña no valido.'
		};
		showToast(information);
	}
}

function iniciarLogin(idForm) {

	var disabled = 'disabled';
	var displayNone = 'display-none';

	var btnSummit = document.getElementById('btn-summit');
	btnSummit.classList.add(disabled);

	var loadingLogin = document.getElementById('loading-login');
	loadingLogin.classList.remove(displayNone);

	var response = validarForm(idForm);
	
	if(!response){
		btnSummit.classList.remove(disabled);
		loadingLogin.classList.add(displayNone);		
	}

	return response;
}
