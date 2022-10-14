import java.util.Scanner;

public class Main {

    //test test test
    public static void main(String args[]) {
        int op = 0;
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

            System.out.println("informe as arestas: <destino> <origem>");
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
                    System.out.println("Menu de Operações");
                    System.out.println("(1) - Verificar se dois vertices sao adjacentes");
                    System.out.println("(2) - Verificar se existe um laço a partir da leitura de um vertice");
                    System.out.println("(3) - Verificar se existe um caminho a partir da leitura de dois vértices");
                    op = sc.nextInt();

            switch (op){

                case 1:
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
                    break;
                case 2:
                     System.out.println("Insira o vertice a ser verificado:");
                     vertice1 = sc.nextInt();
                     System.out.printf(
                            "Há um laço no vértice %d: %S "
                            , vertice1
                            , arestas.verificaAdjacencia(vertice1, vertice1, numerodeVertices).toString()
                    );
                    break;
                case 3:
                     System.out.println("Insira o primeiro vértice:");
                     vertice1 = sc.nextInt();
                     System.out.println("Insira o segundo vértice");
                     vertice2 = sc.nextInt();

                     System.out.printf(
                            "Há um caminho entre o vértice %d e o vértice %d: %S "
                            , vertice1
                            , vertice2
                            , arestas.verificaAdjacencia(vertice1, vertice2, numerodeVertices).toString()
                    );
                    break;
            }

            sc.close();

        } catch (Exception E) {
            System.out.println("Something went wrong");
        }

    }
}


