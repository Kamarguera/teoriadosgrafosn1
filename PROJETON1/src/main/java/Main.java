import java.util.Scanner;

public class Main {


    //test test test
    public static void main(String args[]) {
        int v, e, count = 1, to, from, codigoDoLocal, numerodeVertices = 0;
        String nomeDoLocal, tipoDoLocal;

        Scanner sc = new Scanner(System.in);
        Aresta arestas;
        try {

            System.out.println("Insira quantidade de vertices: ");
            numerodeVertices = sc.nextInt();

            Vertice[] vertices = new Vertice[numerodeVertices];
            for (int i = 0; i < numerodeVertices; i++) {

                System.out.printf("insira o codigo do local %d:\n", i + 1);
                codigoDoLocal = sc.nextInt();
                System.out.printf("insira o nome do local %d:\n", i + 1);
                nomeDoLocal = sc.next();
                System.out.printf("insira o tipo do local %d:\n", i + 1);
                tipoDoLocal = sc.next();


                vertices[i] = new Vertice(codigoDoLocal, nomeDoLocal, tipoDoLocal);
            }

            v = numerodeVertices;


            System.out.println("Insira numero de arestas: ");
            e = sc.nextInt();

            arestas = new Aresta(v);

            System.out.println("Enter the edges: <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();

                arestas.criaAresta(to, from);
                count++;
            }

            System.out.println("A matriz de adjacencia para o grafo inserido é: ");
            System.out.print("  ");

            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 1; i <= v; i++) {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++)
                    System.out.print(arestas.getAresta(i, j) + " ");
                System.out.println();
            }


            System.out.println("Verificar se dois vertices sao adjacentes(S/N)?");
            if (sc.next().equalsIgnoreCase("S")) {


                System.out.println("Insira o primeiro vertice");
                int vertice1 = sc.nextInt();
                System.out.println("Insira o segundo vertice");
                int vertice2 = sc.nextInt();


                System.out.printf(
                        "O vertice %d é adjacente ao vertice %d: %S "
                        , vertice1
                        , vertice2
                        , arestas.verificaAdjacencia(vertice1, vertice2, numerodeVertices).toString()
                );

            }

            System.out.println("Verificar se existe um laço a partir da leitura de um vertice(S/N)?");
            if (sc.next().equalsIgnoreCase("S")) {


                System.out.println("Insira o vertice a ser verificado:");
                int vertice1 = sc.nextInt();


                System.out.printf(
                        "Há um laço no vértice %d: %S "
                        , vertice1
                        , arestas.verificaAdjacencia(vertice1, vertice1, numerodeVertices).toString()
                );

            }


            System.out.println("Verificar se existe um caminho a partir da leitura de dois vértices(S/N)?");
            if (sc.next().equalsIgnoreCase("S")) {


                System.out.println("Insira o primeiro vértice:");
                int vertice1 = sc.nextInt();
                System.out.println("Insira o segundo vértice");
                int vertice2 = sc.nextInt();


                System.out.printf(
                        "Há um caminho entre o vértice %d e o vértice %d: %S "
                        , vertice1
                        , vertice2
                        , arestas.verificaAdjacencia(vertice1, vertice2, numerodeVertices).toString()
                );

            }


            sc.close();

        } catch (Exception E) {
            System.out.println("Something went wrong");
        }
//        int opcao;
//        switch(opcao) {
//            case 1:
//                // code block
//                break;
//            case y:
//                // code block
//                break;
//            default:
//                // code block
//
//
//
    }
}


