var blogsItemTemplate = Handlebars.compile($("#blogs-item-template").html());
var data = [3];
var count = 0;


$(function() {
    $("#Submit").on("click", function() {
        $.getJSON("setcard?id1="+data[0]+"&id2="+data[1]+"&id3="+data[2])
            //.done(function(result){
               // console.log(result)
                //if(result.result == "true"){
               // $('li').remove('#'+data[0]);
               // $('li').remove('#'+data[1]);
               // $('li').remove('#'+data[2]);//}
           //}).fail(function() {
               // console.log("Not found");
           // })
        });
    })