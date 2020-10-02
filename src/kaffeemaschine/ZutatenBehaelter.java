package kaffeemaschine;/*corat
 *23.09.2020
 *17:19
 *KaffeeMaschine
 */

/**
 * @author corat
 */
public class ZutatenBehaelter extends AbstractBehaelter implements IWartbar {

    public ZutatenBehaelter(String rezeptZutat, double fuellstand, double maxFuellMenge){
        super (rezeptZutat, fuellstand, maxFuellMenge);
    }


    @Override
    public String toString(AbstractBehaelter behaelter) {
        return switch (behaelter.getBezeichner()) {
            case "Wasser" -> "Wasserbehaelter Fuellmenge = " + this.getFuellstand();
            case "Kaffee" -> "Kaffeebehaelter Fuellmenge = " + this.getFuellstand();
            case "Kakao" -> "Kakaobehaelter Fuellmenge = " + this.getFuellstand();
            case "Zucker" -> "Zuckerbehaelter Fuellmenge = " + this.getFuellstand();
            case "Milch" -> "Milchbehaelter Fuellmenge = " + this.getFuellstand();
            default -> "Fehler";
        };
    }


    @Override
    public String wartung(AbstractBehaelter behaelter) {
        switch ( behaelter.getBezeichner()){
            case "Wasser":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Wasser wieder aufgefüllt";
            case "Kaffee":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Kaffee wieder aufgefüllt";
            case "Kakao":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Kakao wieder aufgefüllt";
            case "Zucker":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Zucker wieder aufgefüllt";
            case "Milch":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Milch wieder aufgefüllt";
            case "Abfall":
                this.setFuellstand(this.getMaxFuellMenge());
                return "Abfallbehälter entleert";
            default:
                return "Wartungsfehler";

        }
    }

}
