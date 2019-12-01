package views;

import models.Id;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IdTextViewTest {

    Id testID;
    Id testyJR;
    Id testyDaddy;
    Id testyMommy;
    IdTextView idtv;
    ArrayList<Id> testyFamily;

    @org.junit.Before
    public void setUp() throws Exception {
        idtv = new IdTextView();

        testID = new Id("Testy", "TestyMcTesterson");
        testyJR = new Id("Junior", "JuniorMcTesterson");
        testyDaddy = new Id("Daddy", "DaddyMcTesterson");
        testyMommy = new Id("Mommy", "MommyMcTesterson");

        testyFamily = new ArrayList<Id>();
        testyFamily.add(testID);
        testyFamily.add(testyJR);
        testyFamily.add(testyDaddy);
        testyFamily.add(testyMommy);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testToString() {
        String expected = "*******************************************\n" +
                "Name: Testy\n"+
                "GitHub ID: TestyMcTesterson\n" +
                "*******************************************\n\n";
        Assert.assertEquals(expected, idtv.toString(testID));
    }

    @org.junit.Test
    public void testToStringFamily() {
        String expected =
                "*******************************************\n" +
                "Name: Testy\n"+
                "GitHub ID: TestyMcTesterson\n" +
                "*******************************************\n\n" +

                "*******************************************\n" +
                "Name: Junior\n"+
                "GitHub ID: JuniorMcTesterson\n" +
                "*******************************************\n\n" +

                "*******************************************\n" +
                "Name: Daddy\n"+
                "GitHub ID: DaddyMcTesterson\n" +
                "*******************************************\n\n" +

                "*******************************************\n" +
                "Name: Mommy\n"+
                "GitHub ID: MommyMcTesterson\n" +
                "*******************************************\n\n";
                Assert.assertEquals(expected, idtv.toString(testyFamily));
    }

}