
function addNote() {
    var  param=
        {
            title: $("#note_title").val(),
            content:$("#note_content").val()
        }

        var ser_data= JSON.stringify(param);

        $.ajax({
            type:"POST",
            contentType:'application/json; charset=UTF-8;',
            url:"addNote",
            data: ser_data,
            success:function (data) {

            },error:function (data) {
                alert("addnote çalışmadı");
            }
        });
}