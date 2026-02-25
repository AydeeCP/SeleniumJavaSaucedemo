package proyectoPruebas;

import java.time.Duration;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
@Epic("Formulario DemoQA")
@Feature("Registro de usuario")

@Owner("Aydee Callisaya")
public class DemoQATest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(description = "Prueba para validar registro completo del formulario")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Llenar formulario completo, enviar y validar que los datos aparezcan en el modal")
    public void llenarFormulario() {
        navegarAFormulario();
        completarFormulario();
        enviarFormulario();
        validarDatos();
    }

    @Step("Navegar al formulario de Practice Form")
    public void navegarAFormulario() {
        driver.get("https://demoqa.com/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        WebElement forms = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h5[text()='Forms']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", forms);

        WebElement practiceForm = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[text()='Practice Form']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", practiceForm);
    }

    @Step("Completar todos los campos del formulario")
    public void completarFormulario() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys("Aydee");
        driver.findElement(By.id("lastName")).sendKeys("Callisaya");
        driver.findElement(By.id("userEmail")).sendKeys("aydee@gmail.com");

        WebElement female = driver.findElement(By.id("gender-radio-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", female);

        driver.findElement(By.id("userNumber")).sendKeys("7915756912");

        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", music);

        driver.findElement(By.id("currentAddress")).sendKeys("Zona Sur, La Paz, Bolivia");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);
    }

    @Step("Enviar formulario")
    public void enviarFormulario() {
        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    @Step("Validar que los datos ingresados aparezcan correctamente en el modal")
    public void validarDatos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        String nombre = driver.findElement(
                By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();

        Assert.assertEquals(nombre, "Aydee Callisaya");
    }

    // Captura de pantalla automática si falla
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot - " + result.getName(),
                        new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                System.out.println("No se pudo tomar screenshot: " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void cerrar() {
        driver.quit();
    }
}
