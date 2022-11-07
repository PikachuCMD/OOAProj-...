
public class Account {
    private int accountNumber; // account number
    private String username; // account name
    private int pin; // PIN for authentication
    private int Tell; // funds available for withdrawal
    private String address; // funds available + pending deposits

    // Account constructor initializes attributes
    public Account(String username,int AccountNumber, int PIN, int Tell, String address) {
        this.username = username;
        this.accountNumber = AccountNumber;
        this.pin = PIN;
        this.Tell = Tell;
        this.address = address;
    }

    public boolean validatePIN(int userPIN) {
        if (userPIN == pin)
            return true;
        else
            return false;
    }   

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUsernamer() { 
        return username;
    }

    public String getAddress() {
        return address;
    }
    public int getTell() {
        return Tell;
    }
    public int getPin() {
        return pin;
    }
    
}
