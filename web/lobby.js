$(function() {
       $('#no1').on("click", function(evt) {
       $.getJSON("api/chatroom/"+$('#no1').val());
          // alert("api/chatroom/"+$('#no1').val());
       //console.log(evt.target.id);
           //alert(evt.target.id);
           var rv = evt.target.id;
           url ="chat.html?no="+rv;
           
           location.href = url;
   }); 
   $('#no2').on("click", function(evt) {
       $.getJSON("api/chatroom/"+$('#no2').val());
           //alert("api/chatroom/"+$('#no2').val());
       //console.log(evt.target.id);
           //alert(evt.target.id);
           var rv = evt.target.id;
           url ="chat.html?no="+rv;
           
           location.href = url;
   });
   
});
