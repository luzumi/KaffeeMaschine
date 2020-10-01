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
        switch(behaelter.bezeichner){
            case "Wasser":
                return "Wasserbehaelter Fuellmenge = "+ this.fuellstand;
            case "Kaffee":
                return "Kaffeebehaelter Fuellmenge = "+ this.fuellstand;
            case "Kakao":
                return "Kakaobehaelter Fuellmenge = "+ this.fuellstand;
            case "Zucker":
                return "Zuckerbehaelter Fuellmenge = "+ this.fuellstand;
            case "Milch":
                return "Milchbehaelter Fuellmenge = "+ this.fuellstand;
            default:
                return "Fehler";
        }
    }


    @Override
    public String wartung(AbstractBehaelter behaelter) {
        switch (behaelter.bezeichner){
            case "Wasser":
                this.fuellstand = 10;
                return "Wasser wieder aufgefüllt";
            case "Kaffee":
                this.fuellstand = 1;
                return "Kaffee wieder aufgefüllt";
            case "Kakao":
                this.fuellstand = 1;
                return "Kakao wieder aufgefüllt";
            case "Zucker":
                this.fuellstand = 1;
                return "Zucker wieder aufgefüllt";
            case "Milch":
                this.fuellstand = 1;
                return "Milch wieder aufgefüllt";
            case "Abfall":
                this.fuellstand = 100;
                return "Abfallbehälter entleert";
            default:
                return "Wartungsfehler";

        }
    }

}
