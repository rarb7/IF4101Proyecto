using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Controllers
{
    [Route("api/Informacion")]
    [ApiController]
    public class InformacionController : ControllerBase
    {
        //----------------------------------------- Gets && Puts de los detalles del usuario --------------------

       // [HttpGet("Detalles/Direccion/{id:int}")]
        //public IEnumerable<Models.TbPatientAddress> DetallesDireccion(int id)
        //{
        //    List<Models.TbPatientAddress> lista = new List<Models.TbPatientAddress>();
        //    using (var db = new Models.proyecto3_lenguajesContext())
        //    {
        //        System.Collections.IList list = db.TbPatientAddresses.ToList();
        //        for (int i = 0; i < list.Count; i++)
        //        {
        //            Models.TbPatientAddress temp = (Models.TbPatientAddress)list[i];
        //            if (temp.PatientId == id)
        //            {
        //                temp.Patient = db.TbPatients.FirstOrDefault(x => x.PatientId == id);

        //                lista.Add(temp);
        //            }

        //        }


        //        return lista;
        //    }

        //}

        //[HttpGet("Detalles/Informacion/{id:int}")]
        //public IEnumerable<Models.TbPatientDetail> DetallesUsuario(int id)
        //{
        //    List<Models.TbPatientDetail> lista = new List<Models.TbPatientDetail>();
        //    using (var db = new Models.proyecto3_lenguajesContext())
        //    {
        //        System.Collections.IList list = db.TbPatientDetails.ToList();
        //        for (int i = 0; i < list.Count; i++)
        //        {
        //            Models.TbPatientDetail temp = (Models.TbPatientDetail)list[i];
        //            if (temp.PatientId == id)
        //            {
        //                temp.Patient = db.TbPatients.FirstOrDefault(x => x.PatientId == id);

        //                lista.Add(temp);
        //            }

        //        }
        //        return lista;
        //    }

        //}

        // ----------- registrar Direccion & Detalles

        [HttpPost("Detalles/Registrar/Direccion")]

        public async Task<ActionResult> registrarDireccion(Models.TbPatientAddress temp)//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                db.TbPatientAddresses.Add(temp);
                await db.SaveChangesAsync();
            }
            return Ok();
        }//task

        [HttpPost("Detalles/Registrar/Informacion")]

        public async Task<ActionResult> registrarInformacion(Models.TbPatientDetail usuario)//asincrono, no se sabe cuando va a durar 
        {
            using (var db = new Models.proyecto3_lenguajesContext())
            {
                db.TbPatientDetails.Add(usuario);
                await db.SaveChangesAsync();
            }
            return Ok();
        }//task

        // ----------- registrar Direccion & Detalles
        [HttpPut("Detalles/Editar/Direccion/{id:int}")]
        public async Task<ActionResult> EditarDireccion(int id, Models.TbPatientAddress temp)//asincrono, no se sabe cuando va a durar 
        {

            using (var db = new Models.proyecto3_lenguajesContext())
            {

                var existe = await db.TbPatientAddresses.AnyAsync(x => x.PatientId == id);
                if (!existe)

                {
                    return NotFound();
                }
                db.TbPatientAddresses.Update(temp);
                await db.SaveChangesAsync();
                return Ok();

            }
        }//task


        [HttpPut("Detalles/Editar/Informacion/{id:int}")]
        public async Task<ActionResult> EditarInformacion(int id, Models.TbPatientDetail temp)//asincrono, no se sabe cuando va a durar 
        {

            using (var db = new Models.proyecto3_lenguajesContext())
            {

                var existe = await db.TbPatientDetails.AnyAsync(x => x.PatientId == id);
                if (!existe)
                {
                    return NotFound();
                }

                db.TbPatientDetails.Update(temp);
                await db.SaveChangesAsync();
                return Ok();

            }

        }//task

        [HttpGet("Informacion/{id:int}")]
        public IEnumerable<Models.informacion> GetInformacion(int id)
        {
            List<Models.informacion> informacion = new List<Models.informacion>();
            using (var db = new Models.proyecto3_lenguajesContext())
            {

                Models.TbPatientDetail detail = db.TbPatientDetails.FirstOrDefault(x => x.PatientId == id);
                Models.TbPatientAddress address = db.TbPatientAddresses.FirstOrDefault(x => x.PatientId == id);
                Models.TbPatient temp = db.TbPatients.FirstOrDefault(x => x.PatientId == id);

                Models.informacion info = new Models.informacion();
                info.Patient = temp;
                info.Details = detail;
                info.Address = address;

                informacion.Add(info);

                return informacion;
            }

        }

    }
}
