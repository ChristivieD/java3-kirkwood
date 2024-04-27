let wsProtocol = window.location.protocol === "https:" ? "wss://" : "ws://";

const wsUri = wsProtocol + document.location.host + document.location.pathname + "endpoint";
const websocket = new WebSocket(wsUri);

websocket.onopen = function(event) {
    console.log("opened websocket: " + wsUri);
}

websocket.onclose = function(event) {

}

websocket.onmessage = function(event) {
    console.log(event.data);

}

websocket.onerror = function(event) {
    const errorText = document.getElementById("errorText")
    errorText.innerHTML = "Error: " + event.data;
}

function  displayError(msg){
    var errdiv = document.getElementById("errorText");
    errdiv.innerHTML = msg;
}

function sendText(json){
    if (websocket.readyState == websocket.OPEN){
        websocket.send(json);
    }
}
const messageForm = document.getElementById("messageForm");
messageForm.addEventListener("submit", function (event){
    event.preventDefault();
    displayError("");
    // Get the username
    var userName = document.getElementById("userName").value;
    if (userName === "") {
        displayError("Name is required");
        return;
    }
    // Get the test of the message.  If the message is blank, use "..."
    var message = document.getElementById("message").value;
    if (message === "") {
        message = "...";
    }
    // Build a JSON object and convert it to a string so it can be sent
    var json = JSON.stringify({
        "name": userName,
        "message": message
        }
    );
    // Update the textarea just like we would with an incoming message
    // updateTextArea(json, "out");
    // Send the message
    sendText(json);
    // Set the message text field to blank so it is ready for the next message
    // prepMessageBox();
});