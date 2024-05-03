let wsProtocol = window.location.protocol === "https:" ? "wss://" : "ws://";

const wsUri = wsProtocol + document.location.host + document.location.pathname + "endpoint";
const websocket = new WebSocket(wsUri);

websocket.onopen = function(event) {
    console.log("opened websocket: " + wsUri);
}

websocket.onclose = function(event) {

}

websocket.onmessage = function(event) {
    // Incoming Message - Called when a message is received
    // console.log(event.data);
    updateTextArea(event.data, "in");
}

websocket.onerror = function(event) {
    const errorText = document.getElementById("errorText")
    errorText.innerHTML = "Error: " + event.data;
}

function displayError(msg) {
    var errdiv = document.getElementById("errorText");
    errdiv.innerHTML = msg;
}

function sendText(json) {
    if(websocket.readyState == websocket.OPEN){
        websocket.send(json);
    }
}

const messageForm = document.getElementById("messageForm");
messageForm.addEventListener("submit", function(event) {
    event.preventDefault();
    displayError("");
    // Get the user name
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
    var json = JSON.stringify(
        {
            "name": userName,
            "message": message
        }
    );
    // Update the textarea with the outgoing message
    updateTextArea(json, "out");
    // Outgoing message - Send the message to the Java endpoint
    sendText(json);
    // Set the message text field to blank so it is ready for the next message
    // prepMessageBox();
});

function updateTextArea(jsonStr, inOut) {
    // Convert the JSON back into a Javasript object
    const json = JSON.parse(jsonStr);
    const name = json.name;
    const message = json.message;

    // Structuring output with HTML
    let output = (inOut === "in") ? "<div class=\"in\">" : "<div class=\"out\">";
    output += "<p>" + message + "</p>";
    output += "<span>" + name + "</span>";
    output += "</div>";

    // Display the HTML
    const messageBox = document.getElementById("messages");
    messageBox.innerHTML += output;

    // Auto scroll to the bottom
    // to:do prevent scrollbar from auto scrolling down if the user has manually scrolled up.
    messageBox,screenTop = messageBox.scrollHeight;
}