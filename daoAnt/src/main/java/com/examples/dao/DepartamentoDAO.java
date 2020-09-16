package com.examples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.examples.model.Departamento;

public class DepartamentoDAO {

	
	public Departamento find(Long id) {
		
		Connection con=null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        Departamento departamento=null;
        String query;

        try {
           
            con = GestionConexiones.getConexion();

                       
            query = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";

            System.out.println(query);

            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();


            if (rs.next()) {
                departamento = new Departamento();
                departamento.setId(rs.getLong("DEPARTMENT_ID"));
                departamento.setName(rs.getString("DEPARTAMENT_NAME"));
                departamento.setManagerId(rs.getLong("MANAGER_ID"));
                departamento.setLocationId(rs.getLong("LOCATION_ID"));
            } else {
            	System.out.println("NO SE ENCUENTRA EL ELEMENTO");
                //throw new DAOException(CExceptions.EXCEPCION_TIPO_CONSULTA, CExceptions.EXCEPCION_MENSAJE_NO_ENCONTRADO);
            }

            if (rs.next()) {
            	System.out.println("HAY MAS DE UN RESULTADO");
                //throw new DAOException(CExceptions.EXCEPCION_TIPO_CONSULTA, CExceptions.EXCEPCION_MENSAJE_NO_UNICO_ELEMENTO);

            }
            return departamento;
                
        //} catch (DAOException de) {
            //throw new DAOException(de.getTipo(), de.getMessage());
       // } 
        }catch (SQLException sqle) {
        	System.out.println("ERROR SQL");
        	sqle.printStackTrace();
           // throw new DAOException(CExceptions.EXCEPCION_TIPO_SQL, sqle.getMessage());
        } catch (Throwable te) {

        	te.printStackTrace();
        	System.out.println("ERROR GENERAL");
            //throw new DAOException(CExceptions.EXCEPCION_MENSAJE_EXCEPCION_GENERAL, CExceptions.PREFIJO_DAO.concat(te.toString()));
        } finally {
            GestionConexiones.close(rs, ps,con);
        }
        return departamento;
        
	}
	
	public void crear(Departamento departamento) {
		Connection con=null;
		PreparedStatement ps = null;
        String query;

        try {
            

        	con = GestionConexiones.getConexion();
        	
             query=" INSERT INTO DEPARTMENTS" + 
             		" (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) " + 
             		" VALUES(?,?,?,?)";

           System.out.println(query);
            

            ps = con.prepareStatement(query);
            


            ps.setLong(1, departamento.getId());
            ps.setString(2, departamento.getName());
            ps.setLong(3, departamento.getManagerId());
            ps.setLong(4, departamento.getLocationId());
            
            int j = ps.executeUpdate();

            if (j == 0) {
               // throw new DAOException(CExceptions.EXCEPCION_TIPO_CONSULTA, CExceptions.EXCEPCION_MENSAJE_NO_ENCONTRADO);
               System.out.println("NO SE HA REALIZADO NINGUNA INSERCION");
            }
             if (j > 1)
            	 System.out.println("SE HA CREADO MAS DE UN REGISTRO");
        }catch (SQLException sqle) {
        	System.out.println("ERROR SQL");
        	sqle.printStackTrace();
           // throw new DAOException(CExceptions.EXCEPCION_TIPO_SQL, sqle.getMessage());
        } catch (Throwable te) {

        	te.printStackTrace();
        	System.out.println("ERROR GENERAL");
            //throw new DAOException(CExceptions.EXCEPCION_MENSAJE_EXCEPCION_GENERAL, CExceptions.PREFIJO_DAO.concat(te.toString()));
        } finally {
            GestionConexiones.close(ps,con);
        }
	}
	
	public void grabar(Long id, String name, Long managerId, Long locationId) {
		
		Connection con=null;
		PreparedStatement ps = null;
        String query;

        try {
            

        	con = GestionConexiones.getConexion();
        	
             query=" UPDATE DEPARTMENTS" + 
             		"  SET" + 
             		" DEPARTMENT_NAME=?," + 
             		" MANAGER_ID=?," + 
             		" LOCATION_ID=?" +
             		" WHERE DEPARTMENT_ID=?";

           System.out.println(query);

            ps = con.prepareStatement(query);
            
            ps.setString(1, name);
            ps.setLong(2, managerId);
            ps.setLong(3, locationId);
            ps.setLong(4, id);
            
            int j = ps.executeUpdate();

            if (j == 0) {
               // throw new DAOException(CExceptions.EXCEPCION_TIPO_CONSULTA, CExceptions.EXCEPCION_MENSAJE_NO_ENCONTRADO);
               System.out.println("NO SE HA REALIZADO NINGUNA MODIFICACION");
            }
             if (j > 1)
            	 System.out.println("SE HA MODIFICADO MAS DE UN REGISTRO");
        }catch (SQLException sqle) {
        	System.out.println("ERROR SQL");
        	sqle.printStackTrace();
           // throw new DAOException(CExceptions.EXCEPCION_TIPO_SQL, sqle.getMessage());
        } catch (Throwable te) {
        	System.out.println("ERROR GENERAL");
        	te.printStackTrace();
            //throw new DAOException(CExceptions.EXCEPCION_MENSAJE_EXCEPCION_GENERAL, CExceptions.PREFIJO_DAO.concat(te.toString()));
        } finally {
            GestionConexiones.close(ps,con);
        }
	}
	
	public void delete(Long id) {
		
		Connection con=null;
		PreparedStatement ps = null;
        String query;

        try {
            

        	con = GestionConexiones.getConexion();
        	
             query="DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";

           System.out.println(query);

            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            int j = ps.executeUpdate();

            if (j == 0) {
               // throw new DAOException(CExceptions.EXCEPCION_TIPO_CONSULTA, CExceptions.EXCEPCION_MENSAJE_NO_ENCONTRADO);
               System.out.println("NO SE HA REALIZADO NINGUNA ELIMINACION");
            }
             if (j > 1)
            	 System.out.println("SE HA ELIMINADO MAS DE UN REGISTRO");
        }catch (SQLException sqle) {
        	System.out.println("ERROR SQL");
        	sqle.printStackTrace();
           // throw new DAOException(CExceptions.EXCEPCION_TIPO_SQL, sqle.getMessage());
        } catch (Throwable te) {

        	te.printStackTrace();
        	System.out.println("ERROR GENERAL");
            //throw new DAOException(CExceptions.EXCEPCION_MENSAJE_EXCEPCION_GENERAL, CExceptions.PREFIJO_DAO.concat(te.toString()));
        } finally {
            GestionConexiones.close(ps,con);
        }
		
	}

	

}
