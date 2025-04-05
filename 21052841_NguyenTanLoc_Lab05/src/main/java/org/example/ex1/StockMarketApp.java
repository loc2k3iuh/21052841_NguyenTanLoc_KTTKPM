package org.example.ex1;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(double price);
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject (Cổ phiếu thực tế)
class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Observer> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    // Cập nhật giá cổ phiếu và thông báo cho tất cả các nhà đầu tư
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public String getSymbol() {
        return symbol;
    }
}

// Concrete Observer (Nhà đầu tư thực tế)
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received update: New stock price is " + price);
    }
}

// Main class
public class StockMarketApp {
    public static void main(String[] args) {

        // Tạo cổ phiếu
        Stock googleStock = new Stock("GOOGL", 1500.00);

        // Tạo nhà đầu tư
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        // Đăng ký nhà đầu tư với cổ phiếu
        googleStock.registerObserver(investor1);
        googleStock.registerObserver(investor2);

        // Thay đổi giá cổ phiếu và thông báo cho các nhà đầu tư
        googleStock.setPrice(1550.00);
        googleStock.setPrice(1600.00);

        // Hủy đăng ký nhà đầu tư 1
        googleStock.removeObserver(investor1);

        // Thay đổi giá cổ phiếu một lần nữa
        googleStock.setPrice(1650.00);
    }
}
