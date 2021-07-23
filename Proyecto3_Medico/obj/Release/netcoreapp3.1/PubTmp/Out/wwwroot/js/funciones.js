function registrarpacienteVacuna(paciente_id, vacuna_id, fechaapp, nextapp, description) {


    var parametros = {
        "paciente": paciente_id,
        "vacuna": vacuna_id,
        "aplicacion": fechaapp,
        "siguienteapp": nextapp,
        "description": description
    };
    $.ajax(
        {
            data: parametros,
            url: "/Medico/RegistrarVacunaPaciente",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                $("#resultado").html(response);
                alert("REGISTRADO CON EXITO");
            }
        }
    );
}

function registrarpacientealergia(paciente_id, alergia_id, fecha, medicina, description) {


    var parametros = {
        "patient_id": paciente_id,
        "allergy_id": alergia_id,
        "diagnostic_date": fecha,
        "medicine": medicina,
        "description": description
    };
    $.ajax(
        {
            data: parametros,
            url: "/Medico/RegistrarAlergiaPaciente",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                $("#resultado").html(response);
                alert("REGISTRADO CON EXITO");
            }
        }
    );
}

//FUNCION PARA REGISTRAR LA CITA DEL PACIENTE

function registrarCita(paciente_id, center_id, fecha, hora, especialidad) {


    var parametros = {
        "patient_id": paciente_id,
        "center_id": center_id,
        "appointment_day": fecha,
        "appointment_hour": hora,
        "specialty_id": especialidad
    };
    $.ajax(
        {
            data: parametros,
            url: "/Medico/RegistrarCitaPaciente",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                $("#resultado").html(response);
                alert("CITA AGENDADA CON EXITO");
            }
        }
    );
}

//FUNCION PARA BUSCAR DETALLES DE UN PACIENTE

function buscarDetalle(paciente_id) {


    var parametros = {
        "patient_id": paciente_id
    };
    $.ajax(
        {
            data: parametros,
            url: "/Appointment/Index_Appointment",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                //$("#resultado").html(response);

                var trHTML = '';
                $.each(response, function (index, item) {
                    trHTML += '<tr>' +

                        '<td>' + item.appointment_day + '</td>' +
                        '<td>' + item.appointment_hour + '</td>' +
                        '<td>' + item.center_name + '</td>' +
                        '<td>' + item.details + '</td>' +
                        '<td>' + item.specialty_name + '</td>' +

                        '</tr>';
                });
                $("#tbody").empty();
                $("#detalle").append(trHTML);

            }
        }
    );
}

//metodo que me permite editar los input 
function allowInput() {
    document.getElementById('appDescription').disabled = false;

}
//FUNCION QUE ACTUALIZA LA CITA MEDICA

function updateAppointment(paciente_id, fecha, detalles, especialidad) {
 
    var parametros = {
        "patient_id": paciente_id,
        "appointment_day": fecha,
        "details": detalles,
        "specialty_name": especialidad
       
    };
    $.ajax(
        {
            data: parametros,
            url: "/Appointment/Update_appointment",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                if (response == 1) {
                    alert("actualizado con exito");
                } else {
                    alert("El paciente aun no ha sido atendido");
                }
            }
        }
    );

}
//FUNCION QUE PERMITE ELIMINAR LA CITA MEDICA

function deleteAppointment(paciente_id, fecha, especialidad) {

    var parametros = {
        "patient_id": paciente_id,
        "appointment_day": fecha,
        "specialty_name": especialidad

    };
    $.ajax(
        {
            data: parametros,
            url: "/Appointment/Delete_appointment",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                 alert("Eliminado con exito");
            }
        }
    );

}
//PERMITE EDITAR LOS INPUT
function allowInput() {
    document.getElementById('appDescription').disabled = false;

}

//----------------------------------vacuna
//funciones referentes al paciente y su vacuna
function buscarDetalleVacuna(paciente_id) {


    var parametros = {
        "paciente": paciente_id
    };
    $.ajax(
        {
            data: parametros,
            url: "/Vaccine/Find_Vaccine",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                //$("#resultado").html(response);

                var trHTML = '';
                $.each(response, function (index, item) {
                    trHTML += '<tr>' +

                        '<td>' + item.vacuna_nombre + '</td>' +
                        '<td>' + item.aplicacion + '</td>' +
                        '<td>' + item.siguienteapp + '</td>' +
                        '<td>' + item.description + '</td>' +
                        '</tr>';
                });
                $("#tbody").empty();
                $("#detalle").append(trHTML);

            }
        }
    );
}
//PERMITE EDITAR LOS INPUT de la gestion de vacunas
function allowInputVaccine() {
    
    document.getElementById("fecha").disabled = false;
    document.getElementById("fechasg").disabled = false;
    document.getElementById("appDescription").disabled = false;

}

//PERMITE ACTUALIZAR LA VACUNA CON EL PACIENTE
function updateVaccine(paciente_id,vacuna, fecha, fechasg, detalles) {

    var parametros = {
        "paciente": paciente_id,
        "vacuna_nombre": vacuna,
        "aplicacion": fecha,
        "siguienteapp": fechasg,
        "description": detalles

    };
    $.ajax(
        {
            data: parametros,
            url: "/Vaccine/Update_Vaccine",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                    alert("actualizado con exito");
            }
        }
    );



}

//PERMITE ELIMINAR LA VACUNA CON EL PACIENTE
function DeleteVaccine(paciente_id, vacuna) {

    var parametros = {
        "paciente": paciente_id,
        "vacuna_nombre": vacuna
    };
    $.ajax(
        {
            data: parametros,
            url: "/Vaccine/Delete_Vaccine",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                alert("Eliminado con exito");
            }
        }
    );



}

//----------------------------------Alergias
function buscarDetalleAlergia(paciente_id) {
    var parametros = {
        "patient_id": paciente_id
    };
    $.ajax(
        {
            data: parametros,
            url: "/Allergy/Find_Allergy",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                //$("#resultado").html(response);

                var trHTML = '';
                $.each(response, function (index, item) {
                    trHTML += '<tr>' +

                        '<td>' + item.allergy_name + '</td>' +
                        '<td>' + item.diagnostic_date + '</td>' +
                        '<td>' + item.description + '</td>' +
                        '<td>' + item.medicine + '</td>' +
                        '</tr>';
                });
                $("#tbody").empty();
                $("#detalle").append(trHTML);

            }
        }
    );
}

//allow los input
function allowInputAllergy() {

    document.getElementById("fecha").disabled = false;
    document.getElementById("appDescription").disabled = false;
    document.getElementById("medicamentos").disabled = false;

}

//update
function updateAllergy(paciente_id, alergia, fecha, medicina, detalles) {

    var parametros = {
        "patient_id": paciente_id,
        "allergy_name": alergia,
        "diagnostic_date": fecha,
        "medicine": medicina,
        "description": detalles

    };
    $.ajax(
        {
            data: parametros,
            url: "/Allergy/Update_Allergy",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                alert("actualizado con exito");
            }
        }
    );



}
//delete
function deleteAllergy(paciente_id, alergia, fecha, medicina, detalles) {

    var parametros = {
        "patient_id": paciente_id,
        "allergy_name": alergia,
    };
    $.ajax(
        {
            data: parametros,
            url: "/Allergy/Delete_Allergy",
            type: 'POST',
            beforeSend: function () {
                $("#resultado").html("procesando");
            },
            success: function (response) {
                alert("actualizado con exito");
            }
        }
    );



}