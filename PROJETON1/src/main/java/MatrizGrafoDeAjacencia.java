public class MatrizGrafoDeAjacencia {
    private final int vertices;
    public int[][] matrizDeAjacencia;

    public MatrizGrafoDeAjacencia(int v) {
        vertices = v;
        matrizDeAjacencia = new int[vertices + 1][vertices + 1];
    }


    public void makeEdge(int to, int from, int edge) {
        try {
            matrizDeAjacencia[to][from] = edge;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getAresta(int to, int from) {
        try {
            return matrizDeAjacencia[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}

