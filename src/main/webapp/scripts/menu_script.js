
$(document).ready(function () {
    var splitedUrl = location.href.split("/");
    var page = splitedUrl[splitedUrl.length - 1];

    $(".menu_item").each(function () {
        if ($(this).attr("id") === page) {
            $(this).find(".bottom_line").css({'opacity': 1});
        }
    });
});