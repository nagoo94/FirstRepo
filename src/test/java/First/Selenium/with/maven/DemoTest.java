package First.Selenium.with.maven;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {


    @Test(expectedExceptions=NumberFormatException.class,groups = "SUM & DIFF")
    public void sum()
    {
        System.out.println("SUM");
        String a = "100A";
        Integer.parseInt(a);
    }

    @Test(dependsOnMethods ="sum",groups = "SUM & DIFF")
    public void diff()
    {
        System.out.println("Difference");
        int a = 10,b =20;
        Assert.assertEquals(10,b-a);
    }

    @Test(groups = "multi & div")
    public void multi()
    {
        System.out.println("Multiplication");
        int a = 10,b =20;
        Assert.assertEquals(200,a*b);
    }

    @Test(groups = "multi & div")
    public void div()
    {
        System.out.println("DIV");
        int a = 10,b =20;
        Assert.assertEquals(2,b/a);
    }


}
