
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

    var splitedUrl = location.href.split("/");
    var page = splitedUrl[splitedUrl.length - 1];

    $(".menu_item").each(function () {
        console.log($(this).attr("id") + " " + page);
        if ($(this).attr("id") == page) {
            $(this).css({'border-bottom': 'solid 2px rgba(49, 117, 204, 0.8)'});
        }
    })
});

