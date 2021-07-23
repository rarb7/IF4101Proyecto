using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Entities
{
    [Keyless]
    public class PatientVaccine
    {
        public int paciente { get; set; }

        public int vacuna { get; set; }

        public string aplicacion { get; set; }

        public string siguienteapp { get; set; }
        public string description { get; set; }
        public string vacuna_nombre { get; set; }

    }//end class
}
