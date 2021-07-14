using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Entities
{
    public class PatientVaccine
    {
        public int PatientId { get; set; }
        public int VaccineId { get; set; }
        public string ApplicationDay { get; set; }
        public string NextApplicationDay { get; set; }
        public string ApplicationReasons { get; set; }

    }//end class
}
