/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import helper.DateTimeHelper;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeSheet {
    private int id;
    private Employee employee;
    private Date checkin;  
    private float cosalary;
 
    public float getCosalary() {
        return cosalary;
    }

    public void setCosalary(float cosalary) {
        this.cosalary = cosalary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCheckin() {
        return DateTimeHelper.removeTime(checkin);
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }
}
