
$(document).ready(function () {
    $("#numeric_display").mask("9999");

    $(".numeric_button").click(function () {
        if ($("#numeric_display").val().length < 4) {
            var inputValue = $("#numeric_display").val();
            $("#numeric_display").val(inputValue + $(this).children("span").text());
        }
    });

    $(".cancel_button").click(function () {
        var inputValue = $("#numeric_display").val();
        $("#numeric_display").val(inputValue.slice(0, inputValue.length-1));
    });
});

