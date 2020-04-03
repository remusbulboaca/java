import java.lang.reflect.Array;
import java.util.*;

public class Greedy implements Algorithm {
    private List<Item> solutie = new ArrayList<>();

    public Greedy(Knapsack knapsack, List<Item> items) {
        List<Item> listatemporara = new ArrayList<>();
        listatemporara.addAll(items);

        /*Afisam lista nesortata*/
        System.out.println("Lista nesortata: ");
        for (int i = 0; i < listatemporara.size(); i++) {
            System.out.println(listatemporara.get(i));
        }
        System.out.println();

        /*Afisam lista sortata*/
        System.out.println("Lista sortata dupa profitFactor:");
        Collections.sort(listatemporara, new SortByProfit());
        for (int i = 0; i < listatemporara.size(); i++) {
            System.out.println(listatemporara.get(i));
        }
        System.out.println();

        /* Introducem primele elemente in lista finala */
        int iterator = 0;
        double capacitate = knapsack.getCapacity();
        //System.out.println(capacitate);
        while (capacitate >= listatemporara.get(iterator).getWeight()) {
            solutie.add(listatemporara.get(iterator));
            capacitate = capacitate - listatemporara.get(iterator).getWeight();
            iterator = iterator + 1;
        }
    }

    public List<Item> getSolutie() {
        return solutie;
    }

    @Override
    public String toString() {
        return "Greedy{" +
                "solutie=" + solutie +
                '}';
    }
}
