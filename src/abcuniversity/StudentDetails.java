/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcuniversity;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sumi
 */
public class StudentDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAME = {"Reg ID", "First Name", "Last Name", "Faculty", "Department"};
    private static ArrayList<Student> list;

    StudentDetails(ArrayList<Student> stList) {
        list = stList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    public String getColumnName(int columnIndex){
        return COLUMN_NAME[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){    
            case 0:
                return list.get(rowIndex).getRegID();
            case 1:
                return list.get(rowIndex).getFirstName();
            case 2:
                return list.get(rowIndex).getLastName();
            case 3:
                return list.get(rowIndex).getFaculty();
            case 4:
                return list.get(rowIndex).getDepartment();
            default:
                return "error";
        }
    }
    
}
