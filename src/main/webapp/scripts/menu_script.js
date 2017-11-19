
$(document).ready(function () {
    var splitedUrl = location.href.split("/");
    var page = splitedUrl[splitedUrl.length - 1];

    $(".menu_item").each(function () {
        console.log($(this).attr("id") + " " + page);
        if ($(this).attr("id") == page) {
            $(this).css({'border-bottom': 'solid 2px rgba(49, 117, 204, 0.8)'});
        }
    });
});