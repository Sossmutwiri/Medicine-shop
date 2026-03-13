public class Person package medicineshop;

public abstract class Person {
    private String name;
    private int age;
    private String contactNumber;
    
    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }
    
    // Getters and Setters (Encapsulation)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    // Abstract method
    public abstract void displayRole();
    
    // Concrete method
    public void introduce() {
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", Contact: " + this.contactNumber);
    }
}
    
}
