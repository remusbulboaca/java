import java.util.Comparator;

class SortByProfit implements Comparator<Item> {
    public int compare(Item a, Item b){
        if(a.profitFactor()>b.profitFactor()){
            return -1;
        }else {
            return 1;
        }
    }
}
