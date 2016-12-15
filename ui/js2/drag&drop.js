

function drag(event) {
    event.dataTransfer.setData("Text", event.target.id);
}

function drop(event) {
    event.preventDefault();
    var data = event.dataTransfer.getData("Text");
    event.target.appendChild(document.getElementById(data));
}

function allowDrop(event) {
    event.preventDefault();
}