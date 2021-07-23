using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    [Keyless]
    public partial class TbPatientAddress
    {
        public int? PatientId { get; set; }
        public string Provincia { get; set; }

        public string Canton { get; set; }
        public string Distrito { get; set; }
        public string OtrasSennas { get; set; }

        // public virtual TbAddress Address { get; set; }
        public virtual TbPatient Patient { get; set; }
    }
}
