package TDD;

public class Filosofo {
    private Garfo garfoEsquerdo;
    private Garfo garfoDireito;

    public void setGarfos(Garfo esquerdo, Garfo direito) {
        this.garfoEsquerdo = esquerdo;
        this.garfoDireito = direito;
    }

    public Garfo getGarfoEsquerdo() {
        return garfoEsquerdo;
    }

    public Garfo getGarfoDireito() {
        return garfoDireito;
    }
}