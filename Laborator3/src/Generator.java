import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public Generator(Knapsack knapsack, List<Item> items) {
        List<Item> listaInit = new ArrayList<>();
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        Food food3 = new Food("Carnati", 1, 5);
        Food food4 = new Food("Mici", 2, 10);
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);
        Weapon weapon2 = new Weapon(Weapon.WeaponType.PISTOL, 2, 4);
        Weapon weapon3 = new Weapon(Weapon.WeaponType.SWORD, 3, 4);
        Weapon weapon4 = new Weapon(Weapon.WeaponType.RIFLE, 5, 9);
        Weapon weapon5 = new Weapon(Weapon.WeaponType.PISTOL, 3, 3);
        listaInit.add(book1);
        listaInit.add(book2);
        listaInit.add(food1);
        listaInit.add(food2);
        listaInit.add(food3);
        listaInit.add(food4);
        listaInit.add(weapon);
        listaInit.add(weapon2);
        listaInit.add(weapon3);
        listaInit.add(weapon4);
        listaInit.add(weapon5);

        //facem o instanta a clasei Random
        Random random = new Random();
        int low = 2;
        int high = 10;
        int rezultatRand = random.nextInt(high - low) + low; // sursa geekforgeeks
        knapsack.setCapacity(rezultatRand);

        //generam obiectele

        for(int i=0;i<rezultatRand*2;i++){
            items.add(listaInit.get(random.nextInt(listaInit.size())));
        }

        knapsack.setItems(items);



    }
}
