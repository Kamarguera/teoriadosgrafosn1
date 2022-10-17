public class Grafo extends Vertice {

    private final int vertices;
    public int[][] matrizDeArestas;

    public int visitada;


    public Grafo(int numerodeVertices) {
        super();
        vertices = numerodeVertices;
        matrizDeArestas = new int[vertices + 1][vertices + 1];

    }

    public void removeAresta(int to, int from) {
        try {
            matrizDeArestas[to][from] = 0;
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
            matrizDeArestas[to][from] = 1;
//            System.out.println(to + " " + from + " " + 1);
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getAresta(int to, int from) {
        try {
            return matrizDeArestas[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public int getAresta2(int to, int from) {
        return matrizDeArestas[to][from];

    }

    Boolean verificaAdjacencia(int vertice1, int vertice2, int numerodeVertices) {

        boolean verticeAdjacente = false;

        for (int i = 1; i <= numerodeVertices; i++) {
            for (int j = 1; j <= numerodeVertices; j++) {
                verticeAdjacente = getAresta(vertice1, vertice2) == 1;

                if (matrizDeArestas[i][j] == 1) {
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
                System.out.printf("origem:%d, i:%d\n", origem, i);

                return true;
            }
        }


        return false;
    }

    public void removeArestaSeElaNaoSeConectaANenhum(int v, int n) {
        if (!verificaSeVerticeSeConectaAAlgum(v, n)) {

            for (int i = 0; i <= n; i++)
                if (getAresta(v, i) == 1) {
                    removeAresta(v, i);

                    System.out.println("removida aresta " + " " + v + " " + i);
                    break;
                }

        }

    }

    String verificaAdjacenciaRetornandoCaminhoTest(int v1, int v2, int n) {


        int iterador = 0;

        String resultado = "Caminho percorrido: ";


        for (int i = v1; i <= n; i++) {
//            if (!verificaSeVerticeSeConectaAAlgum(i, n)) {
//                System.out.println("ok");
//                break;
//            }
            for (int j = 1; j <= n; j++) {


                if (getAresta2(i, j) == 1) {

                    String aresta = "i" + i + " j" + j + ":" + getAresta(i, j);
                    System.out.println(aresta);

                    String verificaSeVerticeSeConectaAAlgum = String.valueOf((!verificaSeVerticeSeConectaAAlgum(j, n)));

                    System.out.println(verificaSeVerticeSeConectaAAlgum);


                    removeArestaSeElaNaoSeConectaANenhum(j, n);

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

        System.out.println("j " + iterador);
        resultado = "Caminho percorrido: \n " + resultado;

        if (iterador != v2) {
            resultado = "Não é possível alcançar o vértice nº: " + v2 + " partindo de vértice " + v1;
        } else {
            System.out.println(resultado);
        }

        return resultado;
    }


    int retornaOPrimeiroVerticeAoQualUmVerticeSeConecta(int verticeDePartida, int numeroDeVerticesExistentes) {
        int verticeDestino = 0;



        for (int i = 1; i <= numeroDeVerticesExistentes; i++) {
            if (getAresta(verticeDePartida, i) == 1) {
                verticeDestino = i;
                System.out.println("o vertice " + verticeDePartida + " se conecta ao " + verticeDestino);

                break;


            }

        }


        return verticeDestino;
    }


    int verificaAdjacenciaRecursiva(int v1, int v2, int n) {


        int retorno = retornaOPrimeiroVerticeAoQualUmVerticeSeConecta(v1, n);

        if (v1 < 0) {
            System.out.println("não há como alcançar o destino a partindo-se do vertice selecionado");
            return 0;
        }


        ; //2
        if (retorno == 0 //nao se conecta a nenhum
                && retorno != v2) {// nao se conectou ao vertice final)
            eliminaArestaDoUltimoAoPrimeiroSeNaoExistirCaminhoAdicional(v1, n);


            //se nao se conectar ate o vertice final
            //eliminar o caminho que nao se conecta ao vertice final
            //até o ponto onde o vertice possuir apenas um caminho
            //e iniciar novamente o caminho  partindo de v1

//            System.out.println(retorno);
            retorno = v1 - 1;

        }

        if (retorno == v2) {//nao se conecta a nenhum
            return 0;
        }


        return verificaAdjacenciaRecursiva(retorno, v2, n);
    }


    public void eliminaArestaDoUltimoAoPrimeiroSeNaoExistirCaminhoAdicional(int verticeDePartida, int numerodeVertices) {

        for (int i = verticeDePartida; i >= 1; i--) {

            if (getAresta(i, verticeDePartida) == 1) {
                matrizDeArestas[i][verticeDePartida] = 0;
                System.out.println("eliminada aresta " + i + " " + verticeDePartida);
            }
        }

    }


}