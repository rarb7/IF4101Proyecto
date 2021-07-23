using System;
using System.Collections.Generic;

#nullable disable

namespace Expediente_API.Models
{
    public partial class TbEspecialidadDoctor
    {
        public int? EspecialidadId { get; set; }
        public int? DrCode { get; set; }

        public virtual TbDoctor DrCodeNavigation { get; set; }
        public virtual TbEspecialidad Especialidad { get; set; }
    }
}
