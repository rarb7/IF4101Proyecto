using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbVaccine
    {
        public int VaccineId { get; set; }
        public string VaccineName { get; set; }
        public string VaccineDescription { get; set; }
    }
}
