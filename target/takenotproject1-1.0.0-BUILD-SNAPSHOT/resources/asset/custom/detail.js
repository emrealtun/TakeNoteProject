$(document).ready(function (){

    getNote();

});

function getNote()
{
    $("#note_title").attr("disabled",true);
    $("#note_content").attr("disabled",true);
    $("#updateBtn").html("Güncelle");

        $.ajax({
        type:"POST",
        url:"./../getNote",
        contentType : 'text/plain',
        data:$("#id").val()+"",
        success:function (data) {
            $("#note_title").val(data.title);
            $("#note_content").html(data.content);

        },error:function (data) {
            alert("çalışmadı");
        }
    });
}

var updatem =false;
 function update()
 {
 if (!updatem)
     {   $("#note_title").attr("disabled",false);
         $("#note_content").attr("disabled",false);

         $("#updateBtn").html("Kaydet");
         updatem=true;
 }
     else
     {
         updateNote();
         updatem=false;
     }
 }
function updateNote() {
    var  param=
        {   id: $("#id").val(),
            title: $("#note_title").val(),
            content:$("#note_content").val()
        }

    var ser_data= JSON.stringify(param);

    $.ajax({
        type:"POST",
        contentType:'application/json; charset=UTF-8;',
        url:"./../updateNote",
        data: ser_data,
        success:function (data) {
            getNote();

        },error:function (data) {
            alert("addnote çalışmadı");
        }
    });
}


function deleteNote()
{

    var  param=
        {   id: $("#id").val()
        }

        var  ser_data= JSON.stringify(param);
    $.ajax({
        type:"POST",
        url:"./../deleteNote",
        contentType : 'application/json; chatset=UTF-8',
        data:ser_data,
        success:function (data) {
            alert("Notunuz silindi..");
            window.history.back();

        },error:function (data) {
            alert("çalışmadı");
        }
    });
}
