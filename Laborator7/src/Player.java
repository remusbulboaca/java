import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private String name;
    private Board board;
    private List<Token> tokenList;

    public Player(String name, Board board) {
        this(name);
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player(String name) {
        this.name = name;
        this.tokenList = new ArrayList<>();
        this.tokenList = Collections.synchronizedList(tokenList);
    }

    public synchronized Token extractToken() {
        if (!board.tokenList.isEmpty()) {
            Token tokenX = board.tokenList.get(0);
            board.tokenList.remove(0);
            return tokenX;
        }
        return null;
    }

    @Override
    public synchronized void run() {
        Token tokenNou = extractToken();
        while (tokenNou != null) {
            System.out.println(this.name + " extrage: " + tokenNou.getValue());
            this.tokenList.add(tokenNou);
            tokenNou = extractToken();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
