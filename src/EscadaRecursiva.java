// Calcula as maneiras de subir uma escada com passos de 1 ou 2 degraus.
public class EscadaRecursiva {

    // Ponto de entrada do programa.
    public static void main(String[] args) {

        // Inclui os exemplos obrigatórios e outros valores para conferência.
        int[] degraus = {1, 2, 3, 4, 5, 6};
        long[] resultadosEsperados = {1, 2, 3, 5, 8, 13};

        // Executa a função para cada quantidade de degraus.
        for (int i = 0; i < degraus.length; i++) {
            long resultado = contarManeiras(degraus[i]);

            // Compara o cálculo com o resultado esperado.
            String situacao = resultado == resultadosEsperados[i]
                    ? "OK"
                    : "ERRO";

            System.out.println(
                    "Degraus: " + degraus[i]
                            + " | Maneiras: " + resultado
                            + " | Esperado: " + resultadosEsperados[i]
                            + " | Teste: " + situacao
            );
        }
    }

    // Retorna quantas maneiras existem de subir n degraus.
    private static long contarManeiras(int n) {

        // O problema considera escadas com pelo menos 1 degrau.
        if (n < 1) {
            throw new IllegalArgumentException(
                    "A quantidade de degraus deve ser maior ou igual a 1."
            );
        }

        // Casos base: retornam diretamente, encerrando a recursão.
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // Soma as possibilidades de chegar ao topo:
        // um último passo de 1 degrau ou um último passo de 2 degraus.
        return contarManeiras(n - 1) + contarManeiras(n - 2);
    }
}