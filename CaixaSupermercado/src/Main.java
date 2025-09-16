import java.util.ArrayList;
import java.util.List;

public class Main {

    
    public static class ResultadoSimulacao {
        private final double tempoTotal;
        private final double mediaTempoServico;

        public ResultadoSimulacao(double tempoTotal, double mediaTempoServico) {
            this.tempoTotal = tempoTotal;
            this.mediaTempoServico = mediaTempoServico;
        }

        public double getTempoTotal() { return tempoTotal; }
        public double getMediaTempoServico() { return mediaTempoServico; }
    }

    public static void main(String... args) {
        final int NUMERO_SIMULACOES = 1000;
        
        
        final List<Double> temposTotais = new ArrayList<>();
        final List<Double> mediasServico = new ArrayList<>();

        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

        for (int i = 0; i < NUMERO_SIMULACOES; i++) {
            
            simulador.setNumeroCaixas(2); 
            simulador.setMediaAtendimentos(100);
            simulador.setMediaTempoAtendimentoPorCliente(5.00);
            simulador.setDesvioPadraoTempoAtendimentoPorCliente(2);

            
            ResultadoSimulacao resultado = simulador.simular();

            
            temposTotais.add(resultado.getTempoTotal());
            mediasServico.add(resultado.getMediaTempoServico());
        }

        System.out.println("--- Estatísticas do TEMPO TOTAL para atender 100 clientes ---");
        double mediaTempoTotal = media(temposTotais);
        double dpTempoTotal = desvioPadrao(temposTotais, mediaTempoTotal);
        System.out.printf("Média do tempo total (%.0f simulações): %.3f min%n",
                (double) NUMERO_SIMULACOES, mediaTempoTotal);
        System.out.printf("Desvio-padrão dos tempos totais: %.3f min%n%n", dpTempoTotal);


        System.out.println("--- Estatísticas do TEMPO MÉDIO DE SERVIÇO por cliente ---");
        double mediaDoServico = media(mediasServico);
        double dpDoServico = desvioPadrao(mediasServico, mediaDoServico);
        System.out.printf("Média do tempo de serviço (%.0f simulações): %.3f min%n",
                (double) NUMERO_SIMULACOES, mediaDoServico);
        System.out.printf("Desvio-padrão das médias de serviço: %.3f min%n", dpDoServico);
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}