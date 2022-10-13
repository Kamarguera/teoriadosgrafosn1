import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;


public class MatrizGrafoDeAdjacenciaTest {


    @Test
    public void testeCriacaoDeDoisVerticesComCodigoENomeLocalETipoLocal() {


        Scanner sc = new Scanner(System.in);

        System.out.println("Insira quantidade de vertices: ");
        int numerodeVertices = sc.nextInt();

        Vertice[] vertices = new Vertice[numerodeVertices];
        int codigo = 0;
        String nomeDoLocal;
        String tipoDoLocal;
        for (int i = 0; i < numerodeVertices; i++) {

            System.out.printf("insira o codigo do local %d:\n", i + 1);
            codigo = sc.nextInt();
            System.out.printf("insira o nome do local %d:\n", i + 1);
            nomeDoLocal = sc.next();
            System.out.printf("insira o tipo do local %d:\n", i + 1);
            tipoDoLocal = sc.next();


            System.out.println(codigo);
            vertices[i] = new Vertice(codigo, nomeDoLocal, tipoDoLocal);


            int resultadoCodigoEsperado = codigo;
            String resultadoNomeEsperado = nomeDoLocal;
            String resultadoTipoEsperado = tipoDoLocal;

            Assert.assertEquals(vertices[i].codigoDoLocal, resultadoCodigoEsperado);
            Assert.assertEquals(vertices[i].nomeDoLocal, resultadoNomeEsperado);
            Assert.assertEquals(vertices[i].tipoDoLocal, resultadoTipoEsperado);

        }

    }

    @Test
    public void testVerificaAdjacenciaComDoisVerticesPreviamenteCriados() {
        Aresta aresta = new Aresta(2);


        aresta.criaAresta(1, 2);


        aresta.verificaAdjacencia(1, 2, 2);

        boolean resultadoAdjacente = true;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(1, 2, 2));

    }

    @Test
    public void testVerificaAdjacenciaComTresVerticesPreviamenteCriados() {

        int numerodeVertices = 3;
        Aresta aresta = new Aresta(numerodeVertices);


        aresta.criaAresta(1, 3); //cria aresta do 1 para o 3
        aresta.criaAresta(1, 2); //cria aresta do 1 para o 2

        boolean resultadoAdjacente = true;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(1, 2, numerodeVertices));
        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(1, 3, numerodeVertices));

    }

    @Test
    public void testdeveRetornarFalsoSeVerticesNaoSaoAdjacentes() {

        int numerodeVertices = 3;
        Aresta aresta = new Aresta(numerodeVertices);


        aresta.criaAresta(1, 3); //cria aresta do 1 para o 3
        aresta.criaAresta(1, 2); //cria aresta do 1 para o 2

        boolean resultadoAdjacente = false;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(2, 3, numerodeVertices));

    }


}