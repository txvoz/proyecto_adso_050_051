var urlApiRol = "http://localhost:8082/rol";

function getRoles(fn) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", urlApiRol);
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
