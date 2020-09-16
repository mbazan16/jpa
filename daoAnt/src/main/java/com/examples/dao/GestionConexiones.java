package com.examples.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GestionConexiones {
	

   

    public static Connection getConexion() throws Throwable {
        Class.forName("oracle.jdbc.OracleDriver").newInstance();

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
        return con;
    }

    
    
    

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Throwable e) {
                rs = null;
            }
        }
    }

    public static void close(PreparedStatement pst) {

        if (pst != null) {
            try {
                pst.close();
            } catch (Throwable e) {
                pst = null;
            }
        }
    }

    public static void close(Connection con) {

        if (con != null) {
            try {
                con.close();
            } catch (Throwable e) {
                con = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement pst) {

        close(rs);
        close(pst);
    }

    public static void close(PreparedStatement pst, Connection con) {

        close(pst);
        close(con);

    }

    public static void close(ResultSet rs, PreparedStatement pst, Connection con) {

        close(rs);
        close(pst);
        close(con);
    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (Exception e) {
        }
    }

    public static void commit(Connection con) {
        try {
            con.commit();
        } catch (Exception e) {
        }
    }
    
 public static void main( String args[] ) {
     try{
     Class.forName("oracle.jdbc.OracleDriver").newInstance();

     Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
      if(con!=null) System.out.println(con);
     PreparedStatement pst= con.prepareStatement("select * from departments");
     System.out.println(pst);
     ResultSet rs= pst.executeQuery();
     System.out.println(rs);
    close(rs,pst,con);

     }catch(Exception e){
         e.printStackTrace(System.out);

     }

         }
    

}
