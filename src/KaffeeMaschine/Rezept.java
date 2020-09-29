package KaffeeMaschine;/*corat
 *23.09.2020
 *17:23
 *KaffeeMaschine
 */

/**
 * @author corat
 */
public class Rezept {
    /**
     * Enthält Informationen über die zu entnehmenden Mengen und Rezeptbezeichnungen
     * Kaffee schwarz:
     * Kaffee Zucker:
     * Kaffee Milch:
     * Kaffee Milch/Zucker:
     * Kakao
     */
    public static double[][] getZutatenVerbrauch = {{0.2, 0.02, 0, 0, 0},
            {0.2, 0.02, 0, 0, 0.02},
            {0.2, 0.02, 0, 0.02, 0},
            {0.2, 0.02, 0, 0.02, 0.02},
            {0.2, 0, 0.02, 0.02, 0.02}
    };

    public static String[] AuswahlProdukt = new String[]{
            "Kaffee schwarz", "Kaffee Zucker", "Kaffee Milch", "Kaffee Milch und Zucker", "Kakao"
    };

}
