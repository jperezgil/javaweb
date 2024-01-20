$("#tblRespueta").hide();
$("#tblDatos").show();
function enviarDatos() {
    $.ajax({
        url: "Validar",
        type: "GET",
        data: {
            nombre: $("#txtNombre").val(),
            nacimiento: $("#txtNacimiento").val(),
            sueldo: $("#txtSueldo").val()
        },
        success: function (result) {
            if (result.respuesta == "OK") {
                $("#lblNombre").html(result.contenido.respuestaNombre);
                var respuestaNombre = result.contenido.respuestaNombre;
                if (!respuestaNombre.toString().match("OK")) {
                    $("#lblNombre").css("color", "red");
                } else {
                    $("#lblNombre").css("color", "black");
                }

                $("#lblNacimiento").html(result.contenido.respuestaNacimiento);
                var respuestaNacimiento = result.contenido.respuestaNacimiento;
                if (!respuestaNacimiento.toString().match("OK")) {
                    $("#lblNacimiento").addClass("color-letra");
                } else {
                    $("#lblNacimiento").css("color", "black");
                }
                
                $("#lblSueldo").html(result.contenido.respuestaSueldo);
                var respuestaSueldo = result.contenido.respuestaSueldo;
                if (!respuestaSueldo.toString().match("OK")) {
                    $("#lblSueldo").attr("style","color:orange");
                } else {
                    $("#lblSueldo").css("color", "black");
                }
            } else {
                $("#lblNombre").html(result.respuesta);
                $("#lblNombre").css("color", "red");
                $("#lblNacimiento").html(result.respuesta);
                $("#lblNacimiento").addClass("color-letra");
                $("#lblSueldo").html(result.respuesta);
                $("#lblSueldo").attr("style","color:orange");
            }
            $("#tblRespueta").show();
        },
        error: function (jqXHR) {
            errorAjax(jqXHR);
            $("#divCargaListadoCasos").hide();
            $("#divDetalleCaseTracking").hide();
        }
    });
}
