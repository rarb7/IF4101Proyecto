using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbDoctor
    {
        public int DrCode { get; set; }
        public string DrName { get; set; }
        public string DrLastname { get; set; }
        public string DrId { get; set; }
        public string SrPassword { get; set; }
    }
}
