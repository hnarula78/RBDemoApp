import com.rbdemo.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.rbdemo.HomePage;


import java.util.concurrent.TimeUnit;

public class TestCase {

    WebDriver driver;
    String driverPath = "./src/main/resources/driver/chromedriver";
    public String url = "http://rbauction.com";

    @BeforeSuite
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test(alwaysRun = true, priority = 1)
    public void search()
    {
        HomePage homePage = new HomePage(this.driver);
        homePage.driver.get(url);
        System.out.println("Searching for Ford F 150 cars in database ");
        homePage.search();
        System.out.println("Test 1 Passed");

    }

    @Test(alwaysRun = true, priority =2)
    public void getFirstSearchResult()
    {
        ResultsPage resultsPage = new ResultsPage(this.driver);
        Assert.assertTrue(resultsPage.getFirstResultHeader().contains("Ford F150"), "Search results did not returned any Ford F 150 in first result");
        System.out.println("Test 2 Passed");
    }

    @Test(alwaysRun = true, priority =3)
    public void getSearchResultTotalRecordsBeforeApplyingAnyFilter()
    {
        ResultsPage resultsPage = new ResultsPage(this.driver);
        System.out.println("Before applying any filter number of records are " + resultsPage.getSearchResult());
        System.out.println("Test 3 Passed");
    }
    @Test(alwaysRun = true, priority =4)
    public void getSearchResultTotalRecordsAfterApplyingYearsFilter()
    {
        ResultsPage resultsPage = new ResultsPage(this.driver);
        resultsPage.setManufacturingYearBegin();
        resultsPage.setManufacturingYearEnd();
        System.out.println("****************************************************************************");
        System.out.println("After applying the manufacturing year filter number of records are " + resultsPage.getSearchResult());
        System.out.println("Test 4 Passed");
    }

    @AfterSuite
    public void tearDown() {
        if (!(driver == null)) {
            driver.quit();
        }
    }
}