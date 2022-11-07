import java.util.ArrayList;

public class Order {
    private DataBase_Store dataStore;
    private printScreen printScreen;
    private inputKey keypad;
    // private Shop_Online shopOnline;

    private ArrayList<Integer> OrderAccountID;
    private ArrayList<Integer> OrderProductID;
    private ArrayList<Integer> OrderProductAmount;
    private ArrayList<Boolean> OrderActive;
    private ArrayList<String> OrderStatus;

    public Order(ArrayList<String> nameAccount, ArrayList<Integer> numberAccount,
            ArrayList<Integer> pinAccount, ArrayList<Integer> tellAccount, ArrayList<String> addressAccount,
            ArrayList<String> nameProduct, ArrayList<String> detailsProduct, ArrayList<String> categoryProduct,
            ArrayList<Double> priceProduct, ArrayList<Integer> amountProduct, ArrayList<String> nameRecommendedProduct,
            ArrayList<Integer> OrderAmountRecommendedProduct, ArrayList<Integer> OrderAccountID,
            ArrayList<Integer> OrderProductID, ArrayList<Integer> OrderProductAmount,
            ArrayList<Boolean> OrderActive, ArrayList<String> OrderStatus) {

        printScreen = new printScreen(); // create screen
        keypad = new inputKey();
        // shopOnline = new Shop_Online();

        dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount, nameProduct,
                detailsProduct, categoryProduct, priceProduct, amountProduct, nameRecommendedProduct,
                OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount, OrderActive,
                OrderStatus);

        this.OrderAccountID = OrderAccountID;
        this.OrderProductID = OrderProductID;
        this.OrderProductAmount = OrderProductAmount;
        this.OrderActive = OrderActive;
        this.OrderStatus = OrderStatus;

    }

    public void getOrder(int IDAccount, int getIdProduct, int Amount) {
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("========|| Order || =======");
        printScreen.displayMessageLine(dataStore.ScreenOrder(IDAccount, getIdProduct, Amount));
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("[1] - - Select order now");
        printScreen.displayMessageLine("[2] - - cancel order");

        printScreen.displayMessageLine("");
        printScreen.displayMessage("Enter your anwer : ");
        int Choice = keypad.getInput();

        if (Choice == 1) {
            OrderAccountID.add(IDAccount);
            OrderProductID.add(getIdProduct);
            OrderProductAmount.add(Amount);
            OrderActive.add(false);
            OrderStatus.add(null);

            getAllOrder(IDAccount);
            printScreen.displayMessageLine("[1] - - All Order");
            printScreen.displayMessageLine("[2] - - Some Order");
            printScreen.displayMessageLine("[3] - - Exit");
            printScreen.displayMessageLine("");
            printScreen.displayMessage("Select : ");
            int ChoiceOrder = keypad.getInput();
            if (ChoiceOrder == 1) {
                for (int i = 0; i < OrderAccountID.size(); i++) {
                    if (OrderAccountID.get(i) == IDAccount && OrderActive.get(i) == false) {
                        OrderActive.set(i, true);
                    }
                }
                getAllStatusOrder(IDAccount);

            } else if (ChoiceOrder == 2) {
                printScreen.displayMessage("Order Number : ");
                int OrderID = keypad.getInput();
                OrderActive.set(OrderID, true);
                getAllStatusOrder(IDAccount);
            }
        }

    }

    void getBaskets(int IDAccount) {
        getAllOrder(IDAccount);
        printScreen.displayMessageLine("|[1] - - All Order");
        printScreen.displayMessageLine("|[2] - - Some Order");
        printScreen.displayMessageLine("|[3] - - Exit");
        printScreen.displayMessageLine("");
        printScreen.displayMessage("Select : ");
        int ChoiceOrder = keypad.getInput();
        if (ChoiceOrder == 1) {
            for (int i = 0; i < OrderAccountID.size(); i++) {
                if (OrderAccountID.get(i) == IDAccount ) {
                    OrderActive.set(i, true);
                }
            }
            getAllStatusOrder(IDAccount);

        } else if (ChoiceOrder == 2) {
            printScreen.displayMessage("Order Number : ");
            int OrderID = keypad.getInput();
            OrderActive.set(OrderID, true);
            getAllStatusOrder(IDAccount);
        }

    }



    public void getAllOrder(int IDAccount) {
        printScreen.displayMessageLine("============|| All Order ||==============");
        printScreen.displayMessageLine(dataStore.UserOrderName(IDAccount));
        printScreen.displayMessageLine("");

        int num = 0;
        for (int i = 0; i < OrderAccountID.size(); i++) {
            if (OrderAccountID.get(i) == IDAccount ) {

                printScreen.displayMessageLine(dataStore.ScreenAllOrder(i));
                printScreen.displayMessageLine("");
                num++;

            }

        }

        if (num == 0) {
            printScreen.displayMessageLine("\n-------------------------------------\n" +
                    "             not have order          \n" +
                    "-------------------------------------\n");
        }
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("Order Tatol : " + dataStore.SumOrder());
        printScreen.displayMessageLine("");
    }

    public void getAllStatusOrder(int IDAccount) {
        int num = 0;
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("=============|| Status Order ||=============");

        for (int i = 0; i < OrderAccountID.size(); i++) {
            if (OrderAccountID.get(i) == IDAccount && OrderStatus.get(i) != null) {

                printScreen.displayMessageLine(dataStore.ScreenAllOrderStatusforAdmin(i));
                printScreen.displayMessageLine("Order Active : " + OrderActive.get(i) + "\n");

                printScreen.displayMessage("--------------------------------------------");
                num++;
            } else if (OrderAccountID.get(i) == IDAccount && OrderStatus.get(i) == null && OrderActive.get(i) == true) {
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine(
                        "Order ID : " + i + "\n['Your order has not been confirmed by moderators.']\n");
                printScreen.displayMessageLine("Order Active : " + OrderActive.get(i) + "\n");
                printScreen.displayMessage("--------------------------------------------");
                num++;
            }

        }
        if (num == 0) {
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("--------------------------------------------");
            printScreen.displayMessageLine("============================================");
            printScreen.displayMessageLine("               || No order ||");
            printScreen.displayMessageLine("============================================");
            printScreen.displayMessageLine("--------------------------------------------");
        }
    }

    public void getAllStatusOrderDetails(int IDAccount,int OrderID) {
          printScreen.displayMessageLine(dataStore.UserOrderName(IDAccount));
          printScreen.displayMessageLine(dataStore.ScreenAllOrder(OrderID));

          printScreen.displayMessageLine("");
          printScreen.displayMessageLine("Status Order Details : "+ OrderStatus.get(OrderID));
          printScreen.displayMessageLine("Order Active : "+ OrderActive.get(OrderID));
          printScreen.displayMessageLine("");
          printScreen.displayMessageLine("||====================||");
          printScreen.displayMessageLine("|[1] - - Exit");
          printScreen.displayMessageLine("");
          printScreen.displayMessage("Enter your anwer :: ");
          int exitCode = keypad.getInput();

    }
}