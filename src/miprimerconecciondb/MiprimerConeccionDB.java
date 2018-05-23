/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerconecciondb;
import java.sql.Connection;
import java.sql.DriverManager;
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
        String cadenaConexion = "jbc:mysql://localhost:3306/personadb";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "usuario");
            
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO persona (nombre, apellido, edad)" +
                                    "VALUES('Rodolfo', 'Miramar', '25')");
                                    sentencia.close();
                                    conexion.close();
                                               
        
        }
        catch(SQLException ex){
        
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        
    }
    
}
