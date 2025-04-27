package mylab.order.di.xml;

public class OrderService {
    private ShoppingCart shoppingCart;

    public OrderService() {
    }

    // Getter & Setter
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // 주문 총액 계산
    public double calculateOrderTotal() {
        return shoppingCart.getTotalPrice();
    }

    @Override
    public String toString() {
        return "OrderService [shoppingCart=" + shoppingCart + "]";
    }
}
