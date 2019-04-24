$(document).ready(function (){

    getNotes();

});

function getNotes()
{

    $.ajax({
        type:"POST",
        url:"getNotes",
        success:function (data) {

            var  list="";
            $(data).each(function (i,val)
            {
                list = list
                    +'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 ">'
                    +'<h2 class="fh5co-article-title"><a href="detay/'+val.id+'">'+val.title+'</a></h2>'
                    +'<h3><a href="detay/'+val.id+'"></a> '+val.content+'</h3>'
                    +'<span class="fh5co-meta fh5co-date">'+ new Date(val.create_date).toLocaleDateString() +'</span>'
                    +'</article>';
            });
            $("#list").html(list)
        },error:function (data) {
            alert("index çalımadı");
        }
    });
}
