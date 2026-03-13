public class Sellable package medicineshop;

public interface Sellable {
    void sell(int quantity);
    double calculatePrice(int quantity);
    boolean checkAvailability(int quantity);
}
    
}
