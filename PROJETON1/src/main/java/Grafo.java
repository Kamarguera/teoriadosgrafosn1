public class Grafo extends Vertice {

    private final int vertices;
    public int[][] arestas;


    public Grafo(int numerodeVertices) {
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


        int iterador = 0;

/////////////////objetivo caminho do 1  até o 7///////////////////
///////////////objetivo caminho do 1  até o 7///////////////////
//        aresta.criaAresta(1, 3);
//        aresta.criaAresta(3, 7);
//
//        aresta.criaAresta(1, 2);
//        aresta.criaAresta(2, 4);
//        aresta.criaAresta(4, 5);


//        StringBuilder stringBuilder = new StringBuilder(100);
//
//        stringBuilder.append("Iniciou em " + v1);
//
//        System.out.println(stringBuilder);
//
//        stringBuilder.append(", " + j);
//
//        System.out.println(stringBuilder);

        String resultado = "Caminho percorrido: ";


        for (int i = v1; i <= n; i++) {
            if (!verificaSeVerticeSeConectaAAlgum(i, n)) {
                      System.out.println("ok");
                break;
            }
            for (int j = 1; j <= n; j++) {

                if (getAresta2(i, j) == 1) {


//                    System.out.printf("%d,%d", i, j);

                    resultado = resultado + i + ", " + j + " \n ";

                    i = j;
//                    System.out.println(" break");

                    if (!verificaSeVerticeSeConectaAAlgum(j, n) && j != v2) {
//                        System.out.println(j);
//                        System.out.printf("o vertice %d se conecta com outro vertice:%b\n", j, verificaSeVerticeSeConectaAAlgum(j, n));


                        resultado = "";
                        removePrimeiraArestaAdjacente(v1, n);
                        i = 1;
                        j = 1;
                    }

                    iterador = j;

//                    break;
                }

            }
//            break;

        }

        System.out.println("j aaaaaaaaaaaaaa" + iterador);
        resultado = "Caminho percorrido: \n " + resultado;

        if (iterador != v2) {
            resultado = "Não é possível chegar no vértice nº:"
                    + v2 + "partindo de vértice" + v1;
        } else {
            System.out.println(resultado);
        }

        return resultado;
    }
}