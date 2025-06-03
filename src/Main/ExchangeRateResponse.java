package Main;

public class ExchangeRateResponse {
    // o Gson vai mapear o JSON "conversion_rate" (double) para este campo
    public double conversion_rate;

    // (opcional) se quiser saber de/para
    public String base_code;
    public String target_code;
}
