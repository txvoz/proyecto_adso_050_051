var urlApiZone = "http://localhost:8082/zone";

var currentClientId = null;

window.addEventListener("load", onloadwindow)

function resetFormModal() {
    currentClientId = null;
    $("#buscarUsuario").show("slow");
    $("#dataUser").hide("fast");
    $("#email").val("")
}

function onloadwindow(){
    $("#frmUserValidate").submit(function(e){
        userCreate({
            "fullName": $("#fullname").val(),
            "bornDate": $("#borndate").val(),
            "color": $("#color").val(),
            "email": $("#email").val(),
            "phone": $("#phone").val(), 
            "avatar": "-.jpg", 
            "rol": 3
        },function(data) {
            currentClientId = data.id;
            $("#fullname").attr("readonly", true);
            $("#phone").attr("readonly", true);
            $("#color").attr("readonly", true);
            $("#borndate").attr("readonly", true);
            $("#guardarNuevoUsuario").hide();

        },function(status) {
            if(status >= 500) {
                alert("Error del servidor");
                return;
            }
            alert("No fue posible procesar la operacion code ["+status+"]");
        });

        return false;
    });

    $("#resetModal").click(resetFormModal);

    $("#modalRegistro").on("hide.bs.modal", resetFormModal);

    $("#buscarUsuario").click(function(e){

        $("#buscarUsuario").hide("slow");
        $("#dataUser").show("fast");

        $.ajax(
            {
                url: "http://localhost:8082/user/email/" + $("#email").val(), 
                success: function(result) {
                    
                    var date =  result.bornDate.replace("T","-");
                    var arrayDate = date.split("-");

                    currentClientId = result.id;
                    $("#fullname").val(result.fullName);
                    $("#fullname").attr("readonly", true);

                    $("#phone").val(result.phone);
                    $("#phone").attr("readonly", true);

                    $("#color").val(result.color);
                    $("#color").attr("readonly", true);

                    $("#borndate").val(arrayDate[0]+"-"+arrayDate[1]+"-"+arrayDate[2]);
                    $("#borndate").attr("readonly", true);

                    $("#guardarNuevoUsuario").hide();

                    console.log(result);
                }, 
                error: function(xhr, status, error){
                    if(xhr.status !== 404) {
                        alert("Se produjo un error en el servidor!");
                        return;
                    }
                   
                    currentClientId = null;
                    $("#fullname").val("");
                    $("#fullname").attr("readonly", false);

                    $("#phone").val("");
                    $("#phone").attr("readonly", false);

                    $("#color").val("");
                    $("#color").attr("readonly", false);

                    $("#borndate").val("");
                    $("#borndate").attr("readonly", false);
                    
                    $("#guardarNuevoUsuario").show();
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
