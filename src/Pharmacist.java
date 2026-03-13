public class Pharmacist {
    package medicineshop;

public class Pharmacist extends Employee {
    private String licenseNumber;
    private String specialization;
    private int yearsOfExperience;
    
    public Pharmacist(String name, int age, String contactNumber, int employeeId, 
                      double salary, String shift, String licenseNumber, 
                      String specialization, int yearsOfExperience) {
        super(name, age, contactNumber, employeeId, salary, shift);
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Getters and Setters
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    @Override
    public double calculateMonthlyIncome() {
        double baseSalary = super.getSalary();
        double experienceBonus = baseSalary * 0.05 * this.yearsOfExperience;
        return baseSalary + experienceBonus;
    }
    
    public void dispenseMedicine(Medicine medicine, int quantity, boolean hasPrescription) {
        if (medicine.isRequiresPrescription() && !hasPrescription) {
            System.out.println("Cannot dispense " + medicine.getName() + " without prescription!");
        } else if (medicine.checkAvailability(quantity)) {
            System.out.println("Pharmacist " + super.getName() + " is dispensing " + quantity + 
                             " units of " + medicine.getName());
            medicine.sell(quantity);
        } else {
            System.out.println("Insufficient stock for " + medicine.getName());
        }
    }
    
    public void checkMedicineStock(Medicine medicine) {
        System.out.println("Stock check by Pharmacist " + super.getName() + ":");
        medicine.displayMedicineInfo();
        medicine.checkExpiry();
    }
    
    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Pharmacist: " + super.getName() + " | License: " + this.licenseNumber + 
                          " | Specialization: " + this.specialization + " | Experience: " + 
                          this.yearsOfExperience + " years");
    }
}

public Pharmacist() {
}
}
