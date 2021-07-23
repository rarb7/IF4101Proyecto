using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbAllergy
    {
        public int AllergyId { get; set; }
        public string AllergyName { get; set; }
        public string AllergyDescription { get; set; }
    }
}
