
import java.util.ArrayList;

public class DataBase_Store {
    private Admin admin[];
    private Account accounts[]; // array of Accounts
    private Product product[]; // array of Product
    private Recommended_products Recommendedproducts[];
    

    private ArrayList<Integer> OrderAccountID;
    private ArrayList<Integer> OrderProductID;
    private ArrayList<Integer> OrderProductAmount;
    private ArrayList<Boolean> OrderActive;
    private ArrayList<String> OrderStatus;

    public DataBase_Store(ArrayList<String> nameAccount, ArrayList<Integer> numberAccount,
            ArrayList<Integer> pinAccount, ArrayList<Integer> tellAccount, ArrayList<String> addressAccount,
            ArrayList<String> nameProduct, ArrayList<String> detailsProduct, ArrayList<String> categoryProduct,
            ArrayList<Double> priceProduct, ArrayList<Integer> amountProduct, ArrayList<String> nameRecommendedProduct,
            ArrayList<Integer> OrderAmountRecommendedProduct, ArrayList<Integer> OrderAccountID,
            ArrayList<Integer> OrderProductID, ArrayList<Integer> OrderProductAmount,
            ArrayList<Boolean> OrderActive, ArrayList<String> OrderStatus) {

        accounts = new Account[nameAccount.size()];
        product = new Product[nameProduct.size()];
        Recommendedproducts = new Recommended_products[nameRecommendedProduct.size()];
        admin = new Admin[2];

        admin[0] = new Admin(12345, 12345);
        admin[1] = new Admin(97865, 98765);

        for (int i = 0; i < nameAccount.size(); i++) {
            accounts[i] = new Account(nameAccount.get(i), numberAccount.get(i), pinAccount.get(i), tellAccount.get(i),
                    addressAccount.get(i));
        }

        for (int i = 0; i < amountProduct.size(); i++) {
            product[i] = new Product(i, nameProduct.get(i), detailsProduct.get(i), categoryProduct.get(i),
                    priceProduct.get(i), amountProduct.get(i));
        }

        for (int i = 0; i < nameRecommendedProduct.size(); i++) {
            Recommendedproducts[i] = new Recommended_products(nameRecommendedProduct.get(i),
                    OrderAmountRecommendedProduct.get(i));
        }

        this.OrderAccountID = OrderAccountID;
        this.OrderProductID = OrderProductID;
        this.OrderProductAmount = OrderProductAmount;
        this.OrderActive = OrderActive;
        this.OrderStatus = OrderStatus;
    }

    private Account getAccount(int accountNumber) {

        for (Account currentAccount : accounts) {

            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }

        return null;
    }

    private Admin getAdmin(int accountNumber) {

        for (Admin currentAccount : admin) {

            if (currentAccount.getNumberAdmin() == accountNumber)
                return currentAccount;
        }

        return null;
    }

    public boolean authenticateAdmin(int AdminAccountNumber, int AdminPIN) {

        Admin AdminAccount = getAdmin(AdminAccountNumber);

        if (AdminAccount != null)
            return AdminAccount.validatePIN(AdminPIN);
        else
            return false;
    }

    public boolean authenticateUser(int userAccountNumber, int userPIN) {

        Account userAccount = getAccount(userAccountNumber);

        if (userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false;
    }

    int getProductAmouts() {
        return product.length;
    }

    int getMemberAmouts() {
        return accounts.length;
    }

    int getRecommendedProductAmouts() {
        return Recommendedproducts.length;
    }

    int getIdAccount(int currentAccountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (currentAccountNumber == accounts[i].getAccountNumber()) {
                return i;
            }
        }

        return 0;
    }

    public String getNameAccount(int currentAccountNumber) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == currentAccountNumber) {
                return "User Name : " + accounts[i].getUsernamer() +
                        "\nNumber Account : " + accounts[i].getAccountNumber();
            }
        }
        return null;
    }

    public void ScreenRecommendedProducts() {
        System.out.println();
        System.out.println("========||Recommended Product||========");
        System.out.println();
        for (int i = 0; i < Recommendedproducts.length; i++) {

            System.out.println("||Name : " + Recommendedproducts[i].getRecommended_productsName());
            System.out.println("||Popular order quantity : " + Recommendedproducts[i].getOrderAmount());
            System.out.println("---------------------------------------");
            System.out.println();
        }

    }

    public String ScreenProduct() {
        String print = "";
        for (Product products : product) {
            print += "\n||Product ID : [" + products.getId() + "]\n||\n" + "||Name Product : " + products.getProductName() + "\n||Price : " + products.getPrice()
                    + "\n||Amount : [ " + products.getAmount() + " ]\n-----------------------------------------------";
        }

        return print;

    }

    public String ProductDetails(int productNumber) {

        return "\n||ID : [" + product[productNumber].getId() + "]\n" +
                "||Name Product : " + product[productNumber].getProductName() +
                "\n------- Details Product -------\n" + product[productNumber].getDetailsProduct() +
                "\n\n||Category : " + product[productNumber].getCategory() +
                "\n||Price : " + product[productNumber].getPrice() + "\n" +
                "||Remaining amount : " + product[productNumber].getAmount();
    }

    public String ScreenOrder(int IDAccount, int productNumber, int Amount) {

        String productList = UserOrderName(IDAccount);

        productList += "\nID : [" + product[productNumber].getId() + "]\n" +
                "\nName Product : " + product[productNumber].getProductName() +
                "\nDetails Product : " + product[productNumber].getDetailsProduct() +
                "\nCategory : " + product[productNumber].getCategory() +
                "\nPrice : " + product[productNumber].getPrice() + "\n\n" +
                "Amount : " + Amount +
                "\n\nTotal : " + (product[productNumber].getPrice() * Amount);

        return productList;

    }

    public String UserOrderName(int IDAccount) {

        return "\nOrderer's name : " + accounts[IDAccount].getUsernamer() +
                "\nAddress : " + accounts[IDAccount].getAddress() +
                "\nTell : " + accounts[IDAccount].getTell() +
                "\n===============|Product list|===============\n";

    }
    private Double SumOrder = 0.0;
    public String ScreenAllOrder(int IDOrder) {            
        SumOrder += (product[OrderProductID.get(IDOrder)].getPrice() * OrderProductAmount.get(IDOrder));
        return "\nID : " + IDOrder+
                "\nName Product : " + product[OrderProductID.get(IDOrder)].getProductName() +
                "\nDetails Product : " + product[OrderProductID.get(IDOrder)].getDetailsProduct() +
                "\nCategory : " + product[OrderProductID.get(IDOrder)].getCategory() +
                "\nPrice : " + product[OrderProductID.get(IDOrder)].getPrice() + "\n\n" +
                "Amount : " + OrderProductAmount.get(IDOrder) +
                "\n\nTotal : " + (product[OrderProductID.get(IDOrder)].getPrice() * OrderProductAmount.get(IDOrder));
      
    }
    public Double SumOrder() {
        return SumOrder ;
    }

    

    public String ScreenAllProductforAdmin(int productNumber) {

        return "\nID : [" + product[productNumber].getId() + "]\n" +
                "Name Product : " + product[productNumber].getProductName() +
                "\nDetails Product : " + product[productNumber].getDetailsProduct() +
                "\nCategory : " + product[productNumber].getCategory() +
                "\nPrice : " + product[productNumber].getPrice() + "\n" +
                "Remaining amount : " + product[productNumber].getAmount();

    }

    public String ScreenAllOrderforAdmin(int Ordernumber) {
        String order = "";
        int sum = 0;
        order += "|| Member || \nID : " + OrderAccountID.get(Ordernumber) +
                "\nName : " + accounts[OrderAccountID.get(Ordernumber)].getUsernamer() +
                "\nUser Account : " + accounts[OrderAccountID.get(Ordernumber)].getAccountNumber() +
                "\nAddress : " + accounts[OrderAccountID.get(Ordernumber)].getAddress() +
                "\nTell : " + accounts[OrderAccountID.get(Ordernumber)].getTell() +
                "\n----------------------------------------";

        sum += (OrderProductAmount.get(Ordernumber) * product[OrderProductID.get(Ordernumber)].getPrice());
        order += "\n|| Product ||\nID : " + product[OrderProductID.get(Ordernumber)].getId() + "\n" +
                "Name Product : " + product[OrderProductID.get(Ordernumber)].getProductName() +
                "\nDetails Product : " + product[OrderProductID.get(Ordernumber)].getDetailsProduct() +
                "\nCategory : " + product[OrderProductID.get(Ordernumber)].getCategory() +
                "\nAmount : " + OrderProductAmount.get(Ordernumber) + "" +
                "\nPrice : " + product[OrderProductID.get(Ordernumber)].getPrice() + "\n";

        order += "\nTotal : " + sum + "\n" + "========================================\n";
        return order;

    }

    public String ScreenAllOrderStatusforAdmin(int IDOrderNumber) {
       return "\nOrder ID : [" + IDOrderNumber+"]" + 
             "\nUser Number : "+ accounts[OrderAccountID.get(IDOrderNumber)].getAccountNumber()+
             "\nName : "+ accounts[OrderAccountID.get(IDOrderNumber)].getUsernamer()+
             "\nProduct : " + product[OrderProductID.get(IDOrderNumber)].getProductName()+
             "\nAmount : " + OrderProductAmount.get(IDOrderNumber)+
             "\nTatol : "+ (OrderProductAmount.get(IDOrderNumber) * product[OrderProductID.get(IDOrderNumber)].getPrice())+
             "\n\nStatus : "+OrderStatus.get(IDOrderNumber)+"\n"
             ;
    }

    public String ScreenAllMemberforAdmin(int Usernumber) {
        return "\nID : [" + Usernumber + "]\n" +
                "Name : " + accounts[Usernumber].getUsernamer() +
                "\nUser Account : " + accounts[Usernumber].getAccountNumber() +
                "\nUser Pin : " + accounts[Usernumber].getPin() +
                "\nAddress : " + accounts[Usernumber].getAddress() +
                "\nTell : " + accounts[Usernumber].getTell();
    }

    public String ScreenAllRecommended_ProductforAdmin(int Recommended_productsNumber) {
        return "\nID : [" + Recommended_productsNumber + "]\n" +
                "Name : " + Recommendedproducts[Recommended_productsNumber].getRecommended_productsName() +
                "\nOrder Amount : " + Recommendedproducts[Recommended_productsNumber].getOrderAmount();
    }

}
