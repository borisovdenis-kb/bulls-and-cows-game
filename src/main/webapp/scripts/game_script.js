
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
        console.log("/gameProcess?number=" + $("#numeric_display").val());
        $.ajax({
            url: "/gameProcess?number=" + $("#numeric_display").val(),
            type: "GET",
            statusCode: {
                202: function (response) {
                    $(".left_container").fadeOut(300);
                    $(".user_attempts").append(
                        "<h5 class='text-center alert-success btn-sm' style='width: 100%; margin-left: 15px'>" +
                            "You win!!! =)" +
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
