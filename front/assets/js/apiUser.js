var urlUserApi = "http://localhost:8082/user";

function userCreate(data, cbSuccess, cbError) {
    $.ajax(
        {
            url: urlUserApi, 
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
