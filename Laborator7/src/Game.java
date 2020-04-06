import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public static void situatiePlayeri(Player player) {
        List<Integer> listaSortata = new ArrayList<>();
        System.out.println("Jucatorul: " + player.getName() + " detine urmatoarele fise: ");
        player.getTokenList().forEach(token -> System.out.print(token.getValue() + " "));
        player.getTokenList().forEach(token -> listaSortata.add(token.getValue()));
        Collections.sort(listaSortata);
        System.out.println();
        System.out.print("Lista ordonata: ");
        System.out.print(listaSortata);
        System.out.println();

    }

    /*public static void scor(List<Integer> lista, Player player){
        for(int i=0;i<lista.size();i++){

        }
    }*/


    public static void main(String Args[]) throws InterruptedException {
        final Board board = new Board(10);
        board.generateTokens();

        final Player player1 = new Player("Alex", board);
        final Player player2 = new Player("Ioana", board);

        final Thread thread1 = new Thread(player1);
        final Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        situatiePlayeri(player1);
        situatiePlayeri(player2);

    }
}
