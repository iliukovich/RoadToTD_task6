package kinopoisk.tests;

import driver.DriverHolder;
import kinopoisk.forms.HeaderForm;
import kinopoisk.pages.AdvancedSearchPage;
import kinopoisk.pages.SearchResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchKinopoisk {

    private static final String KINOPOISK_URL = "https://www.kinopoisk.ru/";
    private Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {
        DriverHolder.getInstance().manage().window().maximize();
        log.info("Opening Kinopoisk site");
        DriverHolder.getInstance().get(KINOPOISK_URL);
    }

    @Test(dataProvider = "searchData", dataProviderClass = KinopoiskSearchDataProvider.class)
    public void checkAdvancedSearchButton(String filmName, Integer fromYear, Integer toYear, String contentType, String expectedFilmName) {
        HeaderForm header = new HeaderForm();
        header.clickAdvancedSearch();
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
        Assert.assertTrue(advancedSearchPage.getSearchByFilmForm().isDisplayed(), "Search by film form is not displayed");

        advancedSearchPage.getSearchByFilmForm().fillFindFilmTextbox(filmName);
        advancedSearchPage.getSearchByFilmForm().selectFromYear(fromYear);
        advancedSearchPage.getSearchByFilmForm().selectToYear(toYear);
        advancedSearchPage.getSearchByFilmForm().selectContentType(contentType);
        advancedSearchPage.getSearchByFilmForm().clickSearch();

        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertTrue(searchResultPage.isFilmDisplayed(expectedFilmName), String.format("The film '%s' is not displayed on search result page", expectedFilmName));
    }

    @AfterMethod
    public void tearDown() {
        log.info("Cleaning browser");
        DriverHolder.clean();
    }
}
