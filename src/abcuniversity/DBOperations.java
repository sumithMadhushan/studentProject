/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcuniversity;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sumi
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost:3306/abcuniversity";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean addStudent(Student s) {//insert student data into the database
        try {
            System.out.println("p1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO studentdetails VALUES (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("p2");
            pst.setInt(1, s.getRegID());
            pst.setString(2, s.getFirstName());
            pst.setString(3, s.getLastName());
            pst.setInt(4, s.getAge());
            pst.setString(5, s.getAddress());
            pst.setString(6, s.getGender());
            pst.setString(7, s.getFaculty());
            pst.setString(8, s.getDepartment());
            pst.setInt(9, s.getYearOfReg());
            System.out.println("p3");
            
            pst.executeUpdate();
            
            System.out.println("p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    ArrayList<Student> getStudent(){//get the student details from the database
        try{
            
            ArrayList<Student> list = new ArrayList<Student>();
            
            System.out.println("get student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM studentdetails";
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("get student 2");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                Student s = new Student();
                s.setRegID(rs.getInt(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setAge(rs.getInt(4));
                s.setAddress(rs.getString(5));
                s.setGender(rs.getString(6));
                s.setFaculty(rs.getString(7));
                s.setDepartment(rs.getString(8));
                s.setYearOfReg(rs.getInt(9));
                list.add(s);
            }
            return list;
            
            
        }catch (Exception e) {
            System.out.println("exception --->" + e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public boolean updateStudent(Student s){//update the studentdetails table 
        try{
            System.out.println("update student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE studentdetails SET firstName='"+s.getFirstName()+"',lastName='"+s.getLastName() +"',age="+s.getAge() +",address = '"+ s.getAddress()+"',gender = '"+s.getGender()+"',faculty='"+s.getFaculty()+"',department ='"+s.getDepartment()+"',yearofreg="+s.getYearOfReg()+" WHERE regID="+s.getRegID();
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("update student 2");
            
            pst.executeUpdate();
            
            System.out.println("update student 3");
        
            return true;
        }catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public boolean deleteStudent(Student s){
        try{
            System.out.println("delete student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM studentdetails WHERE regid="+s.getRegID();
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("delete student 2");
            
            pst.executeUpdate();
            
            System.out.println("delete student 3");
        
            return true;
        }catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    
    }

}
