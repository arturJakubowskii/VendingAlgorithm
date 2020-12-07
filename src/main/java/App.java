import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("1.Water 0.80  2.Sandwich 1.50  3.Chocolate 2.20  4.Chips 5");

        List<Integer> providedCoins = new ArrayList<>();

        List<Integer> acceptedCoins = new ArrayList<>();
        acceptedCoins.add(1);
        acceptedCoins.add(2);
        acceptedCoins.add(5);
        acceptedCoins.add(10);
        acceptedCoins.add(20);
        acceptedCoins.add(50);

        HashMap<Integer, Integer> machineCoinQuantity = new HashMap<>();
        machineCoinQuantity.put(10, 5); // coin value, quantity
        machineCoinQuantity.put(20, 4);
        machineCoinQuantity.put(50, 4);
        machineCoinQuantity.put(100, 3);
        machineCoinQuantity.put(200, 2);
        machineCoinQuantity.put(500, 1);


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

            if (coin <= 5 && coin != 0){ // makes coins 1, 2 and 5 a hundredths
                coin *= 100;
            }

            amount+= coin;
            providedCoins.add(coin);

            machineCoinQuantity.put(coin, machineCoinQuantity.get(coin) + 1); // increments coin quantity by 1
        }




        /*
        CHANGE SYSTEM
         */

        /*
        TODO
        1. check if coin quantity is less than 3, if so make user input full price
        2. refactor code
         */

        int productValue = products.get(product);
        int userAmount = 0;

        for (int coin : providedCoins){
            userAmount+= coin;
        }

        int change = Math.abs(productValue - userAmount);
        int chnageByCoin;

        if(change == 0){
            System.out.println("No change needed");
        }else{

            while(change != 0){
                for (int acceptedCoin : acceptedCoins){
                    acceptedCoin *= 10;

                    if (change - acceptedCoin >= 0){
                        chnageByCoin = acceptedCoin;
                        change -= acceptedCoin;

                        machineCoinQuantity.put(chnageByCoin, machineCoinQuantity.get(chnageByCoin) - 1);
                    }
                }
            }
        }


    }
}
