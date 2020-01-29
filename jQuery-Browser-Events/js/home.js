$(document).ready(function () {
	//Only the content in the Main section should display when the page is loaded.
    $('#akronInfoDiv').hide();
	$('#minneapolisInfoDiv').hide();
	$('#louisvilleInfoDiv').hide();

	//When the Akron button is clicked, only the content in the 
	//Akron section should display; the weather information for Akron should be hidden initially.
	$("#akronButton").on("click", function () {
	$("#mainInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
    $("#akronInfoDiv").show("");
    $("#akronWeather").hide("");
    })

    //When the Show/Hide Weather button is clicked, the page should display the associated weather information 
    //if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
    
	$("#akronWeatherButton").on("click", function () {
    $("#akronWeather").show("");
    })

	//The background color of any table row should change to “WhiteSmoke” when the mouse pointer is hovering over the row.
    $(".table").hover(
    // in callback
    function () {
        $(this).css("background-color", "WhiteSmoke");
    },
    // out callback
    function () {
        $(this).css("background-color", "");
    }
);


    //When the Minneapolis button is clicked, only the content in the Minneapolis section should display; 
    //the weather information for Minneapolis should be hidden initially.
    $("#minneapolisButton").on("click", function () {
	$("#mainInfoDiv").hide();
	$("#akronInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
    $("#minneapolisInfoDiv").show("");
    $("#minneapolisWeather").hide("");
    })

    //When the Show/Hide Weather button is clicked, the page should display the associated weather information 
    //if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
    
	$("#minneapolisWeatherButton").on("click", function () {
    $("#minneapolisWeather").show("");
    })


    //When the Louisville button is clicked, only the content in the Louisville section should display; the 
    //weather information for Louisville should be hidden initially.
    $("#louisvilleButton").on("click", function () {
	$("#mainInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#akronInfoDiv").hide();
    $("#louisvilleInfoDiv").show("");
    $("#louisvilleWeather").hide("");
	})

	  //When the Show/Hide Weather button is clicked, the page should display the associated weather information 
    //if it was hidden or hide the associated weather information if it was showing. It should default to hidden.
    
	$("#louisvilleWeatherButton").on("click", function () {
    $("#louisvilleWeather").show("");
    })

	//When the Louisville button is clicked, only the content in the Louisville section should display; the 
    //weather information for Louisville should be hidden initially.
    $("#mainButton").on("click", function () {
	$("#louisvilleInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#akronInfoDiv").hide();
    $("#mainInfoDiv").show("");
	})
    
});