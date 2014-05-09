$(function() {
    $( document ).ready(function(){
        $("#selectImage").imagepicker({
            hide_select: true
        });

        $('#selectImage').on('change', function() {
            $('#mood-swing').text(this.value);
        });

        var $container = $('.image_picker_selector');
        $container.imagesLoaded(function () {
            $container.masonry({
                columnWidth: 30,
                itemSelector: '.thumbnail'
            });
        });
    });
});


