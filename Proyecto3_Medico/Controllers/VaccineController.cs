using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Proyecto3_Medico.data;
using Proyecto3_Medico.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.Controllers
{

    public class VaccineController : Controller
    {
        public IConfiguration Configuration { get; }
        public VaccineController(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public IActionResult Index_Vaccine()
        {
            ViewBag.pacientes = listaPacientes();
            return View();
        }

        public IActionResult Find_Vaccine(patientVaccineModel vacc)
        {

            List<patientVaccineModel> pacientes = new List<patientVaccineModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_SELECT_PATIENT_VACCINE @p_PATIENT_ID={vacc.paciente}";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    SqlDataReader productosReader = command.ExecuteReader();
                    while (productosReader.Read())
                    {
                        patientVaccineModel Temp = new patientVaccineModel();
                        Temp.vacuna_nombre = productosReader["VACCINE_NAME"].ToString();
                        Temp.aplicacion = productosReader["V_APP_DATE"].ToString();
                        Temp.siguienteapp = productosReader["NEXT_APP_DATE"].ToString();
                        Temp.description = productosReader["REASONS"].ToString();

                        pacientes.Add(Temp);
                    } // while
                    connection.Close();
                }

            } // if
            //ViewBag.citas = pacientes;
            return new JsonResult(pacientes);
        }

        public IActionResult Update_Vaccine(patientVaccineModel vacc) {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_UPDATE_PATIENT_VACCINE @p_PATIENT_ID={vacc.paciente},@p_VACCINE_ID='{vacc.vacuna_nombre}',@p_V_APP_DATE='{vacc.aplicacion}',@p_NEXT_APP_DATE='{vacc.siguienteapp}',@p_REASONS='{vacc.description}'";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    command.ExecuteReader();
                    connection.Close();
                }

            } // if


            return new JsonResult("");
        }
        public IActionResult Delete_Vaccine(patientVaccineModel vacc)
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_DELETE_PATIENT_VACCINE @p_PATIENT_ID={vacc.paciente},@p_VACCINE_ID='{vacc.vacuna_nombre}'";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    command.ExecuteReader();
                    connection.Close();
                }

            } // if


            return new JsonResult("");
        }
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
