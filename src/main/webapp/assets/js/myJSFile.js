/**
 * Created by bcorpade on 4/30/2014.
 */
$(document).ready(function () {
    findAllLanguages()
});
//sorter pentru un mediu
$(function() {
    $( "#sortable" ).sortable({
        update: function(event, ui) {
            var buttonOrder = [];
            var i=0;
            $('#sortable li a').each( function(e) {
                buttonOrder[i] = $(this).attr('id');
                i++;
                console.log('"'+$(this).attr('id') + '",');

            })
            console.log(buttonOrder);
            //todo build the array and send it to server
            $(function(){
                    $.ajax({
                        url: '/saveOrder',
                        type: 'POST',
                        data: "val1="+buttonOrder,
                        cache: false,
                        processData: false,
                        dataType: "Accept=application/json",
                        success: function(data){
                            console.log(data);
                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                            alert("find language error: "+errorThrown);
                        }
                    });
                }
            );

        }}
    );
    $( "#sortable" ).disableSelection();
});

//regasire date din DB

function findAllLanguages() {
    $.ajax({
        type: 'GET',
        url: "/language/findAll",
        success: function (data) {
            createLanguagesTable(data)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('error: ' + textStatus + ': ' + errorThrown);
        }
    });
}
//toggle pentru un form
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
//autocompleter
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
//    $("#tableContent").replaceWith("<div>nu merge</div>");
    if (data) {
        var len = data.languageList.length;
        var txt = "";
        if (len > 0) {
            for (var i = 0; i < len; i++) {
                txt += "<tr><td>" + i + "</td><td>" + data.languageList[i].id + "</td><td>" + data.languageList[i].name + "</td><td>" + data.languageList[i].code3 + "</td></tr>";
            }
            if (txt != "") {
                $("#tableContent").html(txt);
            }
        } else {
            $("#tableContent").html("");
        }
    }
}

$("#contactBtn").live('click', function() {
    if($(this).hasClass("selected")) {
        deselect();
    } else {
        $(this).addClass("selected");
        $.get(this.href, function(data) {
            $(".pop").html(data).slideFadeToggle(function() {
                $("input[type=text]:first").focus();
            });
        })
    }
    return false;
});