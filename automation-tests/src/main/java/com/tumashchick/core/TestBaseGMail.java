package com.tumashchick.core;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import com.tumashchick.util.AccessProperties;
import com.tumashchick.util.ProjectConstants;
import org.testng.annotations.BeforeTest;

import static com.tumashchick.common.base.WebDriverContainer.open;

public class TestBaseGMail extends TestBase {

    private String userLogin;

    protected String getUserLogin() {
        return userLogin;
    }

    protected String getUserPassword() {
        return userPassword;
    }

    private String userPassword;

    public TestBaseGMail() {
        this.userLogin = ProjectConstants.G_MAIL_LOGIN_TEST_USER;
        //TODO Need to refactor this with Locators decision
        AccessProperties accessProperties = new AccessProperties();
        this.userPassword = accessProperties.getPropertyValueByName("GMailLoginTestUser.password");
    }

    @BeforeTest
    @Override
    public void setup() {
        super.setup();
        logger.info("Open URL: " + URIConstants.GOOGLE_BY_URI);
        open(URIConstants.GOOGLE_BY_URI);
    }
}
