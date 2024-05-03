var loadFile = function (event) {
    var image = document.getElementById("output");
    image.src = URL.createObjectURL(event.target.files[0]);
};
var loadFile = function (event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
};
$(document).ready(function(){
    $("#inputFilter").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $(".card").each(function() {
            var title = $(this).find(".card-title").text().toLowerCase();
            if(title.includes(value)) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
});
