//require(["SHARED/jquery", "SHARED/juzu-ajax"], function ($) {

        $(document).ready(function () {

            // ** Image Picker
            $("#selectImage").imagepicker({
                hide_select: true
            });

            $('#selectImage').on('change', function () {
                $('#mood-swing').text(this.value);
            });

            var $container = $('.image_picker_selector');
            $container.imagesLoaded(function () {
                $container.masonry({
                    columnWidth: 30,
                    itemSelector: '.thumbnail'
                });
            });

            // ** Get Data
            $(".orange").live('click', function(event){
             $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"orange"});
             });
             $(".green").live('click', function(event){
             $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"green"});
             });
             $(".blue").live('click', function(event){
             $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"blue"});
             });
             $(".pink").live('click', function(event){
             $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"pink"});
             });
             $(".purple").live('click', function(event){
             $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"purple"});
             });

            // ** Publish to Timeline
           /* $(".bubble").live('click', function(event){
                $('.MoodSwingPortlet').jzLoad("MoodSwingApplication.addActivity()", {"username":"root","message":$(".bubble").HTML()});
            });
*/

        });
//})($);

