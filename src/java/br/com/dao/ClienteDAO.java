/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.bean.Cliente;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author carlo
 */
public class ClienteDAO {
    
    public static Connection getConnection(){
        
        Connection con = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD", "root", "");
            
            
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return con;
    }
    
    public static int salvarCliente(Cliente u){
        
        int status = 0;
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO cliente (nome, cpf) VALUES (?,?)");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            status = ps.executeUpdate();
            System.out.println("Funcionou");
        }catch(SQLException e){
            
            System.out.println(e);
        }
        return status;
    }
    
}
