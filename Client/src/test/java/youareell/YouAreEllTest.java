package youareell;

import models.Id;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class YouAreEllTest {

    private ArrayList<Id> idList;
    private YouAreEll youRElle;

    @Before
    public void setUp() throws Exception {
        youRElle = new YouAreEll();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get_ids() {
        Assert.assertTrue(youRElle.get_ids().contains("mcTesterson"));
    }

    @Test
    public void setCurrent() {
        String expected =
//                "\n\n*******************************************\n" +
//                "The below GitHub ID is now your current ID:\n" +
                "*******************************************\n" +
                "Name: Daddy\n" +
                "GitHub ID: mcTesterson\n" +
                "*******************************************\n\n";
        Assert.assertEquals(expected, youRElle.setCurrent("mcTesterson"));
    }

    @Test
    public void getCurrent() {
        youRElle.setCurrent("mcTesterson");
        String expected =
                "*******************************************\n" +
                "Name: Daddy\n" +
                "GitHub ID: mcTesterson\n" +
                "*******************************************\n\n";
        Assert.assertEquals(expected, youRElle.getCurrent());
    }

    @Test
    public void getCurrentWhenEmpty() {
        String expected =
                "There is no current ID set in the system yet.\n" +
                "Use the command \"ids setCurrent [your ID]\" to set the current ID.";
        Assert.assertEquals(expected, youRElle.getCurrent());
    }

    @Test
    public void putOrPostId() {
    }

    @Test
    public void get_messages() {
    }
}