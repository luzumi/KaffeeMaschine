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
            case "Wasser" -> "\nFuellmengen:________________\n" + "\tKaffeebehaelter: . ." + fuellstandRunden();
            case "Kaffee" -> "\tKaffeebehaelter: . " + fuellstandRunden();
            case "Kakao" ->  "\tKakaobehaelter:. . " + fuellstandRunden();
            case "Zucker" -> "\tZuckerbehaelter: . " + fuellstandRunden();
            case "Milch" ->  "\tMilchbehaelter:. . " + fuellstandRunden();
            default -> "Fehler";
        };
    }

    public String fuellstandRunden() {

        if ((int)this.getFuellstand() >= Constants.ZEHN){
            return "" + Math.round(100 * this.getFuellstand()) / 100.0;
        }
        else if ((int)this.getFuellstand() > 1) {
            return " " + Math.round(100 * this.getFuellstand()) / 100.0;
        }
        else if(Double.toString(this.getFuellstand()).length() == Constants.DREI){
            return ". " + Math.round(1000 * this.getFuellstand()) / 1000.0;
        }
        else {
            return "." + Math.round(100 * this.getFuellstand()) / 100.0;
        }
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
