var urlApiZone = "http://localhost:8082/zone";

window.addEventListener("load", onloadwindow)

function onloadwindow(){
    getZones(printTypeZones);
}

function printTypeZones(data) {
    var html = "";
    for(var i = 0; i < data.length; i++) {
        var typeZone = data[i];
        html += `<aside class="contenedor-zonas">
            <header>
                <h2>` + typeZone.title + `</h2>
            </header>
            <div>
            ` + returnZones(typeZone.zones) + ` 
            </div>
        </aside>`;
       
    }

    document.getElementById('content-main').innerHTML = html;

}

function returnZones(data) {
    var html = "";
    for(var i = 0; i < data.length; i++) { 
        var zone = data[i];
        var status = zone.status === 'INACTIVO' ? 'disabled' : '';
        html += `<div class="zona ` + status + ` "> <div class='title'>` + zone.title + `</div></div>`;
    }

    return html;
} 

function getZones(fn) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", urlApiZone);
    xhr.send();
    xhr.responseType = "json";
    xhr.onload = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const data = xhr.response;
            console.log(data);
            try {
                fn(data);
            } catch (error) {
                console.log("Error invocando callback ");
            }
        } else {
            console.log(`Error Not load Roles: ${xhr.status}`);
        }
    };
}
