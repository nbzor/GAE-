$(document).ready(function () {

    var TRANSLATE_API = "api/translate";
    LoadMap();
    $(".dropdown-menu li a").click(function () {
        var selText = $(this).text();
        $(this).parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
    });


    $("#input").keyup(function (event) {
        if ($("#input").val().length === 0) {
            $("#output").text("");
            return;
        }
        if (event.which === 13) {
            event.preventDefault();
        }
        var from = $("#from option:selected").text();
        var to = $("#to option:selected").text();
        var text = encodeURIComponent($("#input").val());

        $.getJSON(TRANSLATE_API + "/" + from + "/" + to + "/" + text, function (d) {
            if (d.translations.length > 0) {
                $("#output").text("");
                $("#output").text(d.translations[0].translatedText);
            }
        });
    });

    $.getJSON(TRANSLATE_API, function (data) {
        var items = [];
        $.each(data.languages, function (index, value) {
            items.push('<option>' + value.language.toUpperCase() + "</option>");
        });
        $(".languages").append(items);
    });



    function LoadMap() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (p) {
                $('#map-canvas').empty();
                var d = {lat: p.coords.latitude, lng: p.coords.longitude};
                
                var mapOptions = {
                    center: d,
                    minZoom: 6,
                    maxZoom: 14,
                    zoom: 8
                };
                var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

                var marker = new google.maps.Marker({
                    position: d,
                    map: map,
                });
                var infowindow = new google.maps.InfoWindow({
                    content: "ME!"
                });

                infowindow.open(map, marker);
                
                google.maps.event.addListener(map,"rightclick",function(event){
                   console.log(event.latLng.lat()); 
                   console.log(event.latLng.lng()); 
                });
            });
        }
    }
});