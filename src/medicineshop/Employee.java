public class Employee package medicineshop;

public abstract class Employee extends Person {
    private int employeeId;
    private double salary;
    private String shift;
    
    public Employee(String name, int age, String contactNumber, int employeeId, double salary, String shift) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.salary = salary;
        this.shift = shift;
    }
    
    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getShift() {
        return shift;
    }
    
    public void setShift(String shift) {
        this.shift = shift;
    }
    
    // Abstract method
    public abstract double calculateMonthlyIncome();
    
    @Override
    public void displayRole() {
        System.out.println("Employee ID: " + this.employeeId + ", Shift: " + this.shift);
    }
}
    
}
