//index js
var main = {
    init : function () {
        var _this = this;

        $('#btn-save').click( function(){
            if(confirm("등록 하시겠습니까?") == true){
                _this.save();
            }else{
                return null;
            }});

        $('#btn-update').click( function() {
            if(confirm("수정 하시겠습니까?") == true){
                _this.update();
            }else{
                return null;
            }});

        $('#btn-delete').click( function() {
            if(confirm("삭제 하시겠습니까?") == true){
                _this.delete();
            }else{
                return null;
            }});
    },

    save : function () {
        var data = {
            bdSubject: $('#bdSubject').val(),
            createdId: $('#createdId').val(),
            bdContents: $('#bdContents').val()
        };

        $.ajax({
            type: 'POST',
            url: '/board/api/v1/board',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            bdSubject: $('#bdSubject').val(),
            bdContents: $('#bdContents').val()
        };

        var id = $('#bdId').val();

        $.ajax({
            type: 'PUT',
            url: '/board/api/v1/board/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = `/board/detail/${id}`;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var data = {
            delYn: $('#delYn').val(),
            useYn: $('#useYn').val(),
        };

        var id = $('#bdId').val();

        $.ajax({
            type: 'PUT',
            url: '/board/api/v2/board/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/board';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }};

main.init();

/* ver.
   DeleteMapping  */
// delete : function () {
//     var id = $('#bdId').val();
//
//     $.ajax({
//         type: 'DELETE',
//         url: '/board/api/v1/board/'+id,
//         dataType: 'json',
//         contentType:'application/json; charset=utf-8'
//     }).done(function() {
//         alert('글이 삭제되었습니다.');
//         window.location.href = '/board';
//     }).fail(function (error) {
//         alert(JSON.stringify(error));
//     });
// }};
