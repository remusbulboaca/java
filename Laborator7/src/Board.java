import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private int index;
    private int nrToken;
    List<Token> tokenList;

    public Board(int nrToken) {
        this.index = 0;
        this.nrToken = nrToken;
        this.tokenList = new ArrayList<>();
    }

    public void generateTokens() {
        for (int i = 1; i <= nrToken; i++) {
            tokenList.add(new Token(i));
        }
        Collections.shuffle(tokenList);
        this.tokenList = Collections.synchronizedList(tokenList);
    }

    public int getNrToken() {
        return nrToken;
    }

    public void setNrToken(int nrToken) {
        this.nrToken = nrToken;
    }
}
