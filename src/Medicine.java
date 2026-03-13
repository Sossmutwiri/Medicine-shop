public class Medicine {

    public Medicine() {
    }
    package medicineshop;
    
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    
    public class Medicine implements Sellable, StockManageable {
        private String medicineCode;
        private String name;
        private String company;
        private double pricePerUnit;
        private int stockQuantity;
        private LocalDate expiryDate;
        private boolean requiresPrescription;
        
        public Medicine(String medicineCode, String name, String company, double pricePerUnit, 
                        int stockQuantity, String expiryDate, boolean requiresPrescription) {
            this.medicineCode = medicineCode;
            this.name = name;
            this.company = company;
            this.pricePerUnit = pricePerUnit;
            this.stockQuantity = stockQuantity;
            this.expiryDate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.requiresPrescription = requiresPrescription;
        }
        
        // Getters and Setters
        public String getMedicineCode() {
            return medicineCode;
        }
        
        public void setMedicineCode(String medicineCode) {
            this.medicineCode = medicineCode;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getCompany() {
            return company;
        }
        
        public void setCompany(String company) {
            this.company = company;
        }
        
        public double getPricePerUnit() {
            return pricePerUnit;
        }
        
        public void setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
        }
        
        public int getStockQuantity() {
            return stockQuantity;
        }
        
        public LocalDate getExpiryDate() {
            return expiryDate;
        }
        
        public boolean isRequiresPrescription() {
            return requiresPrescription;
        }
        
        // Interface implementations
        @Override
        public void sell(int quantity) {
            if (checkAvailability(quantity)) {
                this.stockQuantity -= quantity;
                System.out.println(quantity + " units of " + this.name + " sold. Remaining stock: " + this.stockQuantity);
            } else {
                System.out.println("Insufficient stock for " + this.name);
            }
        }
        
        @Override
        public double calculatePrice(int quantity) {
            return this.pricePerUnit * quantity;
        }
        
        @Override
        public boolean checkAvailability(int quantity) {
            return this.stockQuantity >= quantity;
        }
        
        @Override
        public void addStock(int quantity) {
            this.stockQuantity += quantity;
            System.out.println(quantity + " units added to " + this.name + ". New stock: " + this.stockQuantity);
        }
        
        @Override
        public void removeStock(int quantity) {
            if (this.stockQuantity >= quantity) {
                this.stockQuantity -= quantity;
                System.out.println(quantity + " units removed from " + this.name + ". New stock: " + this.stockQuantity);
            } else {
                System.out.println("Cannot remove " + quantity + " units. Available: " + this.stockQuantity);
            }
        }
        
        @Override
        public void checkExpiry() {
            LocalDate today = LocalDate.now();
            if (expiryDate.isBefore(today)) {
                System.out.println(this.name + " is EXPIRED! Expired on: " + this.expiryDate);
            } else if (expiryDate.isBefore(today.plusMonths(3))) {
                System.out.println(this.name + " is expiring soon on: " + this.expiryDate);
            } else {
                System.out.println(this.name + " is valid until: " + this.expiryDate);
            }
        }
        
        public void displayMedicineInfo() {
            System.out.println("Medicine: " + this.name + " | Code: " + this.medicineCode + 
                              " | Company: " + this.company + " | Price: $" + this.pricePerUnit +
                              " | Stock: " + this.stockQuantity + " | Expiry: " + this.expiryDate +
                              " | Prescription Required: " + (this.requiresPrescription ? "Yes" : "No"));
        }
    }
}


import medicineshop.Sellable.Sellable;
import medicineshop.StockManeagable.StockManageable;