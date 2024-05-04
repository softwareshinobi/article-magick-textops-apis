
$(document).ready(function () {
	
	clearFormBoxes();

	setInterval(processForm, 1000);

});

function clearFormBoxes(){

	setInputValue("the-definitive-top-five-guide");

	setLabelValue("");

}

function setInputValue(newStringValue) {

	$("#fromPermalinkInput").val(newStringValue);

}

function setLabelValue(newStringValue) {

	$("#fromPermalinkOutput").val(newStringValue);

}

function processForm(textToFormat) {

	console.debug(" -> :: formatTextFromFirstTextBox()");	

	//

	leftSideTextBox=$("#fromPermalinkInput").val();

	console.debug("fromPermalinkInput: " + leftSideTextBox);

	//

	$.ajax({

		type: "POST",

		url: apiURLBase + "/convert-permalink-to-sentence",

        data: leftSideTextBox,

		contentType: "text/plain",

		crossDomain: true,

		dataType: "text",

		success: function (response, status, jqXHR) {

            console.log("response / ", response);

            setLabelValue(response);

		},

		error: function (exception, status) {

			console.log("error / ", exception);

			console.log(status);

		}

	});

}
