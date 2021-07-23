package com.example.expediente.Models;

public class PatientSingleton {
    private int Id;
    private PatientInformation information;

    private PatientSingleton(){

    }//Singleton

    private static PatientSingleton sc = null;

    public static PatientSingleton getInstance(){
        if (sc == null){
            sc = new PatientSingleton();
        }
        return sc;
    }//getInstance


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public PatientInformation getInformation() {
        return information;
    }

    public void setInformation(PatientInformation information) {
        this.information = information;
    }
}
