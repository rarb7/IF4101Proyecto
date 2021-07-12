using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Proyecto3_Medico.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.data
{
    public class DB_Management : Controller
    {
        public IConfiguration Configuration { get; }
        public DB_Management(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public IActionResult Index()
        {
            return View();
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
