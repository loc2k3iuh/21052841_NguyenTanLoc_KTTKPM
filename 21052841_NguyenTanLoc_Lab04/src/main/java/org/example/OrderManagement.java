package org.example;

// Interface cho trạng thái đơn hàng
interface OrderState {
    void handleOrder(OrderContext context);
}

// Trạng thái: Mới tạo
class NewOrderState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Kiểm tra thông tin đơn hàng...");
        context.setState(new ProcessingState());
    }
}

// Trạng thái: Đang xử lý
class ProcessingState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Đóng gói và vận chuyển...");
        context.setState(new DeliveredState());
    }
}

// Trạng thái: Đã giao
class DeliveredState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Cập nhật trạng thái: Đã giao!");
    }
}

// Trạng thái: Hủy đơn
class CancelledState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Hủy đơn hàng và hoàn tiền!");
    }
}

// Context: Quản lý trạng thái đơn hàng
class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void processOrder() {
        state.handleOrder(this);
    }
}

// Strategy Pattern: Xử lý phương thức thanh toán
interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Thanh toán qua PayPal.");
    }
}

// Decorator Pattern: Thêm tính năng cho đơn hàng
interface Order {
    String getDescription();
    double getCost();
}

class BasicOrder implements Order {
    public String getDescription() {
        return "Đơn hàng cơ bản";
    }
    public double getCost() {
        return 100.0;
    }
}

abstract class OrderDecorator implements Order {
    protected Order decoratedOrder;
    public OrderDecorator(Order order) {
        this.decoratedOrder = order;
    }
    public String getDescription() {
        return decoratedOrder.getDescription();
    }
    public double getCost() {
        return decoratedOrder.getCost();
    }
}

class GiftWrap extends OrderDecorator {
    public GiftWrap(Order order) {
        super(order);
    }
    public String getDescription() {
        return super.getDescription() + " + Gói quà";
    }
    public double getCost() {
        return super.getCost() + 20.0;
    }
}

class Insurance extends OrderDecorator {
    public Insurance(Order order) {
        super(order);
    }
    public String getDescription() {
        return super.getDescription() + " + Bảo hiểm";
    }
    public double getCost() {
        return super.getCost() + 50.0;
    }
}

// Main: Kiểm thử hệ thống
public class OrderManagement {
    public static void main(String[] args) {
        // Test State Pattern
        OrderContext order = new OrderContext();
        order.processOrder(); // Chuyển sang Đang xử lý
        order.processOrder(); // Chuyển sang Đã giao
        order.processOrder(); // Không thay đổi nữa

        // Test Strategy Pattern
        PaymentStrategy payment = new CreditCardPayment();
        payment.pay();

        payment = new PayPalPayment();
        payment.pay();

        // Test Decorator Pattern
        Order myOrder = new BasicOrder();
        myOrder = new GiftWrap(myOrder);
        myOrder = new Insurance(myOrder);

        System.out.println("Mô tả: " + myOrder.getDescription());
        System.out.println("Tổng giá: " + myOrder.getCost() + " VND");
    }
}
