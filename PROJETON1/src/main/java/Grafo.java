public class Grafo extends Vertice {

    private final int vertices;
    public int[][] arestas;


    public Aresta(int numerodeVertices) {
        super();
        vertices = numerodeVertices;
        arestas = new int[vertices + 1][vertices + 1];

    }

    public void removeAresta(int to, int from) {
        try {
            arestas[to][from] = 0;
//            System.out.println(to + " " + from + " " + 1);
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }


    public void removePrimeiraArestaAdjacente(int v, int n) {
// Retorna a próxima aresta que o vértice v participa ou
// null se a lista de adjacência de v estiver no fim
        if (verificaSeVerticeSeConectaAAlgum(v, n)) {


            for (int i = v; i <= n; i++)
                if (getAresta(v, i) == 1) {
                    removeAresta(v, i);

                    System.out.println("removida aresta " + " " + v + " " + i);
                    break;
                }

        }
    }


    public void criaAresta(int to, int from) {
        try {
            arestas[to][from] = 1;
//            System.out.println(to + " " + from + " " + 1);
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getAresta(int to, int from) {
        try {
            return arestas[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public int getAresta2(int to, int from) {
        return arestas[to][from];

    }

    Boolean verificaAdjacencia(int vertice1, int vertice2, int numerodeVertices) {

        boolean verticeAdjacente = false;

        for (int i = 1; i <= numerodeVertices; i++) {
            for (int j = 1; j <= numerodeVertices; j++) {
                verticeAdjacente = getAresta(vertice1, vertice2) == 1;

                if (arestas[i][j] == 1) {
                    System.out.printf("caminho que passou: %d\n", j);
                }
            }

        }

        return verticeAdjacente;
    }

    int verificaAdjacenciaRetornandoCaminho(int vertice1, int vertice2, int numerodeVertices) {

        int verticeAdjacente = 0;

        for (int i = 1; i <= numerodeVertices; i++)
            for (int j = 1; j <= numerodeVertices; j++)
                if (getAresta2(vertice1, vertice2) == 1) {
                    verticeAdjacente = vertice2;
//                    System.out.println(" vertice1: " + vertice1 + " vertice2: " + vertice2);

                }


        return verticeAdjacente;
    }


    boolean verificaSeVerticeSeConectaAAlgum(int origem, int n) {

        for (int i = origem; i <= n; i++) {
            if (getAresta(origem, i) == 1) {
//                System.out.printf("origem:%d, i:%d\n", origem, i);

                return true;
            }
        }


        return false;
    }


    String verificaAdjacenciaRetornandoCaminhoTest(int v1, int v2, int n) {


    }
}