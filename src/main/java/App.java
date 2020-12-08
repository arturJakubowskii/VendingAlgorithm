import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int amount = 0;
        int userAmount = 0;

        HashMap<Integer, Integer> products = new HashMap<>();
        HashMap<Integer, Integer> machineCoinQuantity = new HashMap<>();

        List<Integer> providedCoins = new ArrayList<>();
        List<Integer> acceptedCoins = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        fillTheArray(acceptedCoins);
        fillTheHashMaps(machineCoinQuantity, products);

        int i = 0;
        do{
            System.out.println("1.Water 0.80  2.Sandwich 1.50  3.Chocolate 2.20  4.Chips 5");
            int product = scanner.nextInt();
            paymentSystem(amount, products, machineCoinQuantity, providedCoins, acceptedCoins, scanner, product);
            changeSystem(userAmount, products, machineCoinQuantity, providedCoins, acceptedCoins, product);
            i++;
        }
        while (i < 10);

    }




    public static void changeSystem(int userAmount, HashMap<Integer, Integer> products, HashMap<Integer, Integer> machineCoinQuantity, List<Integer> providedCoins, List<Integer> acceptedCoins, int product) {
        int change = setChange(userAmount, products, providedCoins, product);
        if(change == 0){
            System.out.println("No change needed");
        }else{

            while(change != 0){
                for (int acceptedCoin : acceptedCoins){
                    acceptedCoin *= 10;

                    if (change - acceptedCoin >= 0){
                        change -= acceptedCoin;
                        System.out.println(acceptedCoin);

//                        for (Integer value : machineCoinQuantity.values()){
//                            if (value <= 0){
//                                System.out.println("poszlo na 0");
//                            }
//                        }
                        machineCoinQuantity.put(acceptedCoin, machineCoinQuantity.get(acceptedCoin) - 1);
                    }
                }
            }
        }
    }

    public static int setChange(int userAmount, HashMap<Integer, Integer> products, List<Integer> providedCoins, int product) {
        int productValue = products.get(product);
        for (int coin : providedCoins){
            userAmount+= coin;
        }
        // we need to clear the list, if we don't do that
        // userAmount will be growing with previous arguments
        providedCoins.clear();
        return Math.abs(productValue - userAmount);
    }

    public static void paymentSystem(int amount, HashMap<Integer, Integer> products, HashMap<Integer, Integer> machineCoinQuantity, List<Integer> providedCoins, List<Integer> acceptedCoins, Scanner scanner, int product) {

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

//            if (coinAmountFlag = false){
//                System.out.println("Machine can't give you change." +
//                        " Please insert equal amount of money for chosen product");
//                paymentSystem(amount, products, machineCoinQuantity, providedCoins, acceptedCoins, scanner, product);
//            }

            machineCoinQuantity.put(coin, machineCoinQuantity.get(coin) + 1); // increments coin quantity by 1
        }

    }

    public static void fillTheArray(List<Integer> acceptedCoins) {
        acceptedCoins.add(1);
        acceptedCoins.add(2);
        acceptedCoins.add(5);
        acceptedCoins.add(10);
        acceptedCoins.add(20);
        acceptedCoins.add(50);
    }

    public static void fillTheHashMaps(HashMap<Integer, Integer> machineCoinQuantity, HashMap<Integer, Integer> products) {
        machineCoinQuantity.put(0,123);
        machineCoinQuantity.put(10, 5); // coin value, quantity
        machineCoinQuantity.put(20, 4);
        machineCoinQuantity.put(50, 4);
        machineCoinQuantity.put(100, 3);
        machineCoinQuantity.put(200, 3);
        machineCoinQuantity.put(500, 3);

        products.put(1, 80);
        products.put(2, 150);
        products.put(3, 220);
        products.put(4, 500);
    }
}
