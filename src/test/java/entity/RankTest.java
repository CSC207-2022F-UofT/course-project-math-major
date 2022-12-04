package entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RankTest {

    private Rank rank;

    @Before
    public void before(){
        System.out.println("before");
        rank = new Rank("name1",1.0);
    }

    @After
    public void after(){
        System.out.println("after");
        rank = null;
    }

    @Test
    public void testSetName(){
        rank.setName("name2");
        Assert.assertEquals("name2",rank.getName());
    }
    @Test
    public void testGetName(){
        Assert.assertEquals("name1",rank.getName());
    }

    @Test
    public void testSetValue(){
        rank.setValue(2.0);
        Assert.assertEquals(2.0,rank.getValue(),Math.pow(10,-6));
    }

    @Test
    public void testGetValue(){
        Assert.assertEquals(1.0,rank.getValue(),Math.pow(10,-6));
    }
}
