</div><!-- /#wrapper -->
<script src="../assests/js/jquery-2.2.0.min.js" type="text/javascript"></script>
<script src="../assests/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assests/js/bootstrap-show-password.min.js" type="text/javascript"></script>

<script>
$(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $(".side-nav .collapse").on("hide.bs.collapse", function() {                   
        $(this).prev().find(".fa").eq(1).removeClass("fa-angle-right").addClass("fa-angle-down");
    });
    $('.side-nav .collapse').on("show.bs.collapse", function() {                        
        $(this).prev().find(".fa").eq(1).removeClass("fa-angle-down").addClass("fa-angle-right");        
    });
})    
    
</script>