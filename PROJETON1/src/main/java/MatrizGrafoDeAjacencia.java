public class MatrizGrafoDeAjacencia {
    private final int vertices;
    public int[][] adjacency_matrix;

    public MatrizGrafoDeAjacencia(int v) {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }


    public void makeEdge(int to, int from, int edge) {
        try {
            adjacency_matrix[to][from] = edge;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int to, int from) {
        try {
            return adjacency_matrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}

