// Alexsandro Narducci
// Lucas Cândido Belletti
import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private int[][] matriz;

    public Grafo(int[][] matriz) {
        this.matriz = matriz;
    }

    public String tipoDoGrafo() {
        int n = matriz.length;
        boolean dirigido = false, multigrafo = false, completo = true, nulo = true, regular = true;
        int grauEsperado = -1;

        for (int i = 0; i < n; i++) {
            int grau = 0;
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    dirigido = true;
                }

                if (matriz[i][j] > 1 || (i == j && matriz[i][j] > 0)) {
                    multigrafo = true;
                }

                if (i != j && matriz[i][j] == 0) {
                    completo = false;
                }

                if (matriz[i][j] != 0) {
                    nulo = false;
                }
                grau += matriz[i][j];
            }
            if (grauEsperado == -1) {
                grauEsperado = grau;
            } else if (grau != grauEsperado) {
                regular = false;
            }
        }

        return (dirigido ? "Dirigido" : "Não-dirigido") + ", "
                + (multigrafo ? "Multigrafo" : "Simples") + ", "
                + (regular ? "Regular" : "Não-regular") + ", "
                + (completo ? "Completo" : "Não-completo") + ", "
                + (nulo ? "Nulo" : "Não-nulo");
    }

    public String arestasDoGrafo() {
        int n = matriz.length;
        int qtd = 0;
        List<String> arestas = new ArrayList<>();
        boolean dirigido = false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matriz[i][j] != matriz[j][i]) {
                    dirigido = true;
                }

        for (int i = 0; i < n; i++) {
            for (int j = (dirigido ? 0 : i); j < n; j++) {
                for (int k = 0; k < matriz[i][j]; k++) {
                    if (matriz[i][j] > 0) {
                        qtd++;
                        arestas.add("(" + i + "," + j + ")");
                    }
                }
            }
        }
        return "Quantidade de arestas: " + qtd + "\nArestas: " + arestas;
    }
    
    public String grausDoVertice() {
        int n = matriz.length;
        boolean dirigido = false;

        // Testa se é dirigido
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    dirigido = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (dirigido) {
            int[] grauEntrada = new int[n];
            int[] grauSaida = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grauSaida[i] += matriz[i][j]; // arestas que saem
                    grauEntrada[j] += matriz[i][j]; // arestas que chegam
                }
            }

            sb.append("Grafo dirigido\n");
            for (int i = 0; i < n; i++) {
                sb.append("Vértice ").append(i)
                  .append(": entrada = ").append(grauEntrada[i])
                  .append(", saída = ").append(grauSaida[i]).append("\n");
            }
        } else {
            int[] graus = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graus[i] += matriz[i][j];
                }
            }

            sb.append("Grafo não-dirigido\n");
            for (int i = 0; i < n; i++) {
                sb.append("Vértice ").append(i)
                  .append(": grau = ").append(graus[i]).append("\n");
            }

            sb.append("Sequência de graus: ");
            for (int g : graus) sb.append(g).append(" ");
        }

        return sb.toString();
    }


}
