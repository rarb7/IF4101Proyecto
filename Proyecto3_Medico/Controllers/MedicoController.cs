using Microsoft.AspNetCore.Http;
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
    public class MedicoController : Controller
    {

        public IConfiguration Configuration { get; }
        public MedicoController(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IActionResult Index_Med()
        {

            return View();
        }

        public IActionResult allergy()
        {
            ViewBag.pacientes = listaPacientes();
            ViewBag.alergias = listaAlergia();
            return View();
        }

        public IActionResult vaccine()
        {
            ViewBag.pacientes = listaPacientes();
            ViewBag.vacunas = listaVacunas();
            return View();
        }

        public IActionResult app()
        {
            ViewBag.pacientes = listaPacientes();
            ViewBag.especialidades = listaEspecialidad();
            ViewBag.centro = listaCentro();
            return View();
        }

        // [HttpPost]
        public IActionResult logIn()
        {
            return View();
        }

        public IActionResult logOut(MedicoModel medico)
        {
            
                HttpContext.Session.SetInt32("user", 0);
                return RedirectToAction("logIn", "Medico");
            
            

        }

        [HttpPost]
        public IActionResult logIn(MedicoModel medico)
        {
            int resultado = resultadoVerificar(medico);
            if(resultado == 1)
            {
                HttpContext.Session.SetInt32("user",1);
                return RedirectToAction("Index_Med", "Medico");
            }
            else
            {
                return View();
            }
           
        }

        [HttpPost]
        public IActionResult RegistrarVacunaPaciente(patientVaccineModel patientVaccine)
        {
            Console.WriteLine("fecha sgt de paciente:" + patientVaccine.paciente);
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec [HOSPITAL].[sp_INSERT_PATIENT_VACCINE] @p_PATIENT_ID={patientVaccine.paciente},@p_VACCINE_ID={patientVaccine.vacuna},@p_V_APP_DATE='{patientVaccine.aplicacion}',@p_NEXT_APP_DATE='{patientVaccine.siguienteapp}',@p_REASONS='{patientVaccine.description}'";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    command.ExecuteReader();
                    connection.Close();
                }

            } // if

            //return View();
            return new JsonResult("Producto Registrado");
        }


        [HttpPost]
        public IActionResult RegistrarAlergiaPaciente(patientAllergyModel patientAllergy)
        {
            Console.WriteLine("fecha sgt de paciente:" + patientAllergy.patient_id);
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_INSERT_PATIENT_ALLERGY @p_PATIENT_ID={patientAllergy.patient_id},@p_ALLERGY_ID={patientAllergy.allergy_id},@p_DIAGNOSTIC_DATE='{patientAllergy.diagnostic_date}',@p_MEDICATION='{patientAllergy.medicine}',@p_DIAGNOSTIC='{patientAllergy.description}'";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    command.ExecuteReader();
                    connection.Close();
                }

            } // if

            //return View();
            return new JsonResult("Producto Registrado");
        }


        [HttpPost]
        public IActionResult RegistrarCitaPaciente(drAppointmentModel appointment)
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_INSERT_APPOINMENT @p_PATIENT_ID={appointment.patient_id},@p_CENTER_ID={appointment.center_id},@p_APP_DAY='{appointment.appointment_day}',@p_APP_HOUR='{appointment.appointment_hour}',@p_SPECIALTY_ID={appointment.specialty_id}";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    command.ExecuteReader();
                    connection.Close();
                }

            } // if

            //return View();
            return new JsonResult("Producto Registrado");
        }






        //METODOS
        public List<vaccineModel> listaVacunas()
        {
            List<vaccineModel> vacunas = new List<vaccineModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec HOSPITAL.sp_SELECT_VACCINES";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader productosReader = command.ExecuteReader();
                        while (productosReader.Read())
                        {
                            vaccineModel productoTemp = new vaccineModel();
                            productoTemp.vaccine_id = Int32.Parse(productosReader["VACCINE_ID"].ToString());
                            productoTemp.vaccine_name = productosReader["VACCINE_NAME"].ToString();
                            vacunas.Add(productoTemp);
                        } // while
                        connection.Close();
                    }
                }
            } // if
            return vacunas;
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

        //obtener especialidades
        public List<espModel> listaEspecialidad()
        {
            List<espModel> especialidades = new List<espModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec HOSPITAL.sp_SELECT_ESPECIALIDAD";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader productosReader = command.ExecuteReader();
                        while (productosReader.Read())
                        {
                            espModel Temp = new espModel();
                            Temp.esp_id = Int32.Parse(productosReader["ESPECIALIDAD_ID"].ToString());
                            Temp.esp_nombre = productosReader["ESPECIALIDAD_NOMBRE"].ToString();

                            especialidades.Add(Temp);
                        } // while
                        connection.Close();
                    }
                }
            } // if
            return especialidades;
        }

        //lista centro de salud
        public List<centerModel> listaCentro()
        {
            List<centerModel> centro = new List<centerModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec HOSPITAL.sp_SELECT_HEALTH_CENTER";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader productosReader = command.ExecuteReader();
                        while (productosReader.Read())
                        {
                            centerModel Temp = new centerModel();
                            Temp.centro_id = Int32.Parse(productosReader["CENTER_ID"].ToString());
                            Temp.centro_nombre = productosReader["CENTER_NAME"].ToString();

                            centro.Add(Temp);
                        } // while
                        connection.Close();
                    }
                }
            } // if
            return centro;
        }

        //obtener alergias
        public List<AllergyModel> listaAlergia()
        {
            List<AllergyModel> alergias = new List<AllergyModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    string sqlQuery = $"exec HOSPITAL.sp_SELECT_ALLERGY";
                    using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        SqlDataReader productosReader = command.ExecuteReader();
                        while (productosReader.Read())
                        {
                            AllergyModel Temp = new AllergyModel();
                            Temp.allergy_id = Int32.Parse(productosReader["ALLERGY_ID"].ToString());
                            Temp.allergy_name = productosReader["ALLERGY_NAME"].ToString();

                            alergias.Add(Temp);
                        } // while
                        connection.Close();
                    }
                }
            } // if
            return alergias;
        }//FIN METODO

        //METODO DE INICIO DE SESION
        public int resultadoVerificar(MedicoModel medico)
        {
            int nom_divisa = 0;
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_LOGIN @p_DR_CODE={medico.dr_code},@p_DR_ID='{medico.dr_id}',@p_DR_PASSWORD='{medico.dr_password}'";


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
            return nom_divisa;
        }//fin metodo


    }//fin clase
}//fin namespace

