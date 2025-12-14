package TDD;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class JantarTest {

    @Test
    public void testConfiguracaoInicialDoJantar() {
        // 1. Cria o ambiente
        Jantar jantar = new Jantar();
        
        // 2. Executa o método de configuração
        jantar.iniciar();

        // 3. Recupera os artefatos para verificação
        List<Filosofo> filosofos = jantar.getFilosofos();
        List<Garfo> garfos = jantar.getGarfos();

        // --- VERIFICAÇÕES (ASSERTS) ---

        // Verifica se as listas não são nulas
        assertNotNull("A lista de filósofos não deveria ser nula", filosofos);
        assertNotNull("A lista de garfos não deveria ser nula", garfos);

        // Verifica a quantidade correta (5 filósofos e 5 garfos)
        // O TESTE VAI FALHAR AQUI, pois sua lista está vazia (size 0) e esperamos 5.
        assertEquals("Deveriam existir 5 filósofos", 5, filosofos.size());
        assertEquals("Deveriam existir 5 garfos", 5, garfos.size());

        // Verifica a lógica circular de distribuição dos garfos
        for (int i = 0; i < 5; i++) {
            Filosofo f = filosofos.get(i);
            
            assertNotNull("Filósofo " + i + " deveria ter um garfo esquerdo", f.getGarfoEsquerdo());
            assertNotNull("Filósofo " + i + " deveria ter um garfo direito", f.getGarfoDireito());

            // Lógica Circular: Filósofo i pega Garfo i e Garfo (i+1)%5
            Garfo garfoEsperadoEsquerda = garfos.get(i);
            Garfo garfoEsperadoDireita = garfos.get((i + 1) % 5);

            assertSame("O garfo esquerdo do filósofo " + i + " está incorreto.", 
                garfoEsperadoEsquerda, f.getGarfoEsquerdo());
            
            assertSame("O garfo direito do filósofo " + i + " está incorreto.", 
                garfoEsperadoDireita, f.getGarfoDireito());
        }
    }
}
