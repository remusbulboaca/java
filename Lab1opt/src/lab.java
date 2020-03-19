import java.util.Random;

public class lab {
    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println("Numar,Numar, sir de caractere!");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char alfabet[] = new char[m];
        for (int i = 0; i < m; i++) {
            alfabet[i] = args[i + 2].charAt(0);
        }

        String cuvinte[] = new String[n];
        for (int j = 0; j < cuvinte.length; j++) {
            lab app = new lab();
            String word = app.CreateRandomWord(4, alfabet);
            cuvinte[j] = word;
            //System.out.println(word);
        }


        for (int j = 0; j < cuvinte.length; j++) {
            System.out.println(cuvinte[j]);
        }


        //matrice adiacenta cuvinte

        int matrix[][] = new int[n][n];

        for (int i = 0; i < cuvinte.length; i++) {
            for (int j = 0; j < cuvinte.length; j++) {
                int comparator = 0;

                //comparam prima litera din primul cuvant cu celelalte litere apoi avansam
                for (int f = 0; f < 4; f++) {
                    for (int g = 0; g < 4; g++) {
                        if ((cuvinte[i].charAt(f))==(cuvinte[j].charAt(g))) {
                            comparator = 1;
                        }
                    }
                }

                //am gasit un match de litere similare modificam in matricea de adiacenta
                if (comparator == 1) {
                    matrix[i][j] = 1;
                }

                comparator = 0;
            }
        }

        for (int i = 0; i < cuvinte.length; i++) {
            for (int j = 0; j < cuvinte.length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    public String CreateRandomWord(int len, char[] alfabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alfabet.length);
            word.append(alfabet[k]);
        }
        return word.toString();
    }
}
