
$(document).ready(function () {

	clearFormBoxesSTP();

    setInterval(processFormSTP, 1000);

});

function clearFormBoxesSTP(){

	setInputValueSTP("this is a string of text");

	setLabelValueSTP("");

}

function setInputValueSTP(newStringValue) {   

	$("#sentenceToPermalinkBefore").val(newStringValue);

}

function setLabelValueSTP(newStringValue) {

	$("#sentenceToPermalinkAfter").val(newStringValue);

}

function processFormSTP() {

	console.debug(" -> :: processFormSTP()");	

	//

	leftSideTextBox=$("#sentenceToPermalinkBefore").val();

	console.debug("sentenceToPermalinkBefore /" + leftSideTextBox);

	//

	$.ajax({

		type: "POST",

		url: apiURLBase + "/convert-sentence-to-permalink",

        data: leftSideTextBox,

		contentType: "text/plain",

		crossDomain: true,

		dataType: "text",

		success: function (response, status, jqXHR) {

            console.log("response / ", response);

            setLabelValueSTP(response);
		
		},

		error: function (exception, status) {

			console.log("error / ", exception);

			console.log(status);

		}

	});

}
