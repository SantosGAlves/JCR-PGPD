public class SimulacaoCaixaSupermercado {

    private int numeroCaixas;
    private int mediaAtendimentos;
    private double mediaTempoAtendimentoPorCliente;
    private double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;
    private final java.util.Random rng = new java.util.Random(42);

    
    public void setNumeroCaixas(int n) { this.numeroCaixas = n; }
    public void setMediaAtendimentos(int n) { this.mediaAtendimentos = n; }
    public void setMediaTempoAtendimentoPorCliente(double mu) { this.mediaTempoAtendimentoPorCliente = mu; }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double sigma) { this.desvioPadraoTempoAtendimentoPorCliente = sigma; }

    private double tempoAtendimentoNormalTruncado() {
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente + desvioPadraoTempoAtendimentoPorCliente * z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public Main.ResultadoSimulacao simular() {
        double[] tempoCaixas = new double[this.numeroCaixas];
        double somaTemposServico = 0.0; 

        for (int i = 0; i < this.mediaAtendimentos; i++) {
            int caixaLivre = 0;
            for (int j = 1; j < this.numeroCaixas; j++) {
                if (tempoCaixas[j] < tempoCaixas[caixaLivre]) {
                    caixaLivre = j;
                }
            }

            double tempoServicoCliente = tempoAtendimentoNormalTruncado();
            somaTemposServico += tempoServicoCliente; 

            tempoCaixas[caixaLivre] += tempoServicoCliente;
        }

        double tempoMaximo = 0.0;
        for (int i = 0; i < this.numeroCaixas; i++) {
            if (tempoCaixas[i] > tempoMaximo) {
                tempoMaximo = tempoCaixas[i];
            }
        }

        
        double mediaServico = somaTemposServico / this.mediaAtendimentos;

        
        return new Main.ResultadoSimulacao(tempoMaximo, mediaServico);
    }
}