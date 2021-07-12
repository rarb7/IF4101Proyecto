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
    public class AllergyController : Controller
    {
        public IConfiguration Configuration { get; }
        public AllergyController(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public IActionResult Index_Allergy()
        {
            ViewBag.pacientes = listaPacientes();
            return View();
        }

        public IActionResult Find_Allergy(patientAllergyModel all)
        {

            List<patientAllergyModel> pacientes = new List<patientAllergyModel>();
            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_SELECT_PATIENT_ALLERGIES @p_PATIENT_ID={all.patient_id}";


                using (SqlCommand command = new SqlCommand(sqlQuery, connection))
                {
                    command.CommandType = CommandType.Text;
                    connection.Open();
                    SqlDataReader productosReader = command.ExecuteReader();
                    while (productosReader.Read())
                    {
                        patientAllergyModel Temp = new patientAllergyModel();
                        Temp.allergy_name = productosReader["ALLERGY_NAME"].ToString();
                        Temp.diagnostic_date = productosReader["DIAGNOSTIC_DATE"].ToString();
                        Temp.medicine = productosReader["MEDICATION"].ToString();
                        Temp.description = productosReader["REASONS"].ToString();

                        pacientes.Add(Temp);
                    } // while
                    connection.Close();
                }

            } // if
            //ViewBag.citas = pacientes;
            return new JsonResult(pacientes);
        }

        public IActionResult Update_Allergy(patientAllergyModel all)
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_UPDATE_PATIENT_ALLERGY @p_PATIENT_ID={all.patient_id},@p_ALLERGY_ID='{all.allergy_name}',@P_DIAGNOSTIC_DATE='{all.diagnostic_date}',@p_MEDICATION='{all.medicine}',@p_REASONS='{all.description}'";


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

        public IActionResult Delete_Allergy(patientAllergyModel all)
        {

            if (ModelState.IsValid)
            {
                string connectionString = Configuration["ConnectionStrings:db_proyecto_3"];
                var connection = new SqlConnection(connectionString);

                string sqlQuery = $"exec HOSPITAL.sp_DELETE_PATIENT_ALLERGY @p_PATIENT_ID={all.patient_id},@p_ALLERGY_ID='{all.allergy_name}'";


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
