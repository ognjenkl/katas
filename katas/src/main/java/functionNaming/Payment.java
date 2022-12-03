package functionNaming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Payment {
    Map<String, Double> pricesMap;

    public Payment() {
        pricesMap = new HashMap<>();
        pricesMap.put("burger", 10.0);
        pricesMap.put("fries", 5.0);
        pricesMap.put("shake", 5.0);
        pricesMap.put("combo", 20.0);
        pricesMap.put("drink", 2.0);
        pricesMap.put("salad", 15.0);

    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.orderFood(List.of("burger", "fries", "shake"));
    }


    private void orderFood(List<String> itemList) {
        double total = 0;
        for (String item : itemList) {
            total += pricesMap.get(item);
        }

        System.out.printf("Total: $%.2f\n", total);

        StripePaymentHandler paymentHandler = new StripePaymentHandler();
        paymentHandler.handlePayment(total);

        System.out.println("Order completed.");
    }

    class StripePaymentHandler {
        void handlePayment(double amount) {
            System.out.printf("Charging $%.2f using Stripe\n", amount);
        }
    }
}
