require( ["SHARED/jquery", "SHARED/juzu-ajax"], function ( $) {

    $(function() {
            $(document).ready(function () {

                $("#moodswing_1").live('click', function(event){

                    $(this).jzLoad("MoodSwingApplication.storeStatus()", {"status":"moodswing_1"});
                });
                $("#moodswing_2").live('click', function(event){
                    $('.simpleTodoPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"moodswing_2"});
                });
                $("#moodswing_3").live('click', function(event){
                    $('.simpleTodoPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"moodswing_3"});
                });
                $("#moodswing_4").live('click', function(event){
                    $('.simpleTodoPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"moodswing_4"});
                });
                $("#moodswing_5").live('click', function(event){
                    $('.simpleTodoPortlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"moodswing_5"});
                });

            });
    })($);

});

