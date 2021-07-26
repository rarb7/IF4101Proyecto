using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace Expediente_API.Models
{
    public partial class proyecto3_lenguajesContext : DbContext
    {
        public proyecto3_lenguajesContext()
        {
        }

        public proyecto3_lenguajesContext(DbContextOptions<proyecto3_lenguajesContext> options)
            : base(options)
        {
        }

        public virtual DbSet<TbAddress> TbAddresses { get; set; }
        public virtual DbSet<TbAllergy> TbAllergies { get; set; }
        public virtual DbSet<TbDoctor> TbDoctors { get; set; }
        public virtual DbSet<TbDoctorAppointment> TbDoctorAppointments { get; set; }
        public virtual DbSet<TbEspecialidad> TbEspecialidads { get; set; }
        public virtual DbSet<TbEspecialidadDoctor> TbEspecialidadDoctors { get; set; }
        public virtual DbSet<TbHealthCenter> TbHealthCenters { get; set; }
        public virtual DbSet<TbPatient> TbPatients { get; set; }
        public virtual DbSet<TbPatientAddress> TbPatientAddresses { get; set; }
        public virtual DbSet<TbPatientAllergy> TbPatientAllergies { get; set; }
        public virtual DbSet<TbPatientDetail> TbPatientDetails { get; set; }
        public virtual DbSet<TbPatientPhone> TbPatientPhones { get; set; }
        public virtual DbSet<TbPatientVaccine> TbPatientVaccines { get; set; }
        public virtual DbSet<TbPhone> TbPhones { get; set; }
        public virtual DbSet<TbVaccine> TbVaccines { get; set; }

        public virtual DbSet<TbDetail> TbDetails { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseSqlServer("Server=163.178.107.10;Database=db_proyecto3_b76152;user=laboratorios;password=KmZpo.2796");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("Relational:Collation", "SQL_Latin1_General_CP1_CI_AS");

            modelBuilder.Entity<TbAddress>(entity =>
            {
                entity.HasKey(e => e.AddressId)
                    .HasName("PK__tb_ADDRE__66EDEA2F58515F67");

                entity.ToTable("tb_ADDRESS", "HOSPITAL");

                entity.Property(e => e.AddressId).HasColumnName("ADDRESS_ID");

                entity.Property(e => e.Canton)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("CANTON");

                entity.Property(e => e.Distrito)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("DISTRITO");

                entity.Property(e => e.OtrasSennas)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("OTRAS_SENNAS");

                entity.Property(e => e.Provincia)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PROVINCIA");
            });

            modelBuilder.Entity<TbAllergy>(entity =>
            {
                entity.HasKey(e => e.AllergyId)
                    .HasName("PK__tb_ALLER__C89F844712F3BA1F");

                entity.ToTable("tb_ALLERGY", "HOSPITAL");

                entity.Property(e => e.AllergyId).HasColumnName("ALLERGY_ID");

                entity.Property(e => e.AllergyDescription)
                    .HasMaxLength(64)
                    .IsUnicode(false)
                    .HasColumnName("ALLERGY_DESCRIPTION");

                entity.Property(e => e.AllergyName)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("ALLERGY_NAME");
            });

            modelBuilder.Entity<TbDoctor>(entity =>
            {
                entity.HasKey(e => e.DrCode)
                    .HasName("PK__tb_DOCTO__04969F007C8B9229");

                entity.ToTable("tb_DOCTOR", "HOSPITAL");

                entity.Property(e => e.DrCode)
                    .ValueGeneratedNever()
                    .HasColumnName("DR_CODE");

                entity.Property(e => e.DrId)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("DR_ID");

                entity.Property(e => e.DrLastname)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("DR_LASTNAME");

                entity.Property(e => e.DrName)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("DR_NAME");

                entity.Property(e => e.SrPassword)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("SR_PASSWORD");
            });

            modelBuilder.Entity<TbDoctorAppointment>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("tb_DOCTOR_APPOINTMENT", "HOSPITAL");

                entity.Property(e => e.CenterId).HasColumnName("CENTER_ID");

                entity.Property(e => e.Details)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("DETAILS");

                entity.Property(e => e.DrAppDay)
                    .HasColumnType("date")
                    .HasColumnName("DR_APP_DAY");

                entity.Property(e => e.DrAppHour)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("DR_APP_HOUR");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                entity.Property(e => e.SpecialtyId).HasColumnName("SPECIALTY_ID");

                entity.HasOne(d => d.Center)
                    .WithMany()
                    .HasForeignKey(d => d.CenterId)
                    .HasConstraintName("FK_DA_CENTER_ID");

                entity.HasOne(d => d.Patient)
                    .WithMany()
                    .HasForeignKey(d => d.PatientId)
                    .HasConstraintName("FK_DA_PATIENT_ID");

                entity.HasOne(d => d.Specialty)
                    .WithMany()
                    .HasForeignKey(d => d.SpecialtyId)
                    .HasConstraintName("FK_DA_ESPECIALIDAD_ID");
            });

            modelBuilder.Entity<TbEspecialidad>(entity =>
            {
                entity.HasKey(e => e.EspecialidadId)
                    .HasName("PK__tb_ESPEC__5401D776F33A8351");

                entity.ToTable("tb_ESPECIALIDAD", "HOSPITAL");

                entity.Property(e => e.EspecialidadId).HasColumnName("ESPECIALIDAD_ID");

                entity.Property(e => e.EspecialidadNombre)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("ESPECIALIDAD_NOMBRE");
            });

            modelBuilder.Entity<TbEspecialidadDoctor>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("tb_ESPECIALIDAD_DOCTOR", "HOSPITAL");

                entity.Property(e => e.DrCode).HasColumnName("DR_CODE");

                entity.Property(e => e.EspecialidadId).HasColumnName("ESPECIALIDAD_ID");

                entity.HasOne(d => d.DrCodeNavigation)
                    .WithMany()
                    .HasForeignKey(d => d.DrCode)
                    .HasConstraintName("FK_ED_DR_CODE");

                entity.HasOne(d => d.Especialidad)
                    .WithMany()
                    .HasForeignKey(d => d.EspecialidadId)
                    .HasConstraintName("FK_ED_ESPECIALIDAD_ID");
            });

            modelBuilder.Entity<TbHealthCenter>(entity =>
            {
                entity.HasKey(e => e.CenterId)
                    .HasName("PK__tb_HEALT__99A612E4F4B5045D");

                entity.ToTable("tb_HEALTH_CENTER", "HOSPITAL");

                entity.Property(e => e.CenterId).HasColumnName("CENTER_ID");

                entity.Property(e => e.CenterName)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("CENTER_NAME");
            });

            modelBuilder.Entity<TbPatient>(entity =>
            {
                entity.HasKey(e => e.PatientId)
                    .HasName("PK__tb_PATIE__AA0B606807250CAF");

                entity.ToTable("tb_PATIENT", "HOSPITAL");

                entity.Property(e => e.PatientId)
                    .ValueGeneratedNever()
                    .HasColumnName("PATIENT_ID");

                entity.Property(e => e.PatientAge).HasColumnName("PATIENT_AGE");
                //entity.Property(e => e.AddressId).HasColumnName("ADDRESS_ID");

                //entity.Property(e => e.DetailId).HasColumnName("DETAIL_ID");


                entity.Property(e => e.PatientLastname)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PATIENT_LASTNAME");

                entity.Property(e => e.PatientName)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PATIENT_NAME");

                entity.Property(e => e.PatientPassword)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PATIENT_PASSWORD");
            });
            modelBuilder.Entity<TbDetail>(entity =>
            {
                entity.HasKey(e => e.DetailsId)
                    .HasName("PK__tb_DETAI__7B565E00B2C12926");

                entity.ToTable("tb_DETAILS", "HOSPITAL");

                entity.Property(e => e.DetailsId)
                    .ValueGeneratedNever()
                    .HasColumnName("PATIENT_ID");



                entity.Property(e => e.BloodType)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("BLOOD_TYPE");

                entity.Property(e => e.MaritalStatus)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("MARITAL_STATUS");

                entity.Property(e => e.Phone)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PHONE");
            });
            modelBuilder.Entity<TbPatientAddress>(entity =>
            {
                entity.HasKey(e => e.PatientId)
                    .HasName("PK__tb_PATIE__AA0B6068D8F4F495");

                entity.ToTable("tb_PATIENTADDRESS", "HOSPITAL");

                //entity.Property(e => e.AddressId).HasColumnName("ADDRESS_ID");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                entity.Property(e => e.Provincia)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PROVINCIA");

                entity.Property(e => e.Canton)
                   .HasMaxLength(32)
                   .IsUnicode(false)
                   .HasColumnName("CANTON");

                entity.Property(e => e.Distrito)
                   .HasMaxLength(32)
                   .IsUnicode(false)
                   .HasColumnName("DISTRITO");

                entity.Property(e => e.OtrasSennas)
                  .HasMaxLength(32)
                  .IsUnicode(false)
                  .HasColumnName("OTRAS_SENNAS");
                //entity.HasOne(d => d.Address)
                //    .WithMany()
                //    .HasForeignKey(d => d.AddressId)
                //    .HasConstraintName("FK_P_ADDRESS_ID");

                //entity.HasOne(d => d.Patient)
                //    .WithMany()
                //    .HasForeignKey(d => d.PatientId)
                //    .HasConstraintName("FK_P_PATIENT_ID");
            });

            modelBuilder.Entity<TbPatientAllergy>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("tb_PATIENT_ALLERGY", "HOSPITAL");

                entity.Property(e => e.AllergyId).HasColumnName("ALLERGY_ID");

                entity.Property(e => e.DiagnosticDate)
                    .HasColumnType("date")
                    .HasColumnName("DIAGNOSTIC_DATE");

                entity.Property(e => e.Medication)
                    .HasMaxLength(64)
                    .IsUnicode(false)
                    .HasColumnName("MEDICATION");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                entity.Property(e => e.Reasons)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("REASONS");

                entity.HasOne(d => d.Allergy)
                    .WithMany()
                    .HasForeignKey(d => d.AllergyId)
                    .HasConstraintName("FK_PAL_ALLERGY_ID");

                entity.HasOne(d => d.Patient)
                    .WithMany()
                    .HasForeignKey(d => d.PatientId)
                    .HasConstraintName("FK_PAL_PATIENT_ID");
            });

            modelBuilder.Entity<TbPatientDetail>(entity =>
            {
                entity.HasKey(e => e.PatientId)
                    .HasName("PK__tb_PATIE__AA0B60683821BEE4");

                entity.ToTable("tb_PATIENT_DETAILS", "HOSPITAL");

                entity.Property(e => e.BloodType)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("BLOOD_TYPE");

                entity.Property(e => e.MaritalStatus)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("MARITAL_STATUS");

                entity.Property(e => e.Phone)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("Phone");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                //entity.HasOne(d => d.Patient)
                //    .WithMany()
                //    .HasForeignKey(d => d.PatientId)
                //    .HasConstraintName("FK_PD_PATIENT_ID");
            });

            modelBuilder.Entity<TbPatientPhone>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("tb_PATIENT_PHONE", "HOSPITAL");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                entity.Property(e => e.PhoneId).HasColumnName("PHONE_ID");

                entity.HasOne(d => d.Patient)
                    .WithMany()
                    .HasForeignKey(d => d.PatientId)
                    .HasConstraintName("FK_PP_PATIENT_ID");

                entity.HasOne(d => d.Phone)
                    .WithMany()
                    .HasForeignKey(d => d.PhoneId)
                    .HasConstraintName("FK_PP_PHONE_ID");
            });

            modelBuilder.Entity<TbPatientVaccine>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("tb_PATIENT_VACCINE", "HOSPITAL");

                entity.Property(e => e.NextAppDate)
                    .HasColumnType("date")
                    .HasColumnName("NEXT_APP_DATE");

                entity.Property(e => e.PatientId).HasColumnName("PATIENT_ID");

                entity.Property(e => e.Reasons)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("REASONS");

                entity.Property(e => e.VAppDate)
                    .HasColumnType("date")
                    .HasColumnName("V_APP_DATE");

                entity.Property(e => e.VaccineId).HasColumnName("VACCINE_ID");

                entity.HasOne(d => d.Patient)
                    .WithMany()
                    .HasForeignKey(d => d.PatientId)
                    .HasConstraintName("FK_PV_PATIENT_ID");

                entity.HasOne(d => d.Vaccine)
                    .WithMany()
                    .HasForeignKey(d => d.VaccineId)
                    .HasConstraintName("FK_PV_VACCINE_ID");
            });

            modelBuilder.Entity<TbPhone>(entity =>
            {
                entity.HasKey(e => e.PhoneId)
                    .HasName("PK__tb_PHONE__1BB5AF5F9798E34E");

                entity.ToTable("tb_PHONE", "HOSPITAL");

                entity.Property(e => e.PhoneId).HasColumnName("PHONE_ID");

                entity.Property(e => e.PhoneNumber)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("PHONE_NUMBER");
            });

            modelBuilder.Entity<TbVaccine>(entity =>
            {
                entity.HasKey(e => e.VaccineId)
                    .HasName("PK__tb_VACCI__12B71375D4D0DAE2");

                entity.ToTable("tb_VACCINE", "HOSPITAL");

                entity.Property(e => e.VaccineId).HasColumnName("VACCINE_ID");

                entity.Property(e => e.VaccineDescription)
                    .HasMaxLength(64)
                    .IsUnicode(false)
                    .HasColumnName("VACCINE_DESCRIPTION");

                entity.Property(e => e.VaccineName)
                    .HasMaxLength(32)
                    .IsUnicode(false)
                    .HasColumnName("VACCINE_NAME");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
