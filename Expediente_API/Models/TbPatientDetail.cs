using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    [Keyless]
    public partial class TbPatientDetail
    {
        public int? PatientId { get; set; }
        public string BloodType { get; set; }
        public string MaritalStatus { get; set; }

        public string Phone { get; set; }

        public virtual TbPatient Patient { get; set; }
    }
}
