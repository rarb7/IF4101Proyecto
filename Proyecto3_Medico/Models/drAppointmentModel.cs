using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Proyecto3_Medico.Models
{
    public class drAppointmentModel
    {
        public  int patient_id { get; set; }
        public int center_id { get; set; }
        public string appointment_day { get; set; }
        public string appointment_hour { get; set; }
        public string details { get; set; }
        public int specialty_id { get; set; }

        //lo que me va a servir para el select
        public string patient_name { get; set; }
        public string center_name { get; set; }

        public string specialty_name { get; set; }

    }
}
