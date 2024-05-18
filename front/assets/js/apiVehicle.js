var urlVehicleApi = "http://localhost:8082/vehicle";

function vehicleCreate(data, cbSuccess, cbError) {
    $.ajax(
        {
            url: urlVehicleApi, 
            type: "POST",
            data: JSON.stringify(data),  
            contentType: "application/json; charset=utf-8",
            dataType:    "json",
            success: function(result) {
                try {
                    cbSuccess(result);
                } catch (e) {
                    console.log("Error en cbSuccess", e);
                }
            }, 
            error: function(xhr, status, error){
                try {
                    console.log(error);
                    cbError(xhr.status);
                } catch (e) {
                    console.log("Error en cbError", e);
                }
            }
        }
    );
}


function vehicleFindByPlate(plate, cbSuccess, cbError) {
    var urlFindByPlate = urlVehicleApi + "/plate/" + plate;

    $.ajax(
        {
            url: urlFindByPlate, 
            type: "GET",
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                try {
                    cbSuccess(result);
                } catch (e) {
                    console.log("Error en cbSuccess", e);
                }
            }, 
            error: function(xhr, status, error){
                try {
                    console.log(error);
                    cbError(xhr.status);
                } catch (e) {
                    console.log("Error en cbError", e);
                }
            }
        }
    );


}