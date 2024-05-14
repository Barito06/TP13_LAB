package tp13_lab;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class TP13_LAB {

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("org.mariadb.jdbc.Driver");
            String bd = "jdbc:mariadb://localhost:3306/universidadULP";
            String usuario = "root";
            String password = "";
            Connection con = DriverManager.getConnection(bd, usuario, password);
            
            
            String sql = "DELETE FROM inscripcion WHERE idInscripto = 6";
            PreparedStatement ps = con.prepareStatement(sql);
            int registro = ps.executeUpdate();
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado");
            }
//            
            
//            String sql = " SELECT * FROM alumno JOIN inscripcion ON (alumno.idAlumno = inscripcion.idAlumno) WHERE nota > 8 ";
//            
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet resultado = ps.executeQuery(); 
//            while (resultado.next()){  // next es un puntero boolenao
//            System.out.println("idAlumno: "+ resultado.getInt("idAlumno"));
//            System.out.println("dni: "+ resultado.getInt("dni"));
//            System.out.println("apellido: "+ resultado.getString("apellido"));
//            System.out.println("nombre: "+ resultado.getString("nombre"));
//            System.out.println("fechaDeNacimiento: "+ resultado.getDate("fechaNacimiento"));
//            System.out.println("estado: "+ resultado.getBoolean("estado"));
//            }
            
            
            
            
//            String sql = "INSERT INTO "
//                    + "inscripcion(nota, idAlumno, idMateria) "
//                    + "VALUES (2, 3, 1),"
//                    +"(8, 3, 2),"
//                    +"(3, 4, 2),"
//                    +"(10, 4, 3),"
//                    +"(8, 2, 2),"
//                    +"(4, 2 , 1)";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                
//                JOptionPane.showMessageDialog(null, "Inscripcion correcta");
//
//            }
            
//            String sql = "INSERT INTO "
//                    + "materia(nombre, año, estado) "
//                    + "VALUES ('EDA', 2024, true),"
//                    +"('LAB', 2024, true),"
//                    +"('WEB I', 2024 , true)";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                
//                JOptionPane.showMessageDialog(null, "Materia agregada");
//
//            }
            
//            String sql = "INSERT INTO "
//                    + "alumno(dni, apellido, nombre, fechaNacimiento, estado) "
//                    + "VALUES (37595485,'Joaquin','Calderon','1996-07-07',true),"
//                    +"(43728390, 'Damian' , 'Luna' , '2000-05-27', true),"
//                    + "(44634543, 'Victoria' , 'Rocamora' , '2006-08-24', true)";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                
//                JOptionPane.showMessageDialog(null, "Alumno Agregado");
//
//            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargard driver");
        } catch (SQLException ex) {
            int codigoE = ex.getErrorCode();
            if (codigoE == 1062) {
                JOptionPane.showMessageDialog(null, "Entrada Duplicada");
            } else if (codigoE == 1049) {
                JOptionPane.showMessageDialog(null, "BD Desconocida");
            } else {
                JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            }

            ex.printStackTrace();
            System.out.println("codigo de error " + ex.getErrorCode());
        }
    }

}
