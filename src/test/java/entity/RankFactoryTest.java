package entity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RankFactoryTest {

    static RankFactory rankFactory;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
        rankFactory = RankFactory.getInstance();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
        rankFactory = null;
    }

    @Test
    public void testGetInstance(){
        RankFactory rf = RankFactory.getInstance();
        System.out.println(rf+":"+rankFactory);
        Assert.assertEquals(rankFactory,rf);
    }


}
