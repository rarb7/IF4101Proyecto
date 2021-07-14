using Expediente_API.Entities;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Controllers
{
    [ApiController]
    [Route("Api/PacientesVacuna")]
    public class PacientesController: ControllerBase
    {
        private readonly ApplicationDbContext context;//se conecta con la cadena de conexion
        public PacientesController(ApplicationDbContext context)
        {
            this.context = context;
        }//EstudiantesController

        [HttpGet("PATIENT_ID:int")]
        public async Task<ActionResult<List<PatientVaccine>>> Get(int id) {
            return await context.patientVaccine.ToListAsync();
        }//Task
    }

    }//fin clase de Pacientes
}
