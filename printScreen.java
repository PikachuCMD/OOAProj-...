// printScreen.java

public class printScreen {
    
    public void displayMessage(int length) {
        System.out.print(length);
    } 

    public void displayMessage(String length) {
        System.out.print(length);
    }
    
    public void displayMessageLine(String message) {
        System.out.println(message);
    }

    
    public void displayDollarAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    } 
} 
