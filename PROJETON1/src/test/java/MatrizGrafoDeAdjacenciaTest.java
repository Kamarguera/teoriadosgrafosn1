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
        Grafo aresta = new Grafo(2);


        aresta.criaAresta(1, 2);


        aresta.verificaAdjacencia(1, 2, 2);

        boolean resultadoAdjacente = true;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(1, 2, 2));

    }

    @Test
    public void testVerificaAdjacenciaComTresVerticesPreviamenteCriados() {

        int numerodeVertices = 5;
        Grafo aresta = new Grafo(numerodeVertices);


        aresta.criaAresta(1, 5); //cria aresta do 1 para o 3
        aresta.criaAresta(2, 3); //cria aresta do 1 para o 2

        boolean resultadoAdjacente = true;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(1, 5, numerodeVertices));
        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(2, 3, numerodeVertices));

    }

    @Test
    public void testdeveRetornarFalsoSeVerticesNaoSaoAdjacentes() {

        int numerodeVertices = 3;
        Grafo aresta = new Grafo(numerodeVertices);


        aresta.criaAresta(1, 3); //cria aresta do 1 para o 3
        aresta.criaAresta(1, 2); //cria aresta do 1 para o 2

        boolean resultadoAdjacente = false;

        Assert.assertEquals(resultadoAdjacente, aresta.verificaAdjacencia(2, 3, numerodeVertices));

    }

    @Test
    public void testVerificaAdjacenciaRetornandoCaminhoComTresVerticesPreviamenteCriados() {

        int numerodeVertices = 5;
        Grafo aresta = new Grafo(numerodeVertices);


        aresta.criaAresta(1, 5); //cria aresta do 1 para o 5
        aresta.criaAresta(3, 4); //cria aresta do 3 para o 4

        int resultadoCaminho1 = 5;
        int resultadoCaminho2 = 4;

        System.out.println(aresta.verificaAdjacenciaRetornandoCaminho(1, 5, numerodeVertices));
        System.out.println(aresta.verificaAdjacenciaRetornandoCaminho(3, 4, numerodeVertices));

        Assert.assertEquals(resultadoCaminho1, aresta.verificaAdjacenciaRetornandoCaminho(1, 5, numerodeVertices));
        Assert.assertEquals(resultadoCaminho2, aresta.verificaAdjacenciaRetornandoCaminho(3, 4, numerodeVertices));

    }

    @Test
    public void testVerificaCaminho() {


        int numerodeVertices = 10;
        Grafo aresta = new Grafo(numerodeVertices);


        Vertice[] nodo = new Vertice[numerodeVertices];
        for (int i = 0; i < numerodeVertices; i++) {


            // System.out.printf("insira o codigo do local %d:\n", i + 1);
            int codigoDoLocal = i;
            //System.out.printf("insira o nome do local %d:\n", i + 1);
            String nomeDoLocal = "prédio" + i;
            // System.out.printf("insira o tipo do local %d:\n", i + 1);
            String tipoDoLocal = "academico" + i;

            nodo[i] = new Vertice(codigoDoLocal, nomeDoLocal, tipoDoLocal);
//
//            System.out.println(vertices[i].codigoDoLocal);
//            System.out.println(vertices[i].nomeDoLocal);
//            System.out.println(vertices[i].tipoDoLocal);

        }


///////////////objetivo caminho do 1  até o 7///////////////////
        aresta.criaAresta(1, 7);
        aresta.criaAresta(7, 9);

        aresta.criaAresta(1, 8);
        aresta.criaAresta(8, 9);
        ///1 se conecta ao 2 e 2 se conecta ao 5

        aresta.criaAresta(1, 2);
        aresta.criaAresta(2, 4);
        aresta.criaAresta(4, 5);
        aresta.criaAresta(4, 6);
        aresta.criaAresta(4, 7);

        aresta.criaAresta(5, 6);

        System.out.println(
                aresta.verificaAdjacenciaRecursiva(1, 7, numerodeVertices));
    }

    @Test
    public void testreverseString() {
        Grafo grafo = new Grafo(3);


//        grafo.getAresta2(-10 ,-10);
//
////
////        System.out.println(
////                grafo.reverseString("hello")
////        );
//
        System.out.println(grafo.verificaAdjacenciaRecursiva(1, 2, 2));
//        String input = "";
//        System.out.println(input.substring(1));

    }


    @Test
    public void testretornaOPrimeiroVerticeAoQualUmVerticeSeConecta() {

        int numerodeVertices = 10;
        Grafo grafo = new Grafo(numerodeVertices);

        ///////////////objetivo caminho do 1  até o 7///////////////////
        grafo.criaAresta(1, 7);
        grafo.criaAresta(7, 9);

        grafo.criaAresta(1, 8);
        grafo.criaAresta(8, 9);
        ///1 se conecta ao 2 e 2 se conecta ao 5

        grafo.criaAresta(1, 2);
        grafo.criaAresta(2, 4);
        grafo.criaAresta(4, 5);
        grafo.criaAresta(4, 6);
        grafo.criaAresta(4, 7);

        grafo.criaAresta(5, 6);


        System.out.println(grafo.retornaOPrimeiroVerticeAoQualUmVerticeSeConecta(1, numerodeVertices));


    }

    @Test
    public void adjacenciaRecursiva() {

        int numerodeVertices = 10;
        Grafo grafo = new Grafo(numerodeVertices);

        /////////////objetivo caminho do 1  até o 7///////////////////
        grafo.criaAresta(1, 7);
        grafo.criaAresta(7, 9);

        grafo.criaAresta(3, 8);
        grafo.criaAresta(8, 10);
        grafo.criaAresta(8, 9);
        ///1 se conecta ao 2 e 2 se conecta ao 5

        grafo.criaAresta(1, 2);
        grafo.criaAresta(2, 4);
        grafo.criaAresta(2, 3);
        grafo.criaAresta(4, 5);
        grafo.criaAresta(4, 6);
        grafo.criaAresta(4, 7);

        grafo.criaAresta(5, 7);
        grafo.criaAresta(7, 10);
        grafo.criaAresta(10, 2);





        System.out.println(grafo.verificaAdjacenciaRecursiva(3, 3, numerodeVertices));


    }


}