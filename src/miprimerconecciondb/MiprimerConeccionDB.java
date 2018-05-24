/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerconecciondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author generation
 */
public class MiprimerConeccionDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost:3306/personasdb?useSSL=false";                       //aqui se declara la conexion en local el puerto y la schema
        String usuario = "root";
        String contraseña = "usuario";                                                            //declaramos el usuario y contraseña en variables y tambien el query para insertar y no escribir denuevo todo
        
        //Query
        String insertaPersona = "INSERT INTO persona" + "(nombre, apellidos, edad)VALUES ('2Pac', 'Motherfucking', '32')";        
        String eliminaPersona = "DELETE FROM persona WHERE persona_id = 1";
        String updatePersona = "UPDATE persona SET nombre = 'juanito',"+ "apellido = 'sola', edad = '60' WHERE persona_is = 2";
        String leerPersona = "SELECT * FROM persona;";
        
        
        try{
           //Class.forName("com.mysql.jdbc.Driver");
            
                                                                                                     //para crear la conexion se envia por parametros la cadena de conexion
                                                                                                     //que fue declarada antes, el usuario y la cotraseña de usuario
             Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
                                                                                                   
                                                                                                   
            Statement sentencia = conexion.createStatement();           
            
   
           
           // sentencia.executeUpdate(insertaPersona);                                                   //inserta una persona
           // sentencia.executeUpdate(eliminaPersona);
            ResultSet  resultadoLectura = sentencia.executeQuery(leerPersona);                          //executeQuery recibe una string de sql de DDL                                                     
                                  
                                    
            while(resultadoLectura.next()){                                                            //
            
                System.out.println("id: " + resultadoLectura.getInt(1));
                System.out.println("nombre: " + resultadoLectura.getString(2));
                System.out.println("apellido: " + resultadoLectura.getString(3));
                System.out.println("edad: " + resultadoLectura.getInt(4));
                
            }
            
            
                                     sentencia.close();                                                  //el resultado se guarda enResultSet que es un objeto como un array de data base se necesita agregar la libreria
                                     conexion.close();
                                               
        
        }
        catch(SQLException ex){
        
            ex.printStackTrace();
        }
        //catch(ClassNotFoundException ex){
          //  ex.printStackTrace();
        //}
        
        
    }
    
}
