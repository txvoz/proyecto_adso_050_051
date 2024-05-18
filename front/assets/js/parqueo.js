var urlApiZone = "http://localhost:8082/zone";

var currentTypeZone = null;
var currentZoneId = null;
var currentClientId = null;
var currentVehicleId = null;

window.addEventListener("load", onloadwindow)

function resetFormModal() {
    currentClientId = null;
    $("#buscarUsuario").show("slow");
    $("#dataUser").hide("fast");
    $("#reserva-step-2").hide("fast");
    $("#buscarVehiculo").show("slow");
    $("#dataVehiculo").hide("fast");
    $("#email").val("");
    $("#placa").val("")
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
            $("#reserva-step-2").show("fast");
        },function(status) {
            if(status >= 500) {
                alert("Error del servidor");
                return;
            }
            alert("No fue posible procesar la operacion code ["+status+"]");
        });

        return false;
    });

    $("#frmVehiculoValidate").submit(function(e){
        vehicleCreate({
            "brand": $("#marca").val(),
            "color": $("#colorVehiculo").val(),
            "description": $("#descripcion").val(),
            "plate": $("#placa").val(),
            "type": 1
        },function(data) {
            currentVehicleId = data.id;
            $("#marca").attr("readonly", true);
            $("#colorVehiculo").attr("readonly", true);
            $("#descripcion").attr("readonly", true);
            $("#guardarNuevoVehiculo").hide();
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

        if( $("#email").val() === "" ||  $("#email").val() === null) {
            alert("Se debe diligenciar el email");
            return;
        }


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
                    $("#reserva-step-2").show("fast");

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
                    $("#reserva-step-2").hide("fast");
                }
                
            }
        );

    });

    $("#buscarVehiculo").click(function(e) {

        if( $("#placa").val() === "" ||  $("#placa").val() === null) {
            alert("Se debe diligenciar la placa");
            return;
        }

    
        vehicleFindByPlate(
            $("#placa").val(), 
            function(data) {

                if(data.type !== currentTypeZone) {
                    alert("El vehiculo consultado es del tipo:" + data.type+" y la zona que desea reservar es del tipo "+currentTypeZone);
                    return;
                } 

                $("#buscarVehiculo").hide("slow");
                $("#dataVehiculo").show("fast");
                currentVehicleId = data.id;
                $("#marca").val(data.brand);
                $("#marca").attr("readonly", true);

                $("#colorVehiculo").val(data.color);
                $("#colorVehiculo").attr("readonly", true);

                $("#descripcion").val(data.description);
                $("#descripcion").attr("readonly", true);

                $("#guardarNuevoVehiculo").hide();

            }, 
            function(error) {
                console.log(error);
                if(error !== 404) {
                    alert("Se produjo un error en el servidor consultando por placa!");
                    return;
                }

                $("#buscarVehiculo").hide("slow");
                $("#dataVehiculo").show("fast");

                currentVehicleId = null;
                $("#marca").val("");
                $("#marca").attr("readonly", false);

                $("#colorVehiculo").val("");
                $("#colorVehiculo").attr("readonly", false);

                $("#descripcion").val("");
                $("#descripcion").attr("readonly", false);

                $("#guardarNuevoVehiculo").show();

            });

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
            ` + returnZones(typeZone.zones, typeZone.title) + ` 
            </div>
        </aside>`;
       
    }

    document.getElementById('content-main').innerHTML = html;

}

function openModal(idZona, typeZone) {
    currentTypeZone = typeZone;
    currentZoneId = idZona;
    $('#modalRegistro').modal('show');
}

function returnZones(data, title) {
    var html = "";
    for(var i = 0; i < data.length; i++) { 
        var zone = data[i];
        var status = zone.status === 'INACTIVO' ? 'disabled' : '';
        var fn = zone.status === 'INACTIVO' ? '' : "onclick='openModal("+zone.id+", \""+title+"\")'";
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
