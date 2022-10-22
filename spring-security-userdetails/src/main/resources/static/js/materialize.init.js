var httpStatus = {
	ok : '200',
	created : '201',
	badRequest : '400',
	serverError : '500'
};

window.onload = function() {
	initMaterialize();
}

function initMaterialize() {

	var elems = document.querySelectorAll('.sidenav');
	M.Sidenav.init(elems);

	elems = document.querySelectorAll('.tooltipped');
	M.Tooltip.init(elems);

	elems = document.querySelectorAll('select');
	M.FormSelect.init(elems);

	elems = document.querySelectorAll('.collapsible');
	M.Collapsible.init(elems);
}

function showToast(information) {

	var className;
	var htmlMessage;

	switch (information.code) {
	case httpStatus.ok:
	case httpStatus.created:
		className = 'green lighten-1';
		htmlMessage = information.message
		break;
	case httpStatus.badRequest:
	case httpStatus.serverError:
		className = 'red lighten-1';
		htmlMessage = information.message
		break;
	default:
		className = 'red lighten-1';
		htmlMessage = 'Error Inesperado.'
		break;
	}

	M.toast({
		html : htmlMessage,
		classes : className
	});
}

function validarForm(idForm) {

	var inputsValidos = true;
	var form = document.getElementById(idForm);
	var inputs = form.getElementsByClassName('validate');

	for (var i = 0; i < inputs.length; i++) {
		if (inputs[i].value.trim().length == 0) {
			inputsValidos = false;
			inputs[i].className = 'validate invalid';
		}
	}

	if (!inputsValidos) {
		var information = {
			code : httpStatus.badRequest,
			message : 'Campos obligatorios sin completar'
		};

		showToast(information);
	}

	return inputsValidos;
}

function mensajeCrear(message) {
	var inputRespuesta = document.getElementById('inputRespuesta');
	if (inputRespuesta == null || inputRespuesta.value.length == 0) {
		return;
	}

	var information = {
		code : inputRespuesta.value,
		message : message
	};

	showToast(information);
}
