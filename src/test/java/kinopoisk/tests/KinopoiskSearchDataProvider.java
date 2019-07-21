package kinopoisk.tests;

import org.testng.annotations.DataProvider;

public class KinopoiskSearchDataProvider {
    @DataProvider(name = "searchData")
    public Object[][] provideUserData() {

        return new Object[][]{{"игра", 2011, 2020, "serial", "Игра престолов"}};

    }
}
