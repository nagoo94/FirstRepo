package First.Selenium.with.maven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest3 {

    @Test
    public void sum()
    {
        System.out.println("SUM");
        int a = 10,b =20;
        Assert.assertEquals(30,a+b);
    }

    @Test
    public void diff()
    {
        System.out.println("Difference");
        int a = 10,b =20;
        Assert.assertEquals(10,b-a);
    }

    @Test
    public void multi()
    {
        System.out.println("Multiplication");
        int a = 10,b =20;
        Assert.assertEquals(200,a*b);
    }

    @Test
    public void div()
    {
        System.out.println("DIV");
        int a = 10,b =20;
        Assert.assertEquals(2,b/a);
    }
}
