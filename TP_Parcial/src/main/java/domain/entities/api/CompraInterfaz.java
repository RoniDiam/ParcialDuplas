package domain.entities.api;

public interface CompraInterfaz {
    public void getCryptos() throws Exception;
    public Double getPrice(String name) throws Exception;
}
