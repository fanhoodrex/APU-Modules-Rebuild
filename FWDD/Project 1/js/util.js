function playVideoInModel(url){
    $(".modal").modal("show");
    $("#btn-submit").remove();
    $(".modal-body").html("<iframe width=\"100%\" height=\"500px\" src=\"" + url + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
    }
    
function deleteCard(ths){
Swal.fire({
    title: 'Do you want to remove it?',
    icon: 'info',
    showCancelButton: true,
    confirmButtonText: 'Yes',
}).then((result) => {
    if (result.isConfirmed) {
    $(ths).parents(".col-4").fadeOut(400,function(){
        $(ths).parents(".col-4").remove();
    });
    } 
})
}