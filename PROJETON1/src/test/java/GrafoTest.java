import org.junit.Test;

import static org.junit.Assert.*;

public class GrafoTest {

    @Test
    public void eliminaArestaDoUltimoAoPrimeiroSeNaoExistirCaminhoAdicional() {

        int numerodeVertices = 10;
        Grafo grafo = new Grafo(numerodeVertices);

        /////////////objetivo caminho do 1  até o 7///////////////////
        grafo.criaAresta(1, 7);
        grafo.criaAresta(7, 10);

        grafo.criaAresta(1, 8);
        grafo.criaAresta(8, 9);
        ///1 se conecta ao 2 e 2 se conecta ao 5

        grafo.criaAresta(1, 2);
        grafo.criaAresta(2, 4);
        grafo.criaAresta(4, 5);
        grafo.criaAresta(4, 6);

        grafo.criaAresta(5, 6);

        grafo.matrizDeArestas[1][7] = 1;




        grafo.eliminaArestaDoUltimoAoPrimeiroSeNaoExistirCaminhoAdicional(6, numerodeVertices);
    }
}