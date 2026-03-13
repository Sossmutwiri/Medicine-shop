public class Cashier package medicineshop;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Employee {
    private int counterNumber;
    private double dailySales;
    private List<String> transactions;
    
    public Cashier(String name, int age, String contactNumber, int employeeId, 
                   double salary, String shift, int counterNumber) {
        super(name, age, contactNumber, employeeId, salary, shift);
        this.counterNumber = counterNumber;
        this.dailySales = 0.0;
        this.transactions = new ArrayList<>();
    }
    
    // Getters and Setters
    public int getCounterNumber() {
        return counterNumber;
    }
    
    public void setCounterNumber(int counterNumber) {
        this.counterNumber = counterNumber;
    }
    
    public double getDailySales() {
        return dailySales;
    }
    
    public List<String> getTransactions() {
        return transactions;
    }
    
    @Override
    public double calculateMonthlyIncome() {
        double baseSalary = super.getSalary();
        double salesCommission = this.dailySales * 0.02; // 2% commission on daily sales
        return baseSalary + salesCommission;
    }
    
    public void processPayment(Medicine medicine, int quantity, double amountPaid) {
        double totalPrice = medicine.calculatePrice(quantity);
        
        if (amountPaid >= totalPrice) {
            double change = amountPaid - totalPrice;
            medicine.sell(quantity);
            this.dailySales += totalPrice;
            
            String transaction = String.format("Transaction: %s x%d - $%.2f (Paid: $%.2f, Change: $%.2f)", 
                                              medicine.getName(), quantity, totalPrice, amountPaid, change);
            transactions.add(transaction);
            
            System.out.println("Payment processed by Cashier " + super.getName() + " at Counter #" + this.counterNumber);
            System.out.println("Total: $" + totalPrice + " | Paid: $" + amountPaid + " | Change: $" + change);
        } else {
            System.out.println("Insufficient payment! Required: $" + totalPrice + ", Paid: $" + amountPaid);
        }
    }
    
    public void printDailyReport() {
        System.out.println("\n=== Daily Sales Report - Cashier: " + super.getName() + " ===");
        System.out.println("Counter #: " + this.counterNumber);
        System.out.println("Total Transactions: " + this.transactions.size());
        
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        
        System.out.println("Total Daily Sales: $" + String.format("%.2f", this.dailySales));
        System.out.println("Monthly Income (with commission): $" + 
                          String.format("%.2f", this.calculateMonthlyIncome()));
    }
    
    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Cashier: " + super.getName() + " | Counter #" + this.counterNumber + 
                          " | Today's Sales: $" + String.format("%.2f", this.dailySales));
    }
}
    
}
