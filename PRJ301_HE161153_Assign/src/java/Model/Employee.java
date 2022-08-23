package Model;

import java.util.ArrayList;

public class Employee {

    private int id;
    private String name;
    private String type;
    private ArrayList<TimeSheet> timesheets = new ArrayList<>();
    private ArrayList<RequestForLeave> leaves = new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public float getSumCoSalary() {
        float sum = 0;
        for (TimeSheet t : timesheets) {
            sum += t.getCosalary();
        }
        return sum;
    }

    public int getSumX() {
        int sum = 0;
        for (TimeSheet t : timesheets) {
            if (t.getCosalary() == 1) {
                sum++;
            }
        }
        return sum;
    }

    public int getSumX2() {
        int sum = 0;
        for (TimeSheet t : timesheets) {
            if (t.getCosalary() == 0.5) {
                sum++;
            }
        }
        return sum;
    }

    public int getSumNO() {
        int sum = 0;
        for (TimeSheet t : timesheets) {
            if (t.getCosalary() == 0) {
                sum++;
            }
        }
        return sum;
    }

    public ArrayList<RequestForLeave> getLeaves() {
        return leaves;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalLeaves() {
        int sum = 0;
        for (RequestForLeave leave : leaves) {
            sum += leave.getTotalDays();
        }
        return sum;
    }

    public void setLeaves(ArrayList<RequestForLeave> leaves) {
        this.leaves = leaves;
    }

    public int getNumberOfWorkingDays() {
        return timesheets.size();
    }

    public ArrayList<TimeSheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(ArrayList<TimeSheet> timesheets) {
        this.timesheets = timesheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
