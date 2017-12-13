package gmailtest.testng;

import com.core.TestBaseGMail;
import com.pages.pageobjectstaticlocators.GoogleHomePageStatic;
import com.pages.pageobjectstaticlocators.GoogleMailMainPageStatic;
import com.pages.pageobjectstaticlocators.GoogleLoginPageStatic;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GMailTest extends TestBaseGMail {

    @Test
    public void loginToGmailVerifyEmailsExistsStaticPageObjectTest() {
        GoogleHomePageStatic.clickLoginButton(driver);
        GoogleLoginPageStatic.signInAccountOpenMailBox(driver, getUserLogin(), getUserPassword());
        Assert.assertTrue(GoogleMailMainPageStatic.countEmails(driver) > 0);
    }
}
