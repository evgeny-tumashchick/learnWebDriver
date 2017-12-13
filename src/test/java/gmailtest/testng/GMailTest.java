package gmailtest.testng;

import com.core.TestBaseGMail;
import com.pages.pageobjectstaticlocators.GoogleHomePageStatic;
import com.pages.pageobjectstaticlocators.GoogleLoginPageStatic;
import com.pages.pageobjectstaticlocators.GoogleMailMainPageStatic;
import com.pages.pageopbjectwithpropwrties.GoogleHomePageLocatorsProperty;
import com.pages.pageopbjectwithpropwrties.GoogleLoginPageLocatorsProperty;
import com.pages.pageopbjectwithpropwrties.GoogleMailMainPageLocatorsProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GMailTest extends TestBaseGMail {

    @Test
    public void loginToGmailVerifyEmailsExistsStaticPageObjectTest() {
        GoogleHomePageStatic.clickLoginButton(driver);
        GoogleLoginPageStatic.signInAccountOpenMailBox(driver, getUserLogin(), getUserPassword());
        Assert.assertTrue(GoogleMailMainPageStatic.countEmails(driver) > 0);
    }

    @Test
    public void loginToGmailVerifyEmailsExistsPageObjectLocatorsPropertyTest() {
        GoogleHomePageLocatorsProperty.clickLoginButton(driver);
        GoogleLoginPageLocatorsProperty.signInAccountOpenMailBox(driver, getUserLogin(), getUserPassword());
        Assert.assertTrue(GoogleMailMainPageLocatorsProperty.countEmails(driver) > 0);
    }
}
