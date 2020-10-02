package test.kaffeemaschine;


import kaffeemaschine.Menu;
import org.junit.*;

import java.io.*;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Menu Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Okt. 1, 2020</pre>
 */
public class MenuTest {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    /**
     * Method: programmAuswahl()
     */
    @Test
    public void testProgrammAuswahlScannerInput_5() throws Exception {

        Menu menu = new Menu();
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals( "5", Integer.toString(Menu.programmAuswahl()));

    }


    @Test
    public void testMenuCheckMenuKorrekt(){
        String testMenu =   "****** Kaffeemaschine ******\n"+
                            "============================\n"+
                            "Auswahl:____________________\n"+
                            "1.) Kaffee schwarz__________\n"+
                            "2.) Kaffee mit Zucker_______\n"+
                            "3.) Kaffee mit Milch________\n"+
                            "4.) Kaffee mit Milch/Zucker_\n"+
                            "5.) Kakao___________________\n"+
                            "9.) _________________Wartung\n"+
                            "0.) _________________Abbruch";

        assertEquals(testMenu, Menu.menu());
    }
} 
