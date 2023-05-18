package Main;

import java.time.LocalDate;

public abstract class Employee extends User{
    protected float salary;
    protected String department;
    protected float workHour;
    protected LocalDate appointmentDate;
    protected String post;

    public Employee(String name, int id, String user_type, String email, String password, LocalDate BoD, float salary,
            String department, float workHour, LocalDate appointmentDate, String post) {
        super(name, id, user_type, email, password, BoD);
        this.salary = salary;
        this.department = department;
        this.workHour = workHour;
        this.appointmentDate = appointmentDate;
        this.post = post;
    }

    @Override
    public abstract void addUser();

    @Override
    public String toString() {
        return "Employee{Name: " + name +  "\nID: " + id + "\nUser type: " + user_type + "\nPassword=" + password 
                + "\nEmail: " + email + "\nBirth of Date: " + BoD + "\n" + "Salary: " + salary + "\nDepartment=" + department +
                "\nWorkHour=" + workHour + "\nAppointmentDate=" + appointmentDate + "\nPost=" + post + "\n";
    }

    
    
}
