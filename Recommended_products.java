public class Recommended_products {
    private String Recommended_productsName;
    private int OrderAmount;

    public Recommended_products(String Recommended_productsName,int OrderAmount) {
        this.Recommended_productsName = Recommended_productsName;
        this.OrderAmount = OrderAmount;
    }
    
    public int getOrderAmount() {
        return OrderAmount;
    }
    public String getRecommended_productsName() {
        return Recommended_productsName;
    }
}
