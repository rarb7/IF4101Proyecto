using AutoMapper;
using Expediente_API.Entities;
using Expediente_API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Controllers
{
    [ApiController]
    [Route("Api/Pacientes")]
    public class PacientesController: ControllerBase
    {

        [HttpPost("Registrar")]

        public async Task<ActionResult> Post(Models.TbPatient usuario )//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                db.TbPatients.Add(usuario);
               
                await db.SaveChangesAsync();
            }
            return Ok();
        }//task

        [HttpPost("verificar")]

        public async Task<ActionResult> PostVerificar(TbPatient paciente)//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                var existe = await db.TbPatients.AnyAsync(x => x.PatientId == paciente.PatientId && x.PatientPassword == paciente.PatientPassword);
                if (!existe)
                {
                    return NotFound("no encontrado");
                }
            }
            return Ok("encontrado");
        }//task


        [HttpGet("Vacunas/{id:int}")]
        public IEnumerable<Models.TbPatientVaccine>  GetVacunas(int id)
        {
            List<Models.TbPatientVaccine> vacunasLista = new List<Models.TbPatientVaccine>();
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                System.Collections.IList list = db.TbPatientVaccines.ToList();
                for (int i = 0; i < list.Count; i++) {
                    Models.TbPatientVaccine vacc = (Models.TbPatientVaccine)list[i];
                    if (vacc.PatientId == id)
                    {
                        vacc.Patient = db.TbPatients.FirstOrDefault(x => x.PatientId == id);
                        vacc.Vaccine = db.TbVaccines.FirstOrDefault(x => x.VaccineId == vacc.VaccineId);
                        vacunasLista.Add(vacc);
                    }
                
                }
                return vacunasLista;
            }


        }


        [HttpGet("Alergias/{id:int}")]
        public IEnumerable<Models.TbPatientAllergy> GetAlergias(int id)
        {
            List<Models.TbPatientAllergy> lista = new List<Models.TbPatientAllergy>();
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                System.Collections.IList list = db.TbPatientAllergies.ToList();
                for (int i = 0; i < list.Count; i++)
                {
                    Models.TbPatientAllergy temp = (Models.TbPatientAllergy)list[i];
                    if (temp.PatientId == id)
                    {
                        temp.Patient = db.TbPatients.FirstOrDefault(x => x.PatientId == id);
                        temp.Allergy = db.TbAllergies.FirstOrDefault(x => x.AllergyId == temp.AllergyId);
                        lista.Add(temp);
                    }

                }
                return lista;
            }


        }
        [HttpGet("Citas/{id:int}")]
        public IEnumerable<Models.TbDoctorAppointment> GetCitas(int id)
        {
            List<Models.TbDoctorAppointment> citasLista = new List<Models.TbDoctorAppointment>();
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                System.Collections.IList list = db.TbDoctorAppointments.ToList();
                for (int i = 0; i < list.Count; i++)
                {
                    Models.TbDoctorAppointment cita = (Models.TbDoctorAppointment)list[i];
                    if (cita.PatientId == id)
                    {
                        cita.Center = db.TbHealthCenters.FirstOrDefault(x => x.CenterId == cita.CenterId);
                        cita.Patient = db.TbPatients.FirstOrDefault(x => x.PatientId == id);
                        cita.Specialty = db.TbEspecialidads.FirstOrDefault(x => x.EspecialidadId == cita.SpecialtyId);
                        citasLista.Add(cita);
                    }

                }
                return citasLista;
            }


        }

        [HttpGet]
        public IEnumerable<Models.TbPatient> Get()
        {
            using ( var db = new Models.proyecto3_lenguajesContext())
            {
                IEnumerable<Models.TbPatient> pacientes = db.TbPatients.ToList();
                return pacientes;
            }
                
        }

        [HttpGet("Informacion/{id:int}")]
        public IEnumerable<Models.informacion> GetInformacion(int id)
        {
            List<Models.informacion> informacion = new List<Models.informacion>();
            using (var db = new Models.proyecto3_lenguajesContext())
            {

                Models.TbPatientDetail  detail   =   db.TbPatientDetails.FirstOrDefault(x => x.PatientId == id);
                Models.TbPatientAddress address  =   db.TbPatientAddresses.FirstOrDefault(x => x.PatientId == id);
                Models.TbPatient        temp     =   db.TbPatients.FirstOrDefault(x => x.PatientId == id);

                Models.informacion info = new Models.informacion();
                info.Patient = temp;
                info.Details = detail;
                info.Address = address;

                informacion.Add(info);

                return informacion;
            }

        }

        [HttpPost("Direccion")]

        public async Task<ActionResult> registrarDireccion(Models.TbPatientAddress temp)//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                db.TbPatientAddresses.Add(temp);
                await db.SaveChangesAsync();
            }
            return Ok();
        }//task

        [HttpPost("Registrar/Informacion")]

        public async Task<ActionResult> registrarInformacion(Models.TbPatientDetail usuario)//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                db.TbPatientDetails.Add(usuario);
                await db.SaveChangesAsync();
            }
            return Ok();
        }//task

    }//fin clase de Pacientes
}
