package com.example.statsalumnos;

public class Alumno {
    private int id;
    private String usuario;
    private String grupo;
    private String sexo;
    private int edad;
    private int flex1;
    private int flex3;
    private int fuer1;
    private int fuer3;
    private int vel1;
    private int vel3;
    private int res1;
    private int res3;

    public Alumno(String usuario, String grupo, String sexo, int edad) {
        this.usuario = usuario;
        this.grupo = grupo;
        this.sexo = sexo;
        this.edad = edad;
        setFlex1(-1);
        setFlex3(-1);
        setFuer1(-1);
        setFuer3(-1);
        setVel1(-1);
        setVel3(-1);
        setRes1(-1);
        setRes3(-1);
    }

    public Alumno(int id, String usuario, String grupo, String sexo, int edad, int flex1, int flex3, int fuer1, int fuer3, int vel1, int vel3, int res1, int res3) {
        this.id = id;
        this.usuario = usuario;
        this.grupo = grupo;
        this.sexo = sexo;
        this.edad = edad;
        this.flex1 = flex1;
        this.flex3 = flex3;
        this.fuer1 = fuer1;
        this.fuer3 = fuer3;
        this.vel1 = vel1;
        this.vel3 = vel3;
        this.res1 = res1;
        this.res3 = res3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFlex1() {
        return flex1;
    }

    public void setFlex1(int flex1) {
        this.flex1 = flex1;
    }

    public int getFlex3() {
        return flex3;
    }

    public void setFlex3(int flex3) {
        this.flex3 = flex3;
    }

    public int getFuer1() {
        return fuer1;
    }

    public void setFuer1(int fuer1) {
        this.fuer1 = fuer1;
    }

    public int getFuer3() {
        return fuer3;
    }

    public void setFuer3(int fuer3) {
        this.fuer3 = fuer3;
    }

    public int getVel1() {
        return vel1;
    }

    public void setVel1(int vel1) {
        this.vel1 = vel1;
    }

    public int getVel3() {
        return vel3;
    }

    public void setVel3(int vel3) {
        this.vel3 = vel3;
    }

    public int getRes1() {
        return res1;
    }

    public void setRes1(int res1) {
        this.res1 = res1;
    }

    public int getRes3() {
        return res3;
    }

    public void setRes3(int res3) {
        this.res3 = res3;
    }
}
