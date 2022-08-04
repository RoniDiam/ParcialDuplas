package domain.entities;

public class ContextoTipoDeCrypto {
    private StateCrypto stateCrypto;

    public ContextoTipoDeCrypto(StateCrypto stateCrypto) {
        this.stateCrypto = stateCrypto;
    }
    public boolean meSirveComprar(Double valor){
        return stateCrypto.meSirveComprar(valor);
    }
}
