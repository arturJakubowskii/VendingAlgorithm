import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("1.Water 0.80  2.Sandwich 1.50  3.Chocolate 2.20  4.Chips 5");

        List<Integer> providedCoins = new ArrayList<>();

        List<Integer> acceptedCoins = new ArrayList<>();
        acceptedCoins.add(10);
        acceptedCoins.add(20);
        acceptedCoins.add(50);
        acceptedCoins.add(100);
        acceptedCoins.add(200);
        acceptedCoins.add(500);

        HashMap<String, Integer> machineCoinQuantity = new HashMap<>();
        machineCoinQuantity.put("tens", 5);
        machineCoinQuantity.put("twenties", 4);
        machineCoinQuantity.put("fifties", 4);
        machineCoinQuantity.put("one", 3);
        machineCoinQuantity.put("two", 2);
        machineCoinQuantity.put("five", 1);


        HashMap<Integer, Integer> products = new HashMap<>();
        products.put(1, 80);
        products.put(2, 150);
        products.put(3, 220);
        products.put(4, 500);




        /*
        COIN INPUT SYSTEM
         */
        Scanner scanner = new Scanner(System.in);
        int product = scanner.nextInt();
        int amount = 0;


        while (amount < products.get(product)){
            int coin = scanner.nextInt();

            if (!acceptedCoins.contains(coin)){ // checks if coin from input is valid (in acceptedCoins)
                coin = 0;
                System.out.println("Wrong coin");
            }

            amount+= coin;
            providedCoins.add(coin);
        }




        /*
        CHANGE SYSTEM
         */


    }
}
