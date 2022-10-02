import java.util.Scanner;

public class Representa_Grafo_Matriz_Adjacente {
    private final int vertices;
    public int[][] matriz_adjacente;

    public Representa_Grafo_Matriz_Adjacente(int v) {
        vertices = v;
        matriz_adjacente = new int[vertices + 1][vertices + 1];
    }

    public void makeAresta(int destino, int origem, int aresta) {
        try {
            matriz_adjacente[destino[origem] = aresta;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Os vertices não existem");
        }
    }

    public int getAresta(int destino, int origem) {
        try {
            return matriz_adjacente[destino][origem];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Os vertices não existem");
        }
        return -1;
    }
}

