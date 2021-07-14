using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Expediente_API.Entities
{
    public class Patient
    {
        public int PatientId { get; set; }
        public string PatientName { get; set; }

        public string PatientLastname { get; set; }
        public int PatientAge { get; set; }
        public string Password { get; set; }
    }//fin clase Paciente
}
