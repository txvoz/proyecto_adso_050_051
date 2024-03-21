var urlTemplate = "template/"

function loadAllTemplate() {
    console.log("ingreso a cargar el template");
    loadZoneTemplate("header");
    loadZoneTemplate("footer");
}

function loadZoneTemplate(nameZone) {
    var urlZoneTemplate = urlTemplate + nameZone + ".html";
    const xhr = new XMLHttpRequest();
    xhr.open("GET", urlZoneTemplate);
    xhr.send();
    //xhr.responseType = "text/plain";
    xhr.onload = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const data = xhr.responseText;
            console.log(data);
            try {
                document.getElementById("content_" + nameZone).innerHTML = data ;
            } catch (error) {
                console.log("Error invocando callback ");
            }
        } else {
            console.log(`Error Not load Roles: ${xhr.status}`);
        }
    };
}