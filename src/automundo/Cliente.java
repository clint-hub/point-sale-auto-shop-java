/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automundo;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Lenovo T440
 */
public class Cliente {    
    private int idCliente = 0;
    public String nombreCliente = "";
    private String telefonoCliente = "";
    private String domicilio = "";
    private String ciudad = "";
    private String modeloCarro = "";
    private String añoCarro = "";
    private String colorCarro = "";
    private String marca = "";
    
    
    public Cliente(int idCliente,String nombreCliente, String telefonoCliente, String domicilio, String ciudad, String modeloCarro, String añoCarro, String colorCarro, String marca) {
        
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.modeloCarro = modeloCarro;
        this.añoCarro = añoCarro;
        this.colorCarro = colorCarro;
        this.marca = marca;

    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
        
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getAñoCarro() {
        return añoCarro;
    }

    public void setAñoCarro(String añoCarro) {
        this.añoCarro = añoCarro;
    }

    public String getColorCarro() {
        return colorCarro;
    }

    public void setColorCarro(String colorCarro) {
        this.colorCarro = colorCarro;
    }

    public String getDomicilioCliente() {
        return domicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        this.domicilioCliente = domicilioCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
     public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    private String domicilioCliente = "";
    private String emailCliente;
    private String fechaRegistro="";
    
    


public Cliente(){
    
}



    
}
