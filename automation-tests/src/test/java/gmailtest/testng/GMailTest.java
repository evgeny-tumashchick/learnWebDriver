package gmailtest.testng;

import com.tumashchick.core.TestBaseGMail;
import com.tumashchick.pages.pageobjectstaticlocators.GoogleHomePageStatic;
import com.tumashchick.pages.pageobjectstaticlocators.GoogleLoginPageStatic;
import com.tumashchick.pages.pageobjectstaticlocators.GoogleMailMainPageStatic;
import com.tumashchick.pages.pageopbjectwithpropwrties.GoogleHomePageLocatorsProperty;
import com.tumashchick.pages.pageopbjectwithpropwrties.GoogleLoginPageLocatorsProperty;
import com.tumashchick.pages.pageopbjectwithpropwrties.GoogleMailMainPageLocatorsProperty;
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
        GoogleHomePageLocatorsProperty.clickLoginButton();
        GoogleLoginPageLocatorsProperty.signInAccountOpenMailBox(getUserLogin(), getUserPassword());
        Assert.assertTrue(GoogleMailMainPageLocatorsProperty.countEmails() > 0);
    }
}
