$(document).ready(function () {
    edit();
    render();
});


var render = function () {
    $('#render').each(function () {
        $(this).click(
            function () {
                $('.contents').each(
                    function () {
                        var data = $(this).children().attr("data");
                        $(this).children().replaceWith("<h1 class='render' data='" + data + "'>" + data + "</h1>");
                    });
            }
        );
    });
};


var edit = function () {
    $('#edit').each(function () {
        $(this).click(
            function () {
                $('.contents').each(
                    function () {
                        var data = $(this).children().attr("data");
                        $(this).children().replaceWith("<input class='edit' data='" + data + "' value='" + data + "'/>");
                    });
            }
        );
    });
};