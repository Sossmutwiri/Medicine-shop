public class Customer package medicineshop;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {
    private String customerId;
    private String medicalHistory;
    private double totalSpent;
    private Map<String, Integer> purchaseHistory;
    private boolean hasInsurance;
    
    public Customer(String name, int age, String contactNumber, String customerId, 
                    String medicalHistory, boolean hasInsurance) {
        super(name, age, contactNumber);
        this.customerId = customerId;
        this.medicalHistory = medicalHistory;
        this.hasInsurance = hasInsurance;
        this.totalSpent = 0.0;
        this.purchaseHistory = new HashMap<>();
    }
    
    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public String getMedicalHistory() {
        return medicalHistory;
    }
    
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    public double getTotalSpent() {
        return totalSpent;
    }
    
    public boolean isHasInsurance() {
        return hasInsurance;
    }
    
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
    
    public void addPurchase(String medicineName, int quantity, double amount) {
        purchaseHistory.put(medicineName, purchaseHistory.getOrDefault(medicineName, 0) + quantity);
        this.totalSpent += amount;
    }
    
    public void requestMedicine(Pharmacist pharmacist, Medicine medicine, int quantity, boolean hasPrescription) {
        System.out.println("Customer " + super.getName() + " is requesting " + quantity + 
                          " units of " + medicine.getName());
        pharmacist.dispenseMedicine(medicine, quantity, hasPrescription && this.hasPrescriptionFor(medicine));
    }
    
    private boolean hasPrescriptionFor(Medicine medicine) {
        // Simplified: In real system, would check actual prescriptions
        return this.medicalHistory.toLowerCase().contains(medicine.getName().toLowerCase());
    }
    
    public void showPurchaseHistory() {
        System.out.println("\n=== Purchase History for " + super.getName() + " (ID: " + this.customerId + ") ===");
        if (purchaseHistory.isEmpty()) {
            System.out.println("No purchases yet.");
        } else {
            for (Map.Entry<String, Integer> entry : purchaseHistory.entrySet()) {
                System.out.println("Medicine: " + entry.getKey() + " | Quantity: " + entry.getValue());
            }
            System.out.println("Total Spent: $" + String.format("%.2f", this.totalSpent));
        }
    }
    
    @Override
    public void displayRole() {
        System.out.println("Customer: " + super.getName() + " | ID: " + this.customerId + 
                          " | Insurance: " + (this.hasInsurance ? "Yes" : "No") + 
                          " | Medical History: " + this.medicalHistory);
    }
}
    
}
