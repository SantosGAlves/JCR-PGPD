package TDD;

import java.util.List;
import java.util.ArrayList;

public class Jantar {
    private List<Filosofo> filosofos;
    private List<Garfo> garfos;

    public void iniciar() {
        // DEIXE ESTE MÉTODO VAZIO OU INCOMPLETO PARA O TESTE FALHAR
        // O teste exige que ele falhe, então não implemente a lógica aqui ainda.
        // Apenas inicialize as listas para evitar NullPointerException imediato, se quiser.
        filosofos = new ArrayList<>();
        garfos = new ArrayList<>();
    }

    public List<Filosofo> getFilosofos() {
        return filosofos;
    }

    public List<Garfo> getGarfos() {
        return garfos;
    }
}
