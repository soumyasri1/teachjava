import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = login();
        navigateToCertificates(driver);
        selectCertificateType(driver);
        searchAndSelectStudent(driver);
        clickOnGenerate(driver);
        updateRemarks(driver);
        generateAndDownload(driver);
        validateCertificateHistory(driver);
        driver.quit();
    }

    public static WebDriver login() {
        System.setProperty("webdriver.chrome.driver", "C:\Users\SOUMY");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--disable-user-media-security=true",
                "--allow-file-access-from-files", "--use-fake-device-for-media-stream",
                "--use-fake-ui-for-media-stream", "--disable-popup-blocking",
                "--disable-infobars", "--enable-usermedia-screen-capturing",
                "--disable-dev-shm-usage", "--no-sandbox",
                "--auto-select-desktop-capture-source=Screen 1",
                "--disable-blink-features=AutomationControlled");
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://accounts.teachmint.com/");
        
        // Additional login steps here
        
        return driver;
    }

    public static void navigateToCertificates(WebDriver driver) {
        WebElement certificatesLink = driver.findElement(By.xpath("//a[text()='Certificates']"));
        certificatesLink.click();
    }

    public static void selectCertificateType(WebDriver driver) {
        WebElement certificateType = driver.findElement(By.xpath("//select[@id='certificate-type']"));
        // Assuming you have options in a dropdown, select the appropriate option based on your requirements
        // certificateType.sendKeys("School Leaving Certificate");
    }

    public static void searchAndSelectStudent(WebDriver driver) {
        // Implement searching and selecting student
        // For example:
        WebElement searchInput = driver.findElement(By.id("search-student-input"));
        searchInput.sendKeys("Sam");
        WebElement student = driver.findElement(By.xpath("//div[contains(@class, 'student')]"));
        student.click();
    }

    public static void clickOnGenerate(WebDriver driver) {
        WebElement generateButton = driver.findElement(By.id("generate-button"));
        generateButton.click();
    }

    public static void updateRemarks(WebDriver driver) {
        WebElement remarksInput = driver.findElement(By.id("remarks-input"));
        remarksInput.sendKeys("Remark for Sam's leaving certificate.");
    }

    public static void generateAndDownload(WebDriver driver) {
        WebElement generateAndDownloadButton = driver.findElement(By.id("generate-download-button"));
        generateAndDownloadButton.click();
        // Wait for download to complete
        // This may vary based on how the download mechanism is implemented on the website
    }

    public static void validateCertificateHistory(WebDriver driver) {
        // Assuming there's a history section where you can validate the certificate generation
        WebElement historySection = driver.findElement(By.id("certificate-history"));
        // Implement validation based on the history displayed on the page
    }
}
