/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;
import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class editar {
    
     public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    int id_editar=2;
    String new_nombre = "david";
    String new_edad = "parra";
    String new_direccion = "29";
    String new_telefono = "1234567890";
    String sql = "UPDATE personas set nombre='"+new_nombre+"',edad='"+new_edad+"',direccion='"+new_direccion+"',telefono='"+new_telefono+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM personas ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("edad")+"-"+rs.getString("direccion")+"-"+rs.getString("telefono"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
    

