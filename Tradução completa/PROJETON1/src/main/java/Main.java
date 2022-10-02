import java.util.Scanner;

public class Main {


    public static void main(String args[]) {
        int v, e, count = 1, origem = 0, destino = 0;
        Scanner sc = new Scanner(System.in);
        Representa_Grafo_Matriz_Adjacente graph;
        try {
            System.out.println("insira o número de vertices: ");
            v = sc.nextInt();
            System.out.println("insira o número de arestas: ");
            e = sc.nextInt();

            graph = new Representa_Grafo_Matriz_Adjacente(v);

            System.out.println("Insira as arestas: <destino> <origem>");
            while (count <= e) {
                origem = sc.nextInt();
                destino = sc.nextInt();

                graph.makeAresta(origem, destino, 1);
                count++;
            }

            System.out.println("A Matriz adjacente para o dado grafo é: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 1; i <= v; i++) {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++)
                    System.out.print(graph.getAresta(i, j) + " ");
                System.out.println();
            }

        } catch (Exception E) {
            System.out.println("Algo deu errado!!!");
        }

        sc.close();
    }

}
