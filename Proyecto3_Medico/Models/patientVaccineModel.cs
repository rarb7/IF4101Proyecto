using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.Models
{
    public class patientVaccineModel
    {
        public int paciente { get; set; }

        public int vacuna { get; set; }

        public string aplicacion { get; set; }

        public string siguienteapp { get; set; }
        public string description { get; set; }
        public string vacuna_nombre { get; set; }
    }
}
