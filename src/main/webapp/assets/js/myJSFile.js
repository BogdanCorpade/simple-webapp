/**
 * Created by bcorpade on 4/30/2014.
 */
$(document).ready(function () {
    findAllLanguages()
});

function findAllLanguages() {
    $.ajax({
        type: 'GET',
        url: "/language/findAll",
//        data: $('#myTable').serialize(),
//        dataType: "json",
//        context: document.body,
        success: function (data) {
//            alert(data.toString)
            createLanguagesTable(data)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('error: ' + textStatus + ': ' + errorThrown);
        }
    });
}

function toggleSubmitForm() {
    if ($("#addLanguageDiv").hasClass("hidden")) {
        $("#addLanguageDiv").removeClass("hidden")
    } else {
        $("#addLanguageDiv").addClass("hidden");
    }
}

function saveLanguage() {
    var form = $("#addLanguageForm");
//    alert($('[name="code3"]').val().toString().length);
    if ($('[name="name"]').val().toString()!="" && $('[name="code3"]').val().toString().length<=3 && $('[name="code3"]').val().toString().length>=0){
        $.ajax({
            url: '/language/save',
            type: 'POST',
            data: form.serialize(),
            cache: false,
            processData: false,
            dataType: "text",
            success: function(data){
                console.log("succes"+data);
                findAllLanguages();
                form[0].reset();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("some error"+errorThrown);
            }
        });
    }else{
        alert("mai incearca");
        toggleSubmitForm()
    }

    toggleSubmitForm();
}

function filterResults(){
    $.ajax({
        url: '/language/searchLanguages',
        type: 'POST',
        data: "val1="+$("#searchInput").val(),
        cache: false,
        processData: false,
        success: function(data){
            console.log(data);
            createLanguagesTable(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("find language error: "+errorThrown);
        }
    });
}

function createLanguagesTable(data){
    if (data) {
        var len = data.languageList.length;
        var txt = "";
        if (len > 0) {
            for (var i = 0; i < len; i++) {
//                        if(data.languageList[i].id && data.languageList[i].name && data.languageList[i].code3){
                txt += "<tr><td>" + i + "</td><td>" + data.languageList[i].id + "</td><td>" + data.languageList[i].name + "</td><td>" + data.languageList[i].code3 + "</td></tr>";
//                        }
            }
            if (txt != "") {
                $("#myTable").html(txt);
            }
        } else {
            $("#myTable").html("");
        }
    }
}
