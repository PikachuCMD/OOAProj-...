import java.util.Scanner;
import java.util.ArrayList;

public class Shop_Online {
    private Scanner sc = new Scanner(System.in);
    private boolean AdminAuthenticated;
    private int currentAdminNumber;

    private boolean userAuthenticated;
    private int currentAccountNumber;

    private DataBase_Store dataStore;
    private printScreen printScreen;
    private inputKey keypad;
    private Order order;

    private int Choose = 0;
    private boolean answerfirstOption = false;

    // Account
    // private ArrayList<Integer> IDAccount = new ArrayList<Integer>();
    private ArrayList<String> nameAccount = new ArrayList<String>();
    private ArrayList<Integer> numberAccount = new ArrayList<Integer>();
    private ArrayList<Integer> pinAccount = new ArrayList<Integer>();
    private ArrayList<Integer> tellAccount = new ArrayList<Integer>();
    private ArrayList<String> addressAccount = new ArrayList<String>();

    // Product
    private ArrayList<String> nameProduct = new ArrayList<String>();
    private ArrayList<String> detailsProduct = new ArrayList<String>();
    private ArrayList<String> categoryProduct = new ArrayList<String>();
    private ArrayList<Double> priceProduct = new ArrayList<Double>();
    private ArrayList<Integer> amountProduct = new ArrayList<Integer>();

    // Recommended Products
    private ArrayList<String> nameRecommendedProduct = new ArrayList<String>();
    private ArrayList<Integer> OrderAmountRecommendedProduct = new ArrayList<Integer>();

    // Order
    private ArrayList<Integer> OrderAccountID = new ArrayList<Integer>();
    private ArrayList<Integer> OrderProductID = new ArrayList<Integer>();
    private ArrayList<Integer> OrderProductAmount = new ArrayList<Integer>();
    private ArrayList<Boolean> OrderActive = new ArrayList<Boolean>();
    private ArrayList<String> OrderStatus = new ArrayList<String>();

    // constructor
    public Shop_Online() {
        nameAccount.add("satathong");
        nameAccount.add("eagapob");

        numberAccount.add(12345);
        numberAccount.add(98765);

        pinAccount.add(54321);
        pinAccount.add(56789);

        tellAccount.add(0604564424);
        tellAccount.add(0600001111);

        addressAccount.add("1110/1 m.4 b.pisanurok");
        addressAccount.add("1110/1 m.4 b.pisanurok");

        // Data Product
        nameProduct.add("POWER SUPPLY (80+ BRONZE) 550W ANTEC ATOM B550");
        nameProduct.add("Monitor 19.5'' ACER EH200Qbi (TN, VGA, HDMI) 60Hz");
        nameProduct.add("POWER BANK 30000 mAh ELOOP (E29) Black");
        nameProduct.add("Cable Display TO Display (3M) UGREEN 10212");

        detailsProduct.add(
                "-80 PLUS BRONZE Certified - To reduce your electricity bill.\n-Circuit Shield - Industrial grade protections: OPP/OVP/UVP/SCP\n-120mm Silent Fan\n-FLAT Cable\n-Thermal Manager - An advanced fan control for optimal heat & noise management.\n-Active Power Factor Correction (APFC)");
        detailsProduct.add(
                "-ACER EH200Qbi\n-BlueLight Shield technology\n-Acer Flicker-less technology\n-Acer ComfyView display\n-Acer ComfyView technology incorporates several features that take into consideration prolonged usage by heavy users such as programmers, writers, and graphic designers to reduce eye strain and provides a more comfortable viewing experience");
        detailsProduct.add(
                "-Supports Quick Charge 3.0 (QC3.0) fast charging\n-Supports PD (Power Delivery) fast charging of iPhone 8/8+/X (requires Type-C to Lightning cable)\n-Can charge almost all brands of smartphones, tablets, such as iPhone / Samsung / iPad / iPod / Sony / Huawei / LG etc.\n-Power supply to best suit your device.\n-There is a protection system and cut off the power when The battery is fully charged.");
        detailsProduct.add(
                "-Supports DisplayPort video resolutions up to 4K @60Hz (maximum).\n-Support digital audio\n-durable material Gold-plated head to prevent corrosion\n-Shielded twisted wires to prevent interference, ensuring signal stability. durable to use");

        categoryProduct.add("POWER SUPPLY");
        categoryProduct.add("Monitor");
        categoryProduct.add("POWER BANK");
        categoryProduct.add("Cable Display");

        priceProduct.add(1620.0);
        priceProduct.add(3150.0);
        priceProduct.add(1185.0);
        priceProduct.add(420.0);

        amountProduct.add(2);
        amountProduct.add(1);
        amountProduct.add(5);
        amountProduct.add(3);

        // Data Recommended Products
        nameRecommendedProduct.add("Keybord");
        nameRecommendedProduct.add("Keybordsss");

        OrderAmountRecommendedProduct.add(100);
        OrderAmountRecommendedProduct.add(200);

        // Data Order
        OrderAccountID.add(0);
        OrderAccountID.add(1);
        OrderAccountID.add(0);

        OrderProductID.add(0);
        OrderProductID.add(1);
        OrderProductID.add(1);

        OrderProductAmount.add(2);
        OrderProductAmount.add(2);
        OrderProductAmount.add(2);

        OrderActive.add(true);
        OrderActive.add(false);
        OrderActive.add(false);

        OrderStatus.add(null);
        OrderStatus.add(null);
        OrderStatus.add(null);

        AdminAuthenticated = false;// Admin is not authenticated to start
        // currentAdminNumber = 0; // no current account number to start

        userAuthenticated = false; // user is not authenticated to start
        currentAccountNumber = 0; // no current account number to start

        printScreen = new printScreen(); // create screen
        keypad = new inputKey();
        dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount, nameProduct,
                detailsProduct, categoryProduct, priceProduct, amountProduct, nameRecommendedProduct,
                OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount, OrderActive,
                OrderStatus);

        order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount, nameProduct,
                detailsProduct, categoryProduct, priceProduct, amountProduct, nameRecommendedProduct,
                OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount, OrderActive,
                OrderStatus);

    }

    public void run() {
        while (Choose != 3) {

            firstOption();

            AdminAuthenticated = false;
            // currentAdminNumber = 0;

            userAuthenticated = false;
            currentAccountNumber = 0;

        }
    }

    public void printMenu() {

        while (true) {
            printScreen.displayMessageLine("");
            if (userAuthenticated) {

                printScreen.displayMessageLine("========= User Account =========");
                printScreen.displayMessageLine(dataStore.getNameAccount(currentAccountNumber));
                printScreen.displayMessageLine("================================");
            }

            printScreen.displayMessageLine("");
            dataStore.ScreenRecommendedProducts();
            System.out.println("||===========|| Product List ||===========||");
            System.out.println();
            printScreen.displayMessageLine(dataStore.ScreenProduct());
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine(
                    "==============================================================================");
            printScreen.displayMessageLine(
                    "## If you want to see the product details, please enter the product number. ##");
            printScreen.displayMessageLine(
                    "==============================================================================");
            printScreen.displayMessageLine("");

            productList();
        }
    }

    public void firstOption() {

        while (!answerfirstOption) {
            printScreen.displayMessageLine("\n=======|| Welcome! ||=======\n");
            printScreen.displayMessageLine("|[1] - - See product");
            printScreen.displayMessageLine("|[2] - - Log In");
            printScreen.displayMessageLine("|[3] - - Exit the program");
            printScreen.displayMessageLine("");

            printScreen.displayMessageLine("============================");
            printScreen.displayMessage("Please enter your answer : ");
            Choose = keypad.getInput();
            printScreen.displayMessageLine("============================");
            if (Choose == 1) {
                // answerfirstOption = true;
                if (Choose != 3) {
                    printMenu();
                }

            } else if (Choose == 2) {
                // answerfirstOption = true;
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("|[1] - - Admin");
                printScreen.displayMessageLine("|[2] - - Cutomer");
                printScreen.displayMessageLine("");
                printScreen.displayMessage("Enter your answer : ");
                int level = keypad.getInput();
                if (level == 1) {
                    LoginAdmin();
                    OptionsAdmin();

                } else {
                    LogIn();
                    printMenu();
                }

            } else if (Choose == 3) {
                Choose = 3;
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("|=======||Good Bye||=======|");
                printScreen.displayMessageLine("|      __/\\______/\\__  _   |");
                printScreen.displayMessageLine("|   / |  __ ==   == _|[_]  |");
                printScreen.displayMessageLine("|   \\ |  \\\\     3    |//   |");
                printScreen.displayMessageLine("|    \\|__[ ]_____[ ]_|     |");
                printScreen.displayMessageLine("|==========================|");
                answerfirstOption = true;
                break;

            } else {
                printScreen.displayMessageLine("Please enter your answer again.");
            }
        }
    }

    public void LogIn() {
        while (!userAuthenticated) {
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("================================");
            printScreen.displayMessageLine("*******|| Please Login ||*******");
            printScreen.displayMessage("\nPlease enter your account number: ");
            int accountNumber = keypad.getInput(); // input account number
            printScreen.displayMessage("\nEnter your PIN: "); // prompt for PIN
            int pin = keypad.getInput(); // input PIN
            printScreen.displayMessageLine("================================");
            userAuthenticated = dataStore.authenticateUser(accountNumber, pin);

            if (userAuthenticated) {
                currentAccountNumber = accountNumber;
            } else {
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("Invalid account number or PIN. Please try again.");
            }
        }
    }

    public void LoginAdmin() {
        while (!AdminAuthenticated) {
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("================================");
            printScreen.displayMessageLine("*******|| Please Login ||*******");
            printScreen.displayMessage("\nPlease enter your Admin number: ");
            int accountNumber = keypad.getInput(); // input account number
            printScreen.displayMessage("\nEnter your PIN: "); // prompt for PIN
            int pin = keypad.getInput(); // input PIN
            printScreen.displayMessageLine("================================");
            AdminAuthenticated = dataStore.authenticateAdmin(accountNumber, pin);

            if (AdminAuthenticated) {
                currentAdminNumber = accountNumber;
            } else {
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("Invalid Admin number or PIN. Please try again.");
            }

        }

    }

    public void productList() {
        printScreen.displayMessageLine("|[100] - - Place an order");
        printScreen.displayMessageLine("|[200] - - Order Status");
        printScreen.displayMessageLine("|[300] - - Log In");
        printScreen.displayMessageLine("|[400] - - Log Out");
        printScreen.displayMessageLine("|[500] - - Leave System");
        printScreen.displayMessageLine("");
        printScreen.displayMessageLine("======================");
        printScreen.displayMessage("choose your answer : ");

        int ProductNumber = keypad.getInput();
        printScreen.displayMessageLine("======================");
        if (ProductNumber == 100) {
            LogIn();
            order.getAllOrder(dataStore.getIdAccount(ProductNumber));
            printScreen.displayMessageLine("|[1] - - Select Order");
            printScreen.displayMessageLine("|[2] - - Log Out");
            printScreen.displayMessageLine("|[3] - - Exit");
            printScreen.displayMessageLine("");
            printScreen.displayMessage("Enter your answer : ");
            int ChooseOrder = keypad.getInput();

            if (ChooseOrder == 1) {
                order.getBaskets(dataStore.getIdAccount(currentAccountNumber));

                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("--------------------------------------------");
                printScreen.displayMessageLine("[1] - - View order status details");
                printScreen.displayMessageLine("[2] - - Exit");
                printScreen.displayMessageLine("");
                printScreen.displayMessage("Enter number : : ");
                int BackEnterAll = keypad.getInput();
                if (BackEnterAll == 1) {
                      printScreen.displayMessage("Order Number : ");
                      int Ordernumber = keypad.getInput();
                      order.getAllStatusOrderDetails(dataStore.getIdAccount(currentAccountNumber), Ordernumber);
                } else {
                    printMenu();
                }

            } else if (ChooseOrder == 2) {
                userAuthenticated = false;
                currentAccountNumber = 0;
            } else {
                printMenu();
            }

        } else if (ProductNumber == 200) {
            LogIn();
            order.getAllStatusOrder(dataStore.getIdAccount(currentAccountNumber));
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("[1] - - View order status details");
            printScreen.displayMessageLine("[2] - - Exit");
            printScreen.displayMessageLine("");
            printScreen.displayMessage("Enter number : : ");
            int BackEnterAll = keypad.getInput();
            if (BackEnterAll == 1) {
                printScreen.displayMessage("Order Number : ");
                int Ordernumber = keypad.getInput();
                order.getAllStatusOrderDetails(dataStore.getIdAccount(currentAccountNumber), Ordernumber);
            } else {
                printMenu();
            }
            
        } else if (ProductNumber == 300) {
            LogIn();
            printMenu();
        } else if (ProductNumber == 400) {
            LogIn();
            printScreen.displayMessageLine("||========|| Log Out ||========||");
            printScreen.displayMessageLine("Are you sure you want to log out?");
            printScreen.displayMessageLine("[1] - - Yes");
            printScreen.displayMessageLine("[2] - - No");
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("=====================");
            printScreen.displayMessage("Enter your answer : ");
            int select = keypad.getInput();
            printScreen.displayMessageLine("=====================");
            if (select == 1) {
                userAuthenticated = false;
                currentAccountNumber = 0;
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("======================================");
                printScreen.displayMessageLine("||====|| Log Out Successfully ||====||");
                printScreen.displayMessageLine("======================================");
            } else {
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("===============================");
                printScreen.displayMessageLine("||====|| Cancel Logout ||====||");
                printScreen.displayMessageLine("===============================");
            }

        } else if (ProductNumber == 500) {

            Choose = 0;
            run();

        } else {
            if (ProductNumber <= nameProduct.size()) {
                int Amount;
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("==================================");
                printScreen.displayMessageLine(dataStore.ProductDetails(ProductNumber));
                printScreen.displayMessageLine("==================================");
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("|[1] - - Order now");
                printScreen.displayMessageLine("|[2] - - Add to cart");
                printScreen.displayMessageLine("|[3] - - Back to product list");
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("=====================");
                printScreen.displayMessage("enter your answer : ");
                int select = keypad.getInput();
                printScreen.displayMessageLine("=====================");

                switch (select) {
                    case 1:
                        LogIn();

                        printScreen.displayMessage("Amount Product : ");
                        Amount = keypad.getInput();
                        if (amountProduct.get(ProductNumber) - Amount >= 0) {
                            order.getOrder(dataStore.getIdAccount(currentAccountNumber), ProductNumber, Amount);
                            printScreen.displayMessageLine("");
                            printScreen.displayMessageLine("[1] - - View order status details");
                            printScreen.displayMessageLine("[2] - - Exit");
                            printScreen.displayMessageLine("");
                            printScreen.displayMessage("Enter number : : ");
                            int BackEnterAll = keypad.getInput();
                            if (BackEnterAll == 1) {
                                printScreen.displayMessage("Order Number : ");
                                int Ordernumber = keypad.getInput();
                                order.getAllStatusOrderDetails(dataStore.getIdAccount(currentAccountNumber),
                                        Ordernumber);
                            } 
                        } else {
                            printScreen.displayMessageLine("");
                            printScreen.displayMessageLine(
                                    "=======================================================================");
                            printScreen.displayMessageLine(
                                    "|| The number of products is insufficient from the quantity ordered. ||");
                            printScreen.displayMessageLine(
                                    "=======================================================================");
                        }

                        break;
                    case 2:
                        LogIn();

                        printScreen.displayMessage("Amount Product : ");
                        Amount = keypad.getInput();

                        if (amountProduct.get(ProductNumber) - Amount >= 0) {
                            LogIn();
                            OrderAccountID.add(dataStore.getIdAccount(currentAccountNumber));
                            OrderProductID.add(ProductNumber);
                            OrderProductAmount.add(Amount);
                            OrderActive.add(false);
                            OrderStatus.add(null);
                        } else {
                            printScreen.displayMessageLine("");
                            printScreen.displayMessageLine(
                                    "=======================================================================");
                            printScreen.displayMessageLine(
                                    "|| The number of products is insufficient from the quantity ordered. ||");
                            printScreen.displayMessageLine(
                                    "=======================================================================");
                        }
                        break;
                    case 3:
                    default:

                }
            } else {
                printScreen.displayMessageLine("");
                printScreen.displayMessageLine("=======================================");
                printScreen.displayMessageLine("||                                   ||");
                printScreen.displayMessageLine("|| Invalid number, please try again. ||");
                printScreen.displayMessageLine("||                                   ||");
                printScreen.displayMessageLine("=======================================");
            }

        }

    }

    /////////////////////////////////////////////////////////////// ADMIN
    /////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////////////////////
    public void OptionsAdmin() {
        boolean show = true;
        while (show) {
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("========|| Admin Options ||========");
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("|[1] - - Product");
            printScreen.displayMessageLine("|[2] - - Order");
            printScreen.displayMessageLine("|[3] - - Status");
            printScreen.displayMessageLine("|[4] - - Membership");
            printScreen.displayMessageLine("|[5] - - Recommended Product");
            printScreen.displayMessageLine("|[6] - - Log Out");
            printScreen.displayMessageLine("");
            printScreen.displayMessageLine("====================");
            printScreen.displayMessage("Enter your answer :");
            int select = keypad.getInput();
            printScreen.displayMessageLine("====================");
            printScreen.displayMessageLine("");
            boolean manage = true;
            while (manage) {
                switch (select) {
                    // Product
                    case 1:
                        printScreen.displayMessageLine("==========|| Product List ||==========");
                        for (int i = 0; i < dataStore.getProductAmouts(); i++) {
                            printScreen.displayMessageLine(dataStore.ScreenAllProductforAdmin(i));
                            printScreen.displayMessageLine(
                                    "-------------------------------------------------------------");
                        }
                        printScreen.displayMessageLine("");
                        printScreen.displayMessageLine("|[100] - - Add Product");
                        printScreen.displayMessageLine("|[200] - - Edit Product");
                        printScreen.displayMessageLine("|[300] - - Delete Product");
                        printScreen.displayMessageLine("|[400] - - Exit");
                        printScreen.displayMessageLine("");
                        printScreen.displayMessageLine("==========================================");
                        printScreen.displayMessage("Please choose to deal with the product : ");
                        int manageProduct = keypad.getInput();
                        printScreen.displayMessageLine("==========================================");
                        printScreen.displayMessageLine("");
                        if (manageProduct == 100) {
                            printScreen.displayMessageLine("\n============|| Add Product ||============\n");
                            printScreen.displayMessage("Name Product : ");
                            String productName = sc.nextLine();
                            printScreen.displayMessage("Details Product : ");
                            String productDetails = sc.nextLine();
                            printScreen.displayMessage("Caregory Product : ");
                            String productCaregory = sc.nextLine();
                            printScreen.displayMessage("Price Product : ");
                            Double productPrice = sc.nextDouble();
                            printScreen.displayMessage("Amount Product : ");
                            Integer productAmount = sc.nextInt();

                            nameProduct.add(productName);
                            detailsProduct.add(productDetails);
                            categoryProduct.add(productCaregory);
                            priceProduct.add(productPrice);
                            amountProduct.add(productAmount);
                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                        } else if (manageProduct == 200) {

                            printScreen.displayMessageLine("\n============|| Edit Product ||============\n");
                            printScreen.displayMessage("Please select an item number : ");
                            int productnumber = keypad.getInput();
                            printScreen.displayMessage("Name Product : ");
                            String productName = sc.nextLine();
                            printScreen.displayMessage("Details Product : ");
                            String productDetails = sc.nextLine();
                            printScreen.displayMessage("Caregory Product : ");
                            String productCaregory = sc.nextLine();
                            printScreen.displayMessage("Price Product : ");
                            Double productPrice = sc.nextDouble();
                            printScreen.displayMessage("Amount Product : ");
                            Integer productAmount = sc.nextInt();

                            nameProduct.set(productnumber, productName);
                            detailsProduct.set(productnumber, productDetails);
                            categoryProduct.set(productnumber, productCaregory);
                            priceProduct.set(productnumber, productPrice);
                            amountProduct.set(productnumber, productAmount);
                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                        } else if (manageProduct == 300) {
                            printScreen.displayMessageLine("\n============|| Delete Product ||============\n");
                            printScreen.displayMessage("Please select an item number : ");
                            int productnumber = keypad.getInput();

                            // dataStore = new DataBase_Store(productnumber);
                            nameProduct.remove(productnumber);
                            detailsProduct.remove(productnumber);
                            categoryProduct.remove(productnumber);
                            priceProduct.remove(productnumber);
                            amountProduct.remove(productnumber);
                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                        } else {
                            manage = false;
                        }

                        break;
                    // Order
                    case 2:
                        printScreen.displayMessageLine("");
                        printScreen.displayMessageLine("==========|| Order List ||==========");
                        printScreen.displayMessageLine("");
                        for (int i = 0; i < OrderAccountID.size(); i++) {
                            if (OrderActive.get(i) && OrderStatus.get(i) == null) {
                                printScreen.displayMessageLine("Order Number : [ " + i + " ]");
                                printScreen.displayMessageLine(dataStore.ScreenAllOrderforAdmin(i));
                            }

                        }
                        printScreen.displayMessageLine("|[100] - - Get the order");
                        printScreen.displayMessageLine("|[200] - - Cancel order");
                        printScreen.displayMessageLine("|[300] - - Exit");
                        printScreen.displayMessage("Please choose to deal with the Order : ");
                        int manageOrder = keypad.getInput();

                        if (manageOrder == 100) {
                            printScreen.displayMessage("ID Order : ");
                            int IDOrder = keypad.getInput();
                            printScreen.displayMessageLine("\n==========|| Status Order List ||==========\n");
                            printScreen.displayMessageLine("|[1] - - Product inspection");
                            printScreen.displayMessageLine("|[2] - - Prepare to ship");
                            printScreen.displayMessageLine("|[3] - - Shipped");
                            printScreen.displayMessageLine("|[4] - - Exit");
                            printScreen.displayMessageLine("");
                            printScreen.displayMessage("Please select a product status : ");
                            int status = keypad.getInput();
                            if (status == 1) {
                                OrderStatus.set(IDOrder, "Product inspection");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            } else if (status == 2) {
                                OrderStatus.set(IDOrder, "Prepare to ship");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            } else if (status == 3) {
                                OrderStatus.set(IDOrder, "Shipped");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            }

                        } else if (manageOrder == 200) {
                            printScreen.displayMessage("ID Order : ");
                            int IDOrder = keypad.getInput();
                            OrderAccountID.remove(IDOrder);
                            OrderProductID.remove(IDOrder);
                            OrderProductAmount.remove(IDOrder);
                            OrderStatus.remove(IDOrder);
                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                    OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                    OrderProductAmount,
                                    OrderActive, OrderStatus);

                        } else {
                            manage = false;
                        }
                        break;
                    // Status
                    case 3:
                        printScreen.displayMessageLine("==========|| Status Order ||==========");
                        printScreen.displayMessageLine("");
                        for (int i = 0; i < OrderAccountID.size(); i++) {
                            if (OrderStatus.get(i) != null) {
                                printScreen.displayMessageLine("Order Number : [ " + i + " ]");
                                printScreen.displayMessageLine("");
                                printScreen.displayMessageLine(dataStore.ScreenAllOrderStatusforAdmin(i));
                                printScreen.displayMessageLine("");
                                printScreen.displayMessageLine("--------------------------------------\n");
                            } else {
                                printScreen.displayMessageLine("Order Number : [ " + i + " ]");
                                printScreen.displayMessageLine("");
                                printScreen.displayMessageLine("'The admin hasn't received order yet.'");
                                printScreen.displayMessageLine("");
                                printScreen.displayMessageLine("--------------------------------------\n");
                            }
                        }
                        printScreen.displayMessageLine("[100] - - Change order status");
                        printScreen.displayMessageLine("[200] - - Exit");
                        printScreen.displayMessageLine("");
                        printScreen.displayMessage("Please choose to deal with the Order : ");
                        int manageStatus = keypad.getInput();
                        if (manageStatus == 100) {
                            printScreen.displayMessage("ID Order : ");
                            int IDStatus = keypad.getInput();
                            printScreen.displayMessageLine("\n==========|| Status Order List ||==========\n");
                            printScreen.displayMessageLine("|[1] - - Product inspection");
                            printScreen.displayMessageLine("|[2] - - Prepare to ship");
                            printScreen.displayMessageLine("|[3] - - Shipped");
                            printScreen.displayMessageLine("|[4] - - Exit");

                            printScreen.displayMessageLine("");
                            printScreen.displayMessage("Please select a product status : ");
                            int status = keypad.getInput();
                            if (status == 1) {
                                OrderStatus.set(IDStatus, "Product inspection");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            } else if (status == 2) {
                                OrderStatus.set(IDStatus, "Prepare to ship");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            } else if (status == 3) {
                                OrderStatus.set(IDStatus, "Shipped");
                                dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                        addressAccount, nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);

                                order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                        nameProduct,
                                        detailsProduct, categoryProduct, priceProduct, amountProduct,
                                        nameRecommendedProduct,
                                        OrderAmountRecommendedProduct, OrderAccountID, OrderProductID,
                                        OrderProductAmount,
                                        OrderActive, OrderStatus);
                            }
                        } else {
                            manage = false;
                        }
                        break;
                    // Member
                    case 4:
                        printScreen.displayMessageLine("==========|| Member List ||==========");
                        for (int i = 0; i < dataStore.getMemberAmouts(); i++) {
                            printScreen.displayMessageLine(dataStore.ScreenAllMemberforAdmin(i));
                        }
                        printScreen.displayMessageLine("");
                        printScreen.displayMessageLine("|[100] - - Add Member");
                        printScreen.displayMessageLine("|[200] - - Edit member");
                        printScreen.displayMessageLine("|[300] - - Delete Member");
                        printScreen.displayMessageLine("|[400] - - Exit");
                        printScreen.displayMessageLine("");
                        printScreen.displayMessage("Please choose to deal with the Member : ");
                        int manageAccount = keypad.getInput();
                        if (manageAccount == 100) {
                            printScreen.displayMessageLine("\n============|| Add Member ||============\n");
                            printScreen.displayMessage("Your Name : ");
                            String accountName = sc.nextLine();
                            printScreen.displayMessage("Your Number : ");
                            int accountNumber = sc.nextInt();
                            printScreen.displayMessage("Your pin : ");
                            int accountPin = sc.nextInt();
                            printScreen.displayMessage("Your Tell : ");
                            int accountTell = sc.nextInt();
                            printScreen.displayMessage("Your Address : ");
                            String accountAddress = sc.nextLine();

                            nameAccount.add(accountName);
                            numberAccount.add(accountNumber);
                            pinAccount.add(accountPin);
                            tellAccount.add(accountTell);
                            addressAccount.add(accountAddress);
                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                        } else if (manageAccount == 200) {
                            printScreen.displayMessageLine("\n============|| Edit Member ||============\n");
                            printScreen.displayMessage("Please select an User ID : ");
                            int numberID = keypad.getInput();
                            printScreen.displayMessage("Your Name : ");
                            String accountName = sc.nextLine();
                            printScreen.displayMessage("Your Number : ");
                            int accountNumber = sc.nextInt();
                            printScreen.displayMessage("Your pin : ");
                            int accountPin = sc.nextInt();
                            printScreen.displayMessage("Your Tell : ");
                            int accountTell = sc.nextInt();
                            printScreen.displayMessage("Your Address : ");
                            String accountAddress = sc.nextLine();

                            nameAccount.set(numberID, accountName);
                            numberAccount.set(numberID, accountNumber);
                            pinAccount.set(numberID, accountPin);
                            tellAccount.set(numberID, accountTell);
                            addressAccount.add(accountAddress);

                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                        } else if (manageAccount == 300) {
                            printScreen.displayMessageLine("\n============|| Delete Member ||============\n");
                            printScreen.displayMessage("Please select an User ID : ");
                            int numberID = keypad.getInput();

                            nameAccount.remove(numberID);
                            numberAccount.remove(numberID);
                            pinAccount.remove(numberID);
                            tellAccount.remove(numberID);
                            addressAccount.remove(numberID);

                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                        } else {
                            manage = false;
                        }
                        break;
                    // Recommended Product
                    case 5:
                        printScreen.displayMessageLine("\n==========|| Recommended Product List ||==========\n");
                        for (int i = 0; i < dataStore.getRecommendedProductAmouts(); i++) {
                            printScreen.displayMessageLine(dataStore.ScreenAllRecommended_ProductforAdmin(i));
                        }
                        printScreen.displayMessageLine("");
                        printScreen.displayMessageLine("|[100] - - Add Product");
                        printScreen.displayMessageLine("|[200] - - Edit Product");
                        printScreen.displayMessageLine("|[300] - - Delete Product");
                        printScreen.displayMessageLine("|[400] - - Exit");

                        printScreen.displayMessageLine("");
                        printScreen.displayMessage("Please choose to deal with the product : ");
                        int manageRecommendedProduct = keypad.getInput();
                        if (manageRecommendedProduct == 100) {
                            printScreen.displayMessageLine("\n============|| Add Recommended Product ||============\n");
                            printScreen.displayMessage("Name Product : ");
                            String RecommendedproductName = sc.nextLine();
                            printScreen.displayMessage("Order Amount : ");
                            int OrderAmount = sc.nextInt();

                            nameRecommendedProduct.add(RecommendedproductName);
                            OrderAmountRecommendedProduct.add(OrderAmount);

                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                        } else if (manageRecommendedProduct == 200) {
                            printScreen
                                    .displayMessageLine("\n============|| Edit Recommended Product ||============\n");
                            printScreen.displayMessage("ID Recommended Product : ");
                            int IDRecommemdedproduct = keypad.getInput();
                            printScreen.displayMessage("Name Product : ");
                            String RecommendedproductName = sc.nextLine();
                            printScreen.displayMessage("Details Product : ");
                            int OrderAmount = sc.nextInt();

                            nameRecommendedProduct.set(IDRecommemdedproduct, RecommendedproductName);
                            OrderAmountRecommendedProduct.set(IDRecommemdedproduct, OrderAmount);

                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                        } else if (manageRecommendedProduct == 300) {
                            printScreen
                                    .displayMessageLine("\n============|| Delete Recommended Product ||============\n");
                            printScreen.displayMessage("ID Recommended Product : ");
                            int IDRecommemdedproduct = keypad.getInput();

                            nameRecommendedProduct.remove(IDRecommemdedproduct);
                            OrderAmountRecommendedProduct.remove(IDRecommemdedproduct);

                            dataStore = new DataBase_Store(nameAccount, numberAccount, pinAccount, tellAccount,
                                    addressAccount, nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);

                            order = new Order(nameAccount, numberAccount, pinAccount, tellAccount, addressAccount,
                                    nameProduct,
                                    detailsProduct, categoryProduct, priceProduct, amountProduct,
                                    nameRecommendedProduct,
                                    OrderAmountRecommendedProduct, OrderAccountID, OrderProductID, OrderProductAmount,
                                    OrderActive, OrderStatus);
                        } else {
                            manage = false;
                        }

                        break;
                    // Log Out
                    case 6:
                        show = false;
                        AdminAuthenticated = false;
                        // currentAdminNumber = 0;

                    default:
                        printScreen.displayMessageLine("============================================");
                        printScreen.displayMessageLine("||                                        ||");
                        printScreen.displayMessageLine("||==========|| Good Bye Admin ||==========||");
                        printScreen.displayMessageLine("||                                        ||");
                        printScreen.displayMessageLine("============================================");

                        Choose = 0;
                        run();
                }

            }

        }

    }

}
