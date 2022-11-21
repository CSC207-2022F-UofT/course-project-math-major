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
        Assert.assertEquals("name1",rank.getName());
    }
}
