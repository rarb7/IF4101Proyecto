using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbPatient
    {
        public int PatientId { get; set; }
        public string PatientName { get; set; }
        public string PatientLastname { get; set; }
        public string PatientPassword { get; set; }
        public int? PatientAge { get; set; }

        //public int? AddressId { get; set; }
        //public int? DetailId { get; set; }

        //public virtual TbAddress Address { get; set; }
        //public virtual TbDetail Details { get; set; }
    }
}
