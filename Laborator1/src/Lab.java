import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Lab {
    private Stack<Integer> stack;
    public Lab()
    {
        stack = new Stack<Integer>();
    }

    public void dfs(int adjacency_matrix[][])
    {
        
        int numar_noduri = adjacency_matrix[0].length;
        int vizitat[] = new int[numar_noduri];
        int cc = 0;
        for  (int varf = 0; varf < numar_noduri; varf++)
        {
            if (vizitat[varf] == 0)
            {
                int element = varf;
                int i = varf;
                vizitat[varf] = 1;
                cc++;
                stack.push(varf);
                while (!stack.isEmpty())
                {
                    element = stack.peek();
                    i = element;
                    while (i < numar_noduri)
                    {
                        if (adjacency_matrix[element][i] == 1 && vizitat[i] == 0)
                        {
                            stack.push(i);
                            vizitat[i] = 1;
                            element = i;
                            i = 1;
                            continue;
                        }
                        i++;
                    }
                    stack.pop();
                }
            }
        }
        System.out.println("Numarul total de componente conexe este: " + cc);
    }

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
            Lab app = new Lab();
            String word = app.CreateRandomWord(k, alfabet);
            cuvinte[j] = word;
            //System.out.println(word);
        }

        /* Afisam cuvintele generate */

        System.out.println("Cuvintele generate sunt:");

        for (int j = 0; j < cuvinte.length; j++) {
            System.out.println(cuvinte[j]);
        }


        //matrice adiacenta cuvinte

        int matrix[][] = new int[n][n];

        for (int i = 0; i < cuvinte.length; i++) {
            for (int j = 0; j < cuvinte.length; j++) {
                int comparator = 0;

                //comparam prima litera din primul cuvant cu celelalte litere apoi avansam
                for (int f = 0; f < k; f++) {
                    for (int g = 0; g < k; g++) {
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
        /* afisam matricea de adiacenta */
        System.out.println("Matricea de adiacenta este: ");
        for (int i = 0; i < cuvinte.length; i++) {
            for (int j = 0; j < cuvinte.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        /*calculam componentele conexe*/
        Lab lab = new Lab();
        lab.dfs(matrix);

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
