package controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import models.Id;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IdControllerTest {
    private IdController idCtrl;
    private TransactionController transCtrl;
    ArrayList<Id> myIdList;
    Id foundID;

    @Before
    public void setUp() throws Exception {
        transCtrl = new TransactionController();
        idCtrl = new IdController(transCtrl);
        myIdList = idCtrl.getIds();
        for (Id id : myIdList){
            if (id.getGitHubId().equals("mcTesterson")){
                foundID = id;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getIds() {
        Assert.assertTrue(myIdList.size() > 0);
        Assert.assertEquals("Daddy", foundID.getName());
        Assert.assertEquals("mcTesterson", foundID.getGitHubId());
    }

    @Test
    public void makeIdCurrent() {
        idCtrl.makeIdCurrent(foundID);
        Assert.assertEquals(foundID, idCtrl.getMyId());
    }

    // THESE CAN'T BE TESTED WITHOUT MUCKING ABOUT IN THE DATABASE
    // THE SOLUTION TO THIS WOULD BE TO CREATE AN ALTERNATE TESTING DB AND MUCK ABOUT THERE BEFORE PUSHING THE CODE TO MASTER
//    @Test
//    public void postId() {
//    }
//
//    @Test
//    public void putId() {
//    }

    @Test
    public void getIDByGHID() {
        Assert.assertEquals("Daddy", idCtrl.getIDByGHID("mcTesterson").getName());
        Assert.assertEquals("mcTesterson", idCtrl.getIDByGHID("mcTesterson").getGitHubId());
        Assert.assertEquals("0ad3880e12558149106c55b04e4aa420c8e83829", idCtrl.getIDByGHID("mcTesterson").getUserId());
    }
    // TESTED ABOVE IN makeIdCurrent()
//    @Test
//    public void getMyId() {
//    }

}