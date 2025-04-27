package mylab.order.di.xml;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
    }

    // Getter & Setter
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // 전체 가격 계산
    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
        // 또는 스트림으로 깔끔하게
        // return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart [products=" + products + "]";
    }
}
