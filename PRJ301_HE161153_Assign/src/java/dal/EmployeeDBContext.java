/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Employee;
import Model.RequestForLeave;
import Model.TimeSheet;
import helper.DateTimeHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieut
 */
public class EmployeeDBContext extends DBContext {

    public ArrayList<Employee> getEmployees(String begin, String end) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.ename,e.type,t.[co-salary],t.tid,t.checkin\n"
                    + "                                        FROM Employee e\n"
                    + "                                        	LEFT JOIN (SELECT * FROM Timesheet WHERE \n"
                    + "                                        	checkin >= ?\n"
                    + "                                        	AND\n"
                    + "                                       	checkin <=?) t \n"
                    + "                                        	ON e.eid = t.eid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, begin);
            stm.setString(2, end);
            ResultSet rs = stm.executeQuery();
            Employee curEmp = new Employee();
            curEmp.setId(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                String type= rs.getString("type");
                if (eid != curEmp.getId()) {
                    curEmp = new Employee();
                    curEmp.setId(eid);
                    curEmp.setType(type);
                    curEmp.setName(rs.getString("ename"));
                    employees.add(curEmp);
                }
                int tid = rs.getInt("tid");
                float cosalary = rs.getFloat(4);  
                TimeSheet t = new TimeSheet();
                t.setEmployee(curEmp);
                t.setId(tid);
                t.setCosalary(cosalary);
                t.setCheckin(rs.getDate(6));
                employees.get(employees.size()-1).getTimesheets().add(t);
//              employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
//        RequestForLeave leave = new RequestForLeave();
//        leave.setId(1);
//        leave.setReason(1);
//        leave.setEmployee(employees.get(1));
//        Date d = new Date();
//        d = DateTimeHelper.removeTime(d);
//        leave.setFrom(DateTimeHelper.addDays(d, 3));
//        leave.setTo(DateTimeHelper.addDays(d, 5));
//        employees.get(1).getLeaves().add(leave);
        return employees;
    }
    public static void main(String[] args) {
        EmployeeDBContext e = new EmployeeDBContext();
         ArrayList<Employee> employees = e.getEmployees("2016-01-01", "2016-01-31");
         for (Employee list : employees) {
             ArrayList<TimeSheet> t =list.getTimesheets();
             for (TimeSheet t1 : t) {
                 System.out.println(t1.getCheckin());
             }
        }
    }
}
