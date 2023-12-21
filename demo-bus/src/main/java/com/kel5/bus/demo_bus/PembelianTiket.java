package com.kel5.bus.demo_bus;

public class PembelianTiket {
    private static final double TRANSJAKARTA_PRICE = 5000;
    private static final double KOPAJA_PRICE = 4500;
    private static final double METROMINI_PRICE = 7000;
    private static final double SINARJAYA_PRICE = 6000;
    private static final double PAHALAKENCANA_PRICE = 4000;

    public static double getHargaTiket(String namaBus) {
        switch (namaBus) {
            case "Transjakarta":
                return TRANSJAKARTA_PRICE;
            case "Kopaja":
                return KOPAJA_PRICE;
            case "Metromini":
                return METROMINI_PRICE;
            case "Sinar Jaya":
                return SINARJAYA_PRICE;
            case "Pahala Kencana":
                return PAHALAKENCANA_PRICE;
            default:
                return 0.0;
        }
    }
}
