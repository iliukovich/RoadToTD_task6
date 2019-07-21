package kinopoisk.forms;

import driver.DriverHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseForm {
    protected Logger log = LogManager.getLogger();

    public BaseForm() {
        PageFactory.initElements(DriverHolder.getInstance(), this);
    }

}
