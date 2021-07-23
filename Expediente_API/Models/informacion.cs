namespace Expediente_API.Models
{
    public partial class informacion
    {

        public virtual TbPatient Patient { get; set; }

        public virtual TbPatientAddress Address { get; set; }
        public virtual TbPatientDetail Details { get; set; }


    }
}