package proyectoPruebas;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PruebasJUnit {

    @BeforeClass
    public void setup() {
        System.out.println("....Setup");
    }

    @BeforeMethod
    public void preconditions() {
        System.out.println("....Preconditions");
    }

    @Test
    public void additionTest() {
        System.out.println("...Test1");
    }

    @Test
    public void test2() {
        System.out.println("...Test2");
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("....Clean up");
    }

    @AfterClass
    public void finishStep() {
        System.out.println("....Last Step");
    }
}

