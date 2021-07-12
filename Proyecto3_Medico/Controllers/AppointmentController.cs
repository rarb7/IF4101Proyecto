using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Proyecto3_Medico.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.Controllers
{
    public class AppointmentController : Controller
    {
        public IConfiguration Configuration { get; }
        public AppointmentController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        //[Route("gestion/citas")]
        public IActionResult Index_Appointment()
        {
            ViewBag.pacientes = listaPacientes();
            return View();
        }

        [HttpPost]
       //[Route("gestion/citas")]
        public IActionResult Index_Appointment(drAppointmentModel appointment)
        {
            //ViewBag.pacientes = listaPacientes();
            ////return View();
            List<drAppointmentModel> pacientes = new List<drAppointmentModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec [HOSPITAL].[sp_PATIENT_APPOINTMENT] @p_PATIENTE_ID={appointment.patient_id}";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    SqlDataReader productosReader = command.ExecuteReader();
                    while (productosReader.Read())
                    {
                        drAppointmentModel Temp = new drAppointmentModel();
                        Temp.appointment_day = productosReader["DR_APP_DAY"].ToString();
                        Temp.appointment_hour = productosReader["DR_APP_HOUR"].ToString();
                        Temp.center_name = productosReader["CENTER_NAME"].ToString();
                        Temp.details = productosReader["DETAILS"].ToString();
                        Temp.specialty_name = productosReader["ESPECIALIDAD_NOMBRE"].ToString();
                        pacientes.Add(Temp);
                    } // while
                    connection.Close();
                }

            } // if
            ViewBag.citas = pacientes;
            return new JsonResult(pacientes);
        }

        [HttpPost]
        public IActionResult Update_appointment(drAppointmentModel appointment)
        {
            Console.WriteLine("adentro del update appointment");
            Console.WriteLine(appointment.appointment_day);
            Console.WriteLine(appointment.specialty_name);
            Console.WriteLine(appointment.patient_id);
            Console.WriteLine("adentro del update appointment");
            //int resultado = resultadoUpdate(appointment);
            int nom_divisa = 0;
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

            string sqlQuery = $"exec HOSPITAL.sp_UPDATE_PATIENT_APP @p_PATIENTE_ID={appointment.patient_id},@p_APP_DAY='{appointment.appointment_day}',@p_DETAILS='{appointment.details}',@p_SPECIALTY_ID='{appointment.specialty_name}'";


            using (SqlCommand command = new SqlCommand(sqlQuery, connection))
            {
                command.CommandType = CommandType.Text;
                connection.Open();
                SqlDataReader productosReader = command.ExecuteReader();
                while (productosReader.Read())
                {

                    nom_divisa = Int32.Parse(productosReader["RESULTADO"].ToString());

                } // while
                connection.Close();
            }

        } // if
            return new JsonResult(nom_divisa);
        }

        [HttpPost]
        public IActionResult Delete_appointment(drAppointmentModel appointment)
        {

            int nom_divisa = 0;
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec [HOSPITAL].[sp_DELETE_DR_APPOINMENT] @p_PATIENT_ID={appointment.patient_id},@p_APP_DAY='{appointment.appointment_day}',@p_SPECIALTY_ID='{appointment.specialty_name}'";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    SqlDataReader productosReader = command.ExecuteReader();
                    while (productosReader.Read())
                    {

                        nom_divisa = Int32.Parse(productosReader["RESULTADO"].ToString());

                    } // while
                    connection.Close();
                }

            } // if
            return new JsonResult(nom_divisa);
        }

        //metodo obtener pacientes
        public List<patientModel> listaPacientes()
        {
            List<patientModel> pacientes = new List<patientModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec HOSPITAL.sp_SELECT_PATIENTS";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader productosReader = command.ExecuteReader();
                        while (productosReader.Read())
                        {
                            patientModel Temp = new patientModel();
                            Temp.patient_id = Int32.Parse(productosReader["PATIENT_ID"].ToString());
                            Temp.patient_name = productosReader["PATIENT_NAME"].ToString();
                            Temp.patient_lastname = productosReader["PATIENT_LASTNAME"].ToString();
                            pacientes.Add(Temp);
                        } // while
                        connection.Close();
                    }
                }
            } // if
            return pacientes;
        }

    }
}
