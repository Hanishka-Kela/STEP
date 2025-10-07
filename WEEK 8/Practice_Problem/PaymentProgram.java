interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to UPI");
    }
}

public class PaymentProgram {
    public static void main(String[] args) {
        PaymentGateway creditCard = new CreditCardPayment();
        creditCard.pay(1500);
        creditCard.refund(300);

        PaymentGateway upi = new UPIPayment();
        upi.pay(800);
        upi.refund(100);
    }
}
