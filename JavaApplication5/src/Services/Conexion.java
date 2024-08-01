/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class Conexion {
    Connection con;
    
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://b8qgg5rn1bhdqr0k8zbn-mysql.services.clever-cloud.com:3306/b8qgg5rn1bhdqr0k8zbn", "uytd2atmcjzspag4", "IoA23EFxGMUjdiYRihDr");
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace();  // Imprimir el stack trace del error
        }
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from Departamento");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("user") + " " + rs.getString("dni"));
            }
            cn.con.close();
        } catch (Exception e) {
            System.err.println("error: " + e);
            e.printStackTrace();  // Imprimir el stack trace del error
        }
    }
}


