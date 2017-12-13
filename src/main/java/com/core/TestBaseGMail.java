package com.core;

import com.util.AccessProperties;
import com.util.ProjectConstants;
import com.util.URIConstants;
import org.testng.annotations.BeforeTest;

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
        AccessProperties accessProperties = new AccessProperties();
        this.userPassword = accessProperties.getPropertyValueByName("gmailLoginTestUser.password");
    }

    @BeforeTest
    @Override
    public void setup() {
        super.setup();
        logger.info("Open URI: " + URIConstants.GOOGLE_BY_URI);
        driver.get(URIConstants.GOOGLE_BY_URI);
    }
}
