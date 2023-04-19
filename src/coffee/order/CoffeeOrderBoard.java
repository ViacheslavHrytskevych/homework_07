package coffee.order;

import java.util.ArrayList;

public class CoffeeOrderBoard {

    private ArrayList<Order> orderList = new ArrayList<>();
    private int currentNumber = 1;

    public Order add(String customerName) {
        Order order = new Order(currentNumber++, customerName);
        orderList.add(order);
        return order;
    }

    public Order deliver() {
        if (orderList.isEmpty()) {
            return null;
        }
        Order order = orderList.get(0);
        orderList.remove(0);
        return order;
    }

    public Order deliver(int orderNumber) {
        Order orderToDeliver = null;
        int indexToDeliver = -1;
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getOrderNumber() == orderNumber) {
                orderToDeliver = order;
                indexToDeliver = i;
                break;
            }
        }
        if (orderToDeliver != null) {
            orderList.remove(indexToDeliver);
        }
        return orderToDeliver;
    }

    public void draw() {
        System.out.println("NUN | NAME");
        for (Order order : orderList) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());

        }
    }
}
