package models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdTest {

    private Id nullID;
    private Id defaultID;
    private Id fullID;

    @Before
    public void setUp() throws Exception {
        nullID = new Id();
        defaultID = new Id("Testy", "TestyMcTesterson");
        fullID = new Id("Junior", "JuniorMcTesterson", "fakeUUID");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void nullaryConstructor(){
        Assert.assertNull(nullID.getName());
        Assert.assertNull(nullID.getGitHubId());
        Assert.assertNull(nullID.getUserId());
    }

    @Test
    public void defaultConstructor(){
        Assert.assertEquals(defaultID.getName(), "Testy");
        Assert.assertEquals(defaultID.getGitHubId(), "TestyMcTesterson");
        Assert.assertEquals(defaultID.getUserId(), "-");
    }

    @Test
    public void fullConstructor(){
        Assert.assertEquals(fullID.getName(), "Junior");
        Assert.assertEquals(fullID.getGitHubId(), "JuniorMcTesterson");
        Assert.assertEquals(fullID.getUserId(), "fakeUUID");
    }

    // ALREADY TESTED ABOVE
//    @Test
//    public void getName() {
//    }

    @Test
    public void setName() {
        fullID.setName("Daddy");
        Assert.assertEquals(fullID.getName(), "Daddy");
    }

    // ALREADY TESTED ABOVE
//    @Test
//    public void getGitHubId() {
//    }

    @Test
    public void setGitHubId() {
        fullID.setGitHubId("DaddyMcTesterson");
        Assert.assertEquals(fullID.getGitHubId(), "DaddyMcTesterson");
    }

    // ALREADY TESTED ABOVE
//    @Test
//    public void getUserId() {
//    }

    @Test
    public void setUserId() {
        fullID.setUserId("totallyNotAFakeUUID");
        Assert.assertEquals(fullID.getUserId(), "totallyNotAFakeUUID");
    }
}