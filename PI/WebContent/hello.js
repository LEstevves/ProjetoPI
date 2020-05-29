$(document).ready(function() {
    $.ajax({
        url: "https://api.thingspeak.com/channels/1049229/feeds.json"
    }).then(function(data) {
    	var myString = JSON.stringify(data);
       $('.entry-id').append(myString.id);
    });
});