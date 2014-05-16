require( ["SHARED/jquery", "SHARED/juzu-ajax"], function ( $) {

    $(function() {
            $(document).ready(function () {

                $("#mood-overhappy").live('click', function(event){
                    $('.mood-swing-portlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"overhappy"});
                });
                $("#mood-happy").live('click', function(event){
                    $('.mood-swing-portlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"happy"});
                });
                $("#mood-sleepy").live('click', function(event){
                    $('.mood-swing-portlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"sleepy"});
                });
                $("#mood-unhappy").live('click', function(event){
                    $('.mood-swing-portlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"unhappy"});
                });
                $("#mood-angry").live('click', function(event){
                    $('.mood-swing-portlet').jzLoad("MoodSwingApplication.storeStatus()", {"status":"angry"});
                });

            });
    })($);

});

