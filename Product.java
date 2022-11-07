public class Product {
    private int id;
    private String nameProduct;
    private String detailsProduct;
    private String category;
    private double price;
    private int amount;

    public Product(int id,String nameProduct, String detailsProduct,String category, double price,int amount) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.detailsProduct = detailsProduct;
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
     return id;
    }
    public String getProductName() {
        return nameProduct;
    }
    public String getDetailsProduct() {
        return detailsProduct;
    }

    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }
   
    public int getAmount() {
        return amount;
    }


}
