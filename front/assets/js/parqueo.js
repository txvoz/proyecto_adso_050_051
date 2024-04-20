var urlApiZone = "http://localhost:8082/zone";

window.addEventListener("load", onloadwindow)

function onloadwindow(){
    $("#buscarUsuario").click(function(e){

        $.ajax(
            {
                url: "http://localhost:8082/user/email/" + $("#email").val(), 
                success: function(result){
                    $("#buscarUsuario").hide("slow");
                    $("#dataUser").show("fast");

                    var date =  result.bornDate.replace("T","-");
                    var arrayDate = date.split("-");

                    $("#fullname").val(result.fullName);
                    $("#phone").val(result.phone);
                    $("#color").val(result.color);
                    $("#borndate").val(arrayDate[0]+"-"+arrayDate[1]+"-"+arrayDate[2]);

                    console.log(result);
                }
            }
        );

    });
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

function openModal(idZona) {
    $('#modalRegistro').modal('show');
}

function returnZones(data) {
    var html = "";
    for(var i = 0; i < data.length; i++) { 
        var zone = data[i];
        var status = zone.status === 'INACTIVO' ? 'disabled' : '';
        var fn = zone.status === 'INACTIVO' ? '' : "onclick='openModal("+zone.id+")'";
        html += `<div class="zona ` + status + ` " ` + fn + ` > <div class='title'>` + zone.title + `</div></div>`;
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
