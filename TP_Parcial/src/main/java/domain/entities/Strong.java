package domain.entities;

public class Strong extends StateCrypto{
    @Override
    public boolean meSirveComprar(Double valor){
        return valor > 10000;
    }
}
