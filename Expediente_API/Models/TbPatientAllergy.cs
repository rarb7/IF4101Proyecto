using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbPatientAllergy
    {
        public int? PatientId { get; set; }
        public int? AllergyId { get; set; }
        public DateTime? DiagnosticDate { get; set; }
        public string Medication { get; set; }
        public string Reasons { get; set; }

        public virtual TbAllergy Allergy { get; set; }
        public virtual TbPatient Patient { get; set; }
    }
}
