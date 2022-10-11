package footlocker.shoppingcart.cart;



public class CartDto {

    private String sku;

    private int quantity;

    public CartDto() {
    }

    public CartDto(String productId, int quantity) {
        this.sku = productId;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
