// Alexsandro Narducci
// Lucas Cândido Belletti
public class TesteGrafo {
    public static void main(String[] args) {
        // grafo com 4 vértices
        int[][] matriz = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        Grafo g = new Grafo(matriz);

        System.out.println("=== Tipo do Grafo ===");
        System.out.println(g.tipoDoGrafo());

        System.out.println("\n=== Arestas do Grafo ===");
        System.out.println(g.arestasDoGrafo());

    }
}
