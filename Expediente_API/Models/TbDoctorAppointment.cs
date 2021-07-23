using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbDoctorAppointment
    {
        public int? PatientId { get; set; }
        public int? CenterId { get; set; }
        public DateTime? DrAppDay { get; set; }
        public string DrAppHour { get; set; }
        public string Details { get; set; }
        public int? SpecialtyId { get; set; }

        public virtual TbHealthCenter Center { get; set; }
        public virtual TbPatient Patient { get; set; }
        public virtual TbEspecialidad Specialty { get; set; }
    }
}
