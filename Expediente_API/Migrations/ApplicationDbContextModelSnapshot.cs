﻿// <auto-generated />
using Expediente_API;

using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace Expediente_API.Migrations
{
    [DbContext(typeof(ApplicationDbContext))]
    partial class ApplicationDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("ProductVersion", "5.0.6")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Expediente_API.Entities.PatientVaccine", b =>
                {
                    b.Property<int>("PATIENT_ID")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");
                      //  .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("VACCINE_ID")
                        .HasColumnType("int");

                    b.Property<string>("V_APP_DATE")
                        .HasColumnType("DATE");

                    b.Property<int>("NEXT_APP_DATE")
                        .HasColumnType("DATE");

                    b.Property<string>("REASONS")
                        .IsRequired()
                        .HasColumnType("nvarchar(100)");

                    //b.Property<string>("Nombre")
                    //    .HasColumnType("nvarchar(max)");

                    //b.HasKey("Id");

                    b.ToTable("HOSPITAL.tb_PATIENT_VACCINE");
                });
#pragma warning restore 612, 618
        }
    }
}
