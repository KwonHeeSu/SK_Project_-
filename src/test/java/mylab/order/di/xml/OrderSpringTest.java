package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
    private ShoppingCart cart;

    @Autowired
    private OrderService service;

    @Test
    public void testShoppingCart() {
        assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());

        for (Product p : cart.getProducts()) {
            System.out.println(p);
        }

        double totalPrice = cart.getTotalPrice();
        System.out.println("총 합계 금액: " + totalPrice);
        assertEquals(2500.0, totalPrice, 0.001);
    }

    @Test
    public void testOrderService() {
        assertNotNull(service);
        assertNotNull(service.getShoppingCart());

        double orderTotal = service.calculateOrderTotal();
        System.out.println("주문 총 금액: " + orderTotal);
        assertEquals(2500.0, orderTotal, 0.001);
    }
}
