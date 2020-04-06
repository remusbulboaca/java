import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(12);
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        Food food3 = new Food("Carnati",1,5);
        Food food4 = new Food("Mici",2,10);
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);
        List<Item> items = new ArrayList<>();
        items.add(weapon);
        items.add(book1);
        items.add(food1);
        items.add(book2);
        items.add(food3);
        items.add(food4);
        items.add(food2);

        Greedy greedy = new Greedy(knapsack,items);
        System.out.println(greedy);

        //Dynamic dynamic = new Dynamic(knapsack,items);

        /*Knapsack knapsackNou = new Knapsack();
        List<Item> listaGenerator = new ArrayList<>();
        Generator generator = new Generator(knapsackNou,listaGenerator);
        System.out.println(knapsackNou);
        */








    }
}
