/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Oskar
 */
public class dbAutomundo {
    
 
 private String MYSQLDRIVER = "com.mysql.jdbc.Driver";
 private String MYSQLDB = "jdbc:mysql://localhost:3306/automundo?user=root&password=";//LOCAL 
 private Connection conexion;
 private String sqlConsulta;
 private ResultSet registros;
    
public boolean verificarDrive() {
    boolean exito = true;
   
    try{
        
        Class.forName(MYSQLDRIVER);
     
    }catch(ClassNotFoundException e){
        exito = false;
        
    }
    
    return exito;
}    
    
public boolean conectar() {
    boolean exito = true;
    try{
        
            conexion = DriverManager.getConnection(MYSQLDB);
            System.out.println("Se conecto Correctamente");
    }catch(SQLException e){
        
        exito = false;
        System.out.println("Error al Insertar  " +e.getMessage() );
        
    }
    
    return exito;
}

public boolean desconectar() {
    boolean exito = true;
      try{
    conexion.close();  
    }catch(SQLException e) {
      
        exito = false;
        System.out.println("Error al insertar  "+e.getMessage() );
    }

      return exito;
}

//ACTUALIZAR BORRAR Y CONSULTAR CLIENTES


public boolean insertar(Cliente cot){
    boolean exito = true;

    
    if (this.conectar() == true ){
    
    try{
        
        sqlConsulta = "insert into cliente values (null,?,?,?,?,?,?)";
         PreparedStatement insertar = conexion.prepareStatement(sqlConsulta);
         insertar.setString(1,cot.getNombreCliente() );
         insertar.setString(2,cot.getTelefonoCliente() );
         insertar.setString(3,cot.getMarca());
         insertar.setString(4,cot.getModeloCarro());
         insertar.setString(5,cot.getAñoCarro());
         insertar.setString(6,cot.getColorCarro());
         insertar.executeUpdate();
    }catch(SQLException e) {
        
        System.out.println("Error al insertar" +e.getMessage() );
        exito = false;
        
    }
    this.desconectar();
    }

else {
    
    exito = false;
    
    }
         
   return exito;
}    
    
public boolean Actualizar(Cliente cot){
    
boolean exito = true;
   if (this.conectar() == true ){
       
       try{
           
           sqlConsulta = "update cliente set  nombreCliente =?, telefonoCliente =? where telefonoCliente =?;";
            PreparedStatement actualizar = conexion.prepareStatement(sqlConsulta);
         
          
         actualizar.setString(1, cot.getNombreCliente() );
         actualizar.setString(2, cot.getTelefonoCliente() );
         actualizar.setString(3, cot.getTelefonoCliente() );

         actualizar.executeUpdate();
       } catch(SQLException e){
       
       System.out.println("Error al Actualizar"+e.getMessage() );
       exito = false;
   }
       this.desconectar();  
   }
   else{
       exito = false;
   }
   
   return exito;
}


public boolean borrar(String telefonoCliente){
    boolean exito = true;
    this.conectar();
    
    try{
        
      sqlConsulta = "delete from cliente where telefonocliente = ?";
      PreparedStatement borrar= conexion.prepareStatement(sqlConsulta);
      borrar.setString(1, telefonoCliente);
      borrar.executeUpdate();
    }catch(SQLException e){
        exito = false;
        System.out.println("Error al borrar"+e.getMessage() );
     
    }

    this.desconectar();
    
    return exito;
    }

public Cliente consultaCliente (String telefonoCliente){
    Cliente cot =null;
    registros=null; 
    
    try{
        
        this.conectar();
        this.sqlConsulta = "Select * from cliente where telefonocliente =?";
        PreparedStatement consulta = conexion.prepareStatement(this.sqlConsulta);
        consulta.setString(1, telefonoCliente);
        registros=consulta.executeQuery();
    
    if(registros.first()==false){
        
        System.out.println("No hay registros");
        
    }    
    else{
        
       cot = new Cliente();
       cot.setNombreCliente(registros.getString("nombrecliente") );
       cot.setTelefonoCliente(registros.getString("telefonoCliente") );
       
       
    }
    
    }catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage() ); }
     this.desconectar();
     
     return cot;
}

//AUTOINCREMENTABLE

 //public Notaremision consultaFolio (int folio){
   // Notaremision emp =null;
    //registros=null; 
    
   // try{
       
  //      this.conectar();
    //    this.sqlConsulta = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'raksodev_automundo' AND TABLE_NAME = 'notaremision'";
      //  PreparedStatement consulta = conexion.prepareStatement(this.sqlConsulta);
        //consulta.setInt(1, folio);
       // registros=consulta.executeQuery();
    
   // if(registros.first()==false){
        
     //   System.out.println("No hay registros");
        
   // }    
   // else{
     //    emp = new Notaremision();
       
      
     //  emp.setFolio(registros.getInt("folio"));
       
       
       
   // }
    
    //}catch(SQLException e){
     //       System.out.println("Error al consultar" + e.getMessage() ); }
    // this.desconectar();
     
   // return emp;
//}


//ACTUALIZAR BORRAR Y CONSULTAR VEHICULOS DE CLIENTE
public boolean insertarvehiculo(Cliente cot){
    boolean exito = true;

    
    if (this.conectar() == true ){
    
    try{
        
        sqlConsulta = "insert into cliente values (null,?,?,?,?,?,?)";
         PreparedStatement insertar = conexion.prepareStatement(sqlConsulta);
         insertar.setString(1, cot.getNombreCliente());
         insertar.setString(2, cot.getTelefonoCliente());
         insertar.setString(3, cot.getMarca());
         insertar.setString(4, cot.getModeloCarro());
         insertar.setString(5,cot.getAñoCarro());
         insertar.setString(6,cot.getColorCarro());
         insertar.executeUpdate();
    }catch(SQLException e) {
        
        System.out.println("Error al insertar" +e.getMessage() );
        exito = false;
        
    }
    this.desconectar();
    }

else {
    
    exito = false;
    
    }
         
   return exito;
}    

public boolean borrarvehiculo(String telefonoCliente){
    boolean exito = true;
    this.conectar();
    
    try{
        
      sqlConsulta = "delete from vehiculo where telefonoCliente = ?";
      PreparedStatement borrar= conexion.prepareStatement(sqlConsulta);
      borrar.setString(1, telefonoCliente);
      borrar.executeUpdate();
    }catch(SQLException e){
        exito = false;
        System.out.println("Error al borrar"+e.getMessage() );
     
    }

    this.desconectar();
    
    return exito;
    }
 


//ACTUALIZAR BORRAR Y CONSULTAR NOTAS DE REMISION
public boolean insertarnotaremision(Notaremision emp, Cliente cot){  
    boolean exito = true;

    
    if (this.conectar() == true ){
    
    try{
        
        sqlConsulta = "insert into notaremision values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //
         PreparedStatement insertar = conexion.prepareStatement(sqlConsulta);
         insertar.setString(1, cot.getNombreCliente() );
         insertar.setString(2, cot.getTelefonoCliente() );
         insertar.setString(3, emp.getrFecha() );
         insertar.setString(4, emp.getrMarca() );
         insertar.setString(5, emp.getrModelo() );
         insertar.setString(6, emp.getrColor() );
         insertar.setInt(7, emp.getrCantidad() );
         insertar.setInt(8, emp.getrCantidad2() );
         insertar.setInt(9, emp.getrCantidad3() );
         insertar.setInt(10, emp.getrCantidad4() );
         insertar.setInt(11, emp.getrCantidad5() );
         insertar.setInt(12, emp.getrCantidad6() );
         insertar.setInt(13, emp.getrCantidad7() );
         insertar.setInt(14, emp.getrCantidad8() );
         insertar.setInt(15, emp.getrCantidad9() );
         insertar.setInt(16, emp.getrCantidad10() );
         insertar.setInt(17, emp.getrCantidad11() );
         insertar.setInt(18, emp.getrCantidad12() );
         insertar.setInt(19, emp.getrCantidad13() );
         insertar.setInt(20, emp.getrCantidad14() );
         insertar.setInt(21, emp.getrCantidad15() );
         insertar.setInt(22, emp.getrCantidad16() );
         insertar.setInt(23, emp.getrCantidad17() );
         insertar.setInt(24, emp.getrCantidad18() );
         insertar.setInt(25, emp.getrCantidad19() );
         insertar.setInt(26, emp.getrCantidad20() );
         insertar.setString(27, emp.getrDescripcion() );
         insertar.setString(28, emp.getrDescripcion2() );
         insertar.setString(29, emp.getrDescripcion3() );
         insertar.setString(30, emp.getrDescripcion4() );
         insertar.setString(31, emp.getrDescripcion5() );
         insertar.setString(32, emp.getrDescripcion6() );
         insertar.setString(33, emp.getrDescripcion7() );
         insertar.setString(34, emp.getrDescripcion8() );
         insertar.setString(35, emp.getrDescripcion9() );
         insertar.setString(36, emp.getrDescripcion10() );
         insertar.setString(37, emp.getrDescripcion11() );
         insertar.setString(38, emp.getrDescripcion12() );
         insertar.setString(39, emp.getrDescripcion13() );
         insertar.setString(40, emp.getrDescripcion14() );
         insertar.setString(41, emp.getrDescripcion15() );
         insertar.setString(42, emp.getrDescripcion16() );
         insertar.setString(43, emp.getrDescripcion17() );
         insertar.setString(44, emp.getrDescripcion18() );
         insertar.setString(45, emp.getrDescripcion19() );
         insertar.setString(46, emp.getrDescripcion20() );
         insertar.setFloat(47, emp.getrPrecio() );
         insertar.setFloat(48, emp.getrPrecio2() );
         insertar.setFloat(49, emp.getrPrecio3() );
         insertar.setFloat(50, emp.getrPrecio4() );
         insertar.setFloat(51, emp.getrPrecio5() );
         insertar.setFloat(52, emp.getrPrecio6() );
         insertar.setFloat(53, emp.getrPrecio7() );
         insertar.setFloat(54, emp.getrPrecio8() );
         insertar.setFloat(55, emp.getrPrecio9() );
         insertar.setFloat(56, emp.getrPrecio10() );
         insertar.setFloat(57, emp.getrPrecio11() );
         insertar.setFloat(58, emp.getrPrecio12() );
         insertar.setFloat(59, emp.getrPrecio13() );
         insertar.setFloat(60, emp.getrPrecio14() );
         insertar.setFloat(61, emp.getrPrecio15() );
         insertar.setFloat(62, emp.getrPrecio16() );
         insertar.setFloat(63, emp.getrPrecio17() );
         insertar.setFloat(64, emp.getrPrecio18() );
         insertar.setFloat(65, emp.getrPrecio19() );
         insertar.setFloat(66, emp.getrPrecio20() );
         insertar.setFloat(67, emp.getrSubtotal() );
         insertar.setFloat(68, emp.getrIva() );
         insertar.setFloat(69, emp.getrTotal() );
         insertar.setString(70, emp.getrGarantia());
         insertar.setString(71, emp.getrObservaciones());

         insertar.executeUpdate();
    }catch(SQLException e) {
        
        System.out.println("Error al insertar" +e.getMessage() );
        exito = false;
        
    }
    this.desconectar();
    }

else {
    
    exito = false;
    
    }
         
   return exito;
}    
    
public boolean Actualizarnotaremision(Notaremision emp){ //, Cliente cot
    
boolean exito = true;
   if (this.conectar() == true ){
       
       try{
           
           sqlConsulta = "update notaremision set nombrecliente =?, telefonocliente =?, rmodelo=?, rmarca=?, rfecha=?, rcolor=?, rcantidad=?, rcantidad2=?, rcantidad3=?, rcantidad4=?, rcantidad5=?, rcantidad6=?, rcantidad7=?, rcantidad8=?, rcantidad9=?, rcantidad10=?, rcantidad11=?, rcantidad12=?, rcantidad13=?, rcantidad14=?, rcantidad15=?, rcantidad16=?, rcantidad17=?, rcantidad18=?, rcantidad19=?, rcantidad20=?, rdescripcion=?, rdescripcion2=?, rdescripcion3=?, rdescripcion4=?, rdescripcion5=?, rdescripcion6=?, rdescripcion7=?, rdescripcion8=?, rdescripcion9=?, rdescripcion10=?, rdescripcion11=?, rdescripcion12=?, rdescripcion13=?, rdescripcion14=?, rdescripcion15=?, rdescripcion16=?, rdescripcion17=?, rdescripcion18=?, rdescripcion19=?, rdescripcion20=?, rprecio=?, rprecio2=?, rprecio3=?, rprecio4=?, rprecio5=?, rprecio6=?, rprecio7=?, rprecio8=?, rprecio9=?, rprecio10=?, rprecio11=?, rprecio12=?, rprecio13=?, rprecio14=?, rprecio15=?, rprecio16=?, rprecio17=?, rprecio18=?, rprecio19=?, rprecio20=?, rsubtotal=?, riva=?, rtotal=?, rgarantia=?, robservaciones=? where folio =?;";
            PreparedStatement actualizar = conexion.prepareStatement(sqlConsulta);
         
          
         actualizar.setString(1, emp.getrNombreCliente() );
         actualizar.setString(2, emp.getrTelefonoCliente());
         actualizar.setString(3, emp.getrModelo() );
         actualizar.setString(4, emp.getrMarca() );
         actualizar.setString(5,emp.getrFecha() );
         actualizar.setString(6,emp.getrColor() );
         
         actualizar.setInt(7,emp.getrCantidad() );
         actualizar.setInt(8,emp.getrCantidad2() );
         actualizar.setInt(9,emp.getrCantidad3() );
         actualizar.setInt(10,emp.getrCantidad4() );
         actualizar.setInt(11,emp.getrCantidad5() );
         actualizar.setInt(12,emp.getrCantidad6() );
         actualizar.setInt(13,emp.getrCantidad7() );
         actualizar.setInt(14,emp.getrCantidad8() );
         actualizar.setInt(15,emp.getrCantidad9() );
         actualizar.setInt(16,emp.getrCantidad10() );
         actualizar.setInt(17,emp.getrCantidad11() );
         actualizar.setInt(18,emp.getrCantidad12() );
         actualizar.setInt(19,emp.getrCantidad13() );
         actualizar.setInt(20,emp.getrCantidad14() );
         actualizar.setInt(21,emp.getrCantidad15() );
         actualizar.setInt(22,emp.getrCantidad16() );
         actualizar.setInt(23,emp.getrCantidad17() );
         actualizar.setInt(24,emp.getrCantidad18() );
         actualizar.setInt(25,emp.getrCantidad19() );
         actualizar.setInt(26,emp.getrCantidad20() );
         
         actualizar.setString(27,emp.getrDescripcion() );
         actualizar.setString(28,emp.getrDescripcion2() );
         actualizar.setString(29,emp.getrDescripcion3() );
         actualizar.setString(30,emp.getrDescripcion4() );
         actualizar.setString(31,emp.getrDescripcion5() );
         actualizar.setString(32,emp.getrDescripcion6() );
         actualizar.setString(33,emp.getrDescripcion7() );
         actualizar.setString(34,emp.getrDescripcion8() );
         actualizar.setString(35,emp.getrDescripcion9() );
         actualizar.setString(36,emp.getrDescripcion10() );
         actualizar.setString(37,emp.getrDescripcion11() );
         actualizar.setString(38,emp.getrDescripcion12() );
         actualizar.setString(39,emp.getrDescripcion13() );
         actualizar.setString(40,emp.getrDescripcion14() );
         actualizar.setString(41,emp.getrDescripcion15() );
         actualizar.setString(42,emp.getrDescripcion16() );
         actualizar.setString(43,emp.getrDescripcion17() );
         actualizar.setString(44,emp.getrDescripcion18() );
         actualizar.setString(45,emp.getrDescripcion19() );
         actualizar.setString(46,emp.getrDescripcion20() );
         
         actualizar.setFloat(47,emp.getrPrecio() );
         actualizar.setFloat(48,emp.getrPrecio2() );
         actualizar.setFloat(49,emp.getrPrecio3() );
         actualizar.setFloat(50,emp.getrPrecio4() );
         actualizar.setFloat(51,emp.getrPrecio5() );
         actualizar.setFloat(52,emp.getrPrecio6() );
         actualizar.setFloat(53,emp.getrPrecio7() );
         actualizar.setFloat(54,emp.getrPrecio8() );
         actualizar.setFloat(55,emp.getrPrecio9() );
         actualizar.setFloat(56,emp.getrPrecio10() );
         actualizar.setFloat(57,emp.getrPrecio11() );
         actualizar.setFloat(58,emp.getrPrecio12() );
         actualizar.setFloat(59,emp.getrPrecio13() );
         actualizar.setFloat(60,emp.getrPrecio14() );
         actualizar.setFloat(61,emp.getrPrecio15() );
         actualizar.setFloat(62,emp.getrPrecio16() );
         actualizar.setFloat(63,emp.getrPrecio17() );
         actualizar.setFloat(64,emp.getrPrecio18() );
         actualizar.setFloat(65,emp.getrPrecio19() );
         actualizar.setFloat(66,emp.getrPrecio20() );
         
         actualizar.setFloat(67,emp.getrSubtotal() );
         actualizar.setFloat(68,emp.getrIva() );
         actualizar.setFloat(69,emp.getrTotal());
         actualizar.setString(70,emp.getrGarantia());
         actualizar.setString(71,emp.getrObservaciones());

         actualizar.setInt(72,emp.getFolio());

         //actualizar.setString(7,cot.getTelefonoCliente() );

         actualizar.executeUpdate();
       } catch(SQLException e){
       
       System.out.println("Error al Actualizar"+e.getMessage() );
       exito = false;
   }
       this.desconectar();  
   }
   else{
       exito = false;
   }
   
   return exito;
}

public boolean borrarnotaremision(int folio){
    boolean exito = true;
    this.conectar();
    
    try{
        
      sqlConsulta = "delete from notaremision where folio = ?";
      PreparedStatement borrar= conexion.prepareStatement(sqlConsulta);
      borrar.setInt(1,folio);
      borrar.executeUpdate();
    }catch(SQLException e){
        exito = false;
        System.out.println("Error al borrar"+e.getMessage() );
     
    }

    this.desconectar();
    
    return exito;
    }

public Notaremision consultanotaremision (int folio){
    Notaremision emp =null;
    registros=null; 
    
    try{
        
        this.conectar();
        this.sqlConsulta = "Select * from notaremision where folio =?";
        PreparedStatement consulta = conexion.prepareStatement(this.sqlConsulta);
        consulta.setInt(1, folio);
        registros=consulta.executeQuery();
    
    if(registros.first()==false){
        
        System.out.println("No hay registros");
        
    }    
    else{
         emp = new Notaremision();
       
      emp.setrTelefonoCliente(registros.getString("telefonocliente") );
       emp.setrNombreCliente(registros.getString("nombrecliente") );
       emp.setFolio(registros.getInt("folio"));
       emp.setrFecha(registros.getString("rfecha"));
       emp.setrMarca(registros.getString("rmarca"));
       emp.setrModelo(registros.getString("rmodelo"));
       emp.setrColor(registros.getString("rcolor"));
       emp.setrCantidad(registros.getInt("rcantidad"));
       emp.setrCantidad2(registros.getInt("rcantidad2"));
       emp.setrCantidad3(registros.getInt("rcantidad3"));
       emp.setrCantidad4(registros.getInt("rcantidad4"));
       emp.setrCantidad5(registros.getInt("rcantidad5"));
       emp.setrCantidad6(registros.getInt("rcantidad6"));
       emp.setrCantidad7(registros.getInt("rcantidad7"));
       emp.setrCantidad8(registros.getInt("rcantidad8"));
       emp.setrCantidad9(registros.getInt("rcantidad9"));
       emp.setrCantidad10(registros.getInt("rcantidad10"));
       emp.setrCantidad11(registros.getInt("rcantidad11"));
       emp.setrCantidad12(registros.getInt("rcantidad12"));
       emp.setrCantidad13(registros.getInt("rcantidad13"));
       emp.setrCantidad14(registros.getInt("rcantidad14"));
       emp.setrCantidad15(registros.getInt("rcantidad15"));
       emp.setrCantidad16(registros.getInt("rcantidad16"));
       emp.setrCantidad17(registros.getInt("rcantidad17"));
       emp.setrCantidad18(registros.getInt("rcantidad18"));
       emp.setrCantidad19(registros.getInt("rcantidad19"));
       emp.setrCantidad20(registros.getInt("rcantidad20"));
       emp.setrDescripcion(registros.getString("rdescripcion"));
       emp.setrDescripcion2(registros.getString("rdescripcion2"));
       emp.setrDescripcion3(registros.getString("rdescripcion3"));
       emp.setrDescripcion4(registros.getString("rdescripcion4"));
       emp.setrDescripcion5(registros.getString("rdescripcion5"));
       emp.setrDescripcion6(registros.getString("rdescripcion6"));
       emp.setrDescripcion7(registros.getString("rdescripcion7"));
       emp.setrDescripcion8(registros.getString("rdescripcion8"));
       emp.setrDescripcion9(registros.getString("rdescripcion9"));
       emp.setrDescripcion10(registros.getString("rdescripcion10"));
       emp.setrDescripcion11(registros.getString("rdescripcion11"));
       emp.setrDescripcion12(registros.getString("rdescripcion12"));
       emp.setrDescripcion13(registros.getString("rdescripcion13"));
       emp.setrDescripcion14(registros.getString("rdescripcion14"));
       emp.setrDescripcion15(registros.getString("rdescripcion15"));
       emp.setrDescripcion16(registros.getString("rdescripcion16"));
       emp.setrDescripcion17(registros.getString("rdescripcion17"));
       emp.setrDescripcion18(registros.getString("rdescripcion18"));
       emp.setrDescripcion19(registros.getString("rdescripcion19"));
       emp.setrDescripcion20(registros.getString("rdescripcion20"));
       emp.setrPrecio(registros.getFloat("rprecio"));
       emp.setrPrecio2(registros.getFloat("rprecio2"));
       emp.setrPrecio3(registros.getFloat("rprecio3"));
       emp.setrPrecio4(registros.getFloat("rprecio4"));
       emp.setrPrecio5(registros.getFloat("rprecio5"));
       emp.setrPrecio6(registros.getFloat("rprecio6"));
       emp.setrPrecio7(registros.getFloat("rprecio7"));
       emp.setrPrecio8(registros.getFloat("rprecio8"));
       emp.setrPrecio9(registros.getFloat("rprecio9"));
       emp.setrPrecio10(registros.getFloat("rprecio10"));
       emp.setrPrecio11(registros.getFloat("rprecio11"));
       emp.setrPrecio12(registros.getFloat("rprecio12"));
       emp.setrPrecio13(registros.getFloat("rprecio13"));
       emp.setrPrecio14(registros.getFloat("rprecio14"));
       emp.setrPrecio15(registros.getFloat("rprecio15"));
       emp.setrPrecio16(registros.getFloat("rprecio16"));
       emp.setrPrecio17(registros.getFloat("rprecio17"));
       emp.setrPrecio18(registros.getFloat("rprecio18"));
       emp.setrPrecio19(registros.getFloat("rprecio19"));
       emp.setrPrecio20(registros.getFloat("rprecio20"));
       emp.setrSubtotal(registros.getFloat("rsubtotal"));
       emp.setrIva(registros.getFloat("riva"));
       emp.setrTotal(registros.getFloat("rtotal"));
       emp.setrGarantia(registros.getString("rgarantia"));
       emp.setrObservaciones(registros.getString("robservaciones"));
    }
    
    }catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage() ); }
     this.desconectar();
     
    return emp;
}

//consultar id
public Notaremision consultaid (){
    Notaremision emp =null;
    registros=null; 
    
    try{
        
        this.conectar();
        this.sqlConsulta = "SELECT MAX(folio) FROM notaremision";        
        PreparedStatement consulta = conexion.prepareStatement(this.sqlConsulta);
        registros=consulta.executeQuery();
    
    if(registros.first()==false){
        
        System.out.println("No hay registros");
        
    }    
    else{
         emp = new Notaremision();
       
      
       emp.setFolio(registros.getInt("MAX(folio)") + 1);
       
       
    }
    
    }catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage() ); }
     this.desconectar();
     
    return emp;
}

public Notaremision consultaidprueba (int folio){
    Notaremision emp =null;
    registros=null; 
    int id = 1;
    try{
        ResultSet rs =null;
        this.conectar();
this.sqlConsulta = "SELECT MAX(folio) FROM notaremision";        
        PreparedStatement consulta = conexion.prepareStatement(this.sqlConsulta);
        
        registros=consulta.executeQuery();
    
        while(rs.next()){
            id =rs.getInt(1) + 1;
        }
    
    
    }catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage() ); }
     this.desconectar();
     
    return emp;
}

//INSERTAR DATOS DE NOTAS DE REMISIÓN A LA TABLA DE CLIENTES

public boolean insertartablanotaremision(Notaremision emp, Cliente cot){  
    boolean exito = true;

    
    if (this.conectar() == true ){
    
    try{
        
        sqlConsulta = "insert into t_cliente values (?,null,?,?,?)";
         PreparedStatement insertar = conexion.prepareStatement(sqlConsulta);
         insertar.setString(1, cot.getTelefonoCliente() );
         insertar.setString(2, emp.getrDescripcion() );
         insertar.setString(3, emp.getrModelo() );
         insertar.setFloat(4, emp.getrTotal() );
         insertar.executeUpdate();
    }catch(SQLException e) {
        
        System.out.println("Error al insertar" +e.getMessage() );
        exito = false;
        
    }
    this.desconectar();
    }

else {
    
    exito = false;
    
    }
         
   return exito;
}    
}