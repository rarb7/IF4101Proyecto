using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbPatientVaccine
    {
        public int? PatientId { get; set; }
        public int? VaccineId { get; set; }
        public DateTime? VAppDate { get; set; }
        public DateTime? NextAppDate { get; set; }
        public string Reasons { get; set; }

        public virtual TbPatient Patient { get; set; }
        public virtual TbVaccine Vaccine { get; set; }
    }
}
