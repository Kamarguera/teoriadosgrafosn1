public class Aresta {

    private final int vertices;
    public int[][] arestas;


    public Aresta(int numerodeVertices) {
        vertices = numerodeVertices;
        arestas = new int[vertices + 1][vertices + 1];

    }


    public void criaAresta(int to, int from) {
        try {
            arestas[to][from] = 1;
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

    Boolean verificaAdjacencia(int vertice1, int vertice2, int numerodeVertices) {

        boolean verticeAdjacente = false;

        for (int i = 1; i <= numerodeVertices; i++) {
            for (int j = 1; j <= numerodeVertices; j++) {
                verticeAdjacente = getAresta(vertice1, vertice2) == 1;
            }

        }

        return verticeAdjacente;
    }


    public String exibirCaminhoAPartirDeDoisVertices(int vertice1,
                                                     int vertice2,
                                                     int numerodeVertices) {


        for (int i = 1; i <= numerodeVertices; i++) {
            for (int j = 1; j <= numerodeVertices; j++) {


            }

        }
        return null;

    }
}