package domain.entities.api;

public interface CryptoInterfaz {
    public void getCryptos() throws Exception;
    public Double getPrice(String name) throws Exception;
}
