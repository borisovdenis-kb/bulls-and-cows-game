
$(document).ready(function () {
    $("#numeric_display").mask("9999");

    $("#start_game_btn").click(function () {
        $.ajax({
            url: "/gameProcess",
            type: "POST",
            success: function(html){
                $(".main_container").html(html);
                bindEventsOnKeyBoard();
            }
        });
    })
});


function bindEventsOnKeyBoard() {
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

    $("#ask_computer_button").click(function () {
        $.ajax({
            url: "/gameProcess?number=" + $("#numeric_display").val(),
            type: "GET",
            statusCode: {
                202: function (response) {
                    $(".left_container").fadeOut(300);
                    $(".right_container").css({"border-left": "none"});
                    $(".user_attempts").append(
                        "<h5 class='text-center alert-success btn-sm' style='width: 100%; margin-left: 30px; margin-top: 5px'>" +
                            "You win!!! =)" +
                        "</h5>"
                    );
                },
                400: function (response) {
                    console.log(response.responseText);
                    $(".user_attempts").append(
                        "<h5 class='text-center alert-danger btn-sm' style='width: 100%; margin-left: 30px; margin-top: 5px'>" +
                            response.responseText +
                        "</h5>"
                    );
                }
            },
            success: function(html){
                $(".user_attempts").html(html);
            }
        });
    })
}
