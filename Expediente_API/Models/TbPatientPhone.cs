using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbPatientPhone
    {
        public int? PatientId { get; set; }
        public int? PhoneId { get; set; }

        public virtual TbPatient Patient { get; set; }
        public virtual TbPhone Phone { get; set; }
    }
}
