using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.Models
{
    public class patientAllergyModel
    {
        public int patient_id { get; set; }

        public int allergy_id { get; set; }

        public string allergy_name { get; set; }
        public string diagnostic_date { get; set; }

        public string medicine { get; set; }
        public string description { get; set; }
    }
}
