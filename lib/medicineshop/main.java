package medicineshop;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== MEDICINE SHOP AUTOMATION SYSTEM ===");
        System.out.println("======================================\n");
        
        es (Concrete class implementing interfaces)
        Medicine paracetamol = new Medicine("M001", "Paracetamol", "PharmaCorp", 2.50, 
                                           100, "2025-12-31", false);
        Medicine antibiotic = new Medicine("M002", "Amoxicillin", "MediLife", 5.75, 
                                          50, "2024-06-30", true);
        Medicine vitamin = new Medicine("M003", "Vitamin C", "HealthPlus", 8.00, 
                                       200, "2026-03-15", false);
        Medicine insulin = new Medicine("M004", "Insulin", "DiabeCare", 25.00, 
                                       30, "2024-01-15", true);
        
        // Create Employees
        Pharmacist pharmacist = new Pharmacist("Dr. Sarah Wilson", 35, "9876543210", 
                                               101, 5000, "Morning", 
                                               "LIC12345", "General Medicine", 8);
        
        Cashier cashier = new Cashier("John Doe", 28, "9123456789", 
                                      201, 3000, "Evening", 3);
        
        // Create Customers
        Customer customer1 = new Customer("Alice Brown", 45, "9988776655", 
                                         "C1001", "Diabetes", true);
        Customer customer2 = new Customer("Bob Smith", 30, "9876543210", 
                                         "C1002", "None", false);
        
        // Display all persons (Polymorphism)
        System.out.println("--- PERSONS IN SYSTEM ---");
        Person[] persons = {pharmacist, cashier, customer1, customer2};
        for (Person person : persons) {
            person.introduce();
            person.displayRole();
            System.out.println();
        }
        
        // Demonstrate Medicine operations
        System.out.println("\n--- MEDICINE INVENTORY ---");
        Medicine[] medicines = {paracetamol, antibiotic, vitamin, insulin};
        for (Medicine medicine : medicines) {
            medicine.displayMedicineInfo();
        }
        
        // Demonstrate Stock Management (Interface)
        System.out.println("\n--- STOCK MANAGEMENT ---");
        paracetamol.addStock(50);
        antibiotic.removeStock(10);
        
        // Check expiry dates
        System.out.println("\n--- EXPIRY CHECK ---");
        for (Medicine medicine : medicines) {
            medicine.checkExpiry();
        }
        
        // Demonstrate Pharmacy operations
        System.out.println("\n--- PHARMACY OPERATIONS ---");
        
        // Customer1 requests medicine (with insurance, diabetic)
        System.out.println("\n[Transaction 1]");
        customer1.requestMedicine(pharmacist, insulin, 2, true);
        customer1.addPurchase("Insulin", 2, insulin.calculatePrice(2));
        
        // Customer2 requests medicine (without prescription for antibiotic)
        System.out.println("\n[Transaction 2]");
        customer2.requestMedicine(pharmacist, antibiotic, 5, false);
        
        // Customer2 tries with prescription this time
        System.out.println("\n[Transaction 3]");
        customer2.requestMedicine(pharmacist, antibiotic, 5, true);
        customer2.addPurchase("Amoxicillin", 5, antibiotic.calculatePrice(5));
        
        // Cashier processes payment for customer2
        System.out.println("\n[Payment Processing]");
        cashier.processPayment(antibiotic, 5, 30.00);
        
        // More transactions
        System.out.println("\n[Transaction 4]");
        cashier.processPayment(vitamin, 3, 25.00);
        customer2.addPurchase("Vitamin C", 3, vitamin.calculatePrice(3));
        
        // Check medicine availability
        System.out.println("\n--- AVAILABILITY CHECK ---");
        System.out.println("Paracetamol (30 units): " + 
                          (paracetamol.checkAvailability(30) ? "Available" : "Not Available"));
        System.out.println("Insulin (20 units): " + 
                          (insulin.checkAvailability(20) ? "Available" : "Not Available"));
        
        // Demonstrate encapsulation (getters/setters)
        System.out.println("\n--- ENCAPSULATION DEMO ---");
        System.out.println("Original Paracetamol price: $" + paracetamol.getPricePerUnit());
        paracetamol.setPricePerUnit(3.00);
        System.out.println("Updated Paracetamol price: $" + paracetamol.getPricePerUnit());
        
        // Show reports
        System.out.println("\n--- REPORTS ---");
        
        // Customer purchase history
        customer1.showPurchaseHistory();
        customer2.showPurchaseHistory();
        
        // Cashier daily report
        cashier.printDailyReport();
        
        // Pharmacist stock check
        System.out.println("\n--- PHARMACIST STOCK CHECK ---");
        pharmacist.checkMedicineStock(antibiotic);
        
        // Demonstrate bonus calculation (method overriding)
        System.out.println("\n--- INCOME CALCULATION ---");
        System.out.println("Pharmacist " + pharmacist.getName() + 
                          " monthly income: $" + String.format("%.2f", pharmacist.calculateMonthlyIncome()));
        System.out.println("Cashier " + cashier.getName() + 
                          " monthly income: $" + String.format("%.2f", cashier.calculateMonthlyIncome()));
        
        System.out.println("\n======================================");
        System.out.println("=== SYSTEM DEMONSTRATION COMPLETE ===");
        System.out.println("======================================");
    }
}
