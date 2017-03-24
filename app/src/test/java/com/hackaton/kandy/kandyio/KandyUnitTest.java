package com.hackaton.kandy.kandyio;

import android.security.NetworkSecurityPolicy;

import com.hackaton.kandy.kandyio.Entities.Contact;
import com.hackaton.kandy.kandyio.Entities.DomainUserDetails;
import com.hackaton.kandy.kandyio.Entities.Messages;
import com.hackaton.kandy.kandyio.Entities.SpidrConfigurationResponse;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.io.IOException;
import java.util.List;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, shadows = KandyUnitTest.MyNetworkSecurityPolicy.class, sdk=21)
public class KandyUnitTest {

    String apiKey;
    String apiSecretKey;
    String deviceID;
    String domainAccessToken;
    String domainUserAccessToken;
    String fromPhoneNumber;
    String toPhoneNumber;

    /*
    https://github.com/square/okhttp/issues/2533
     */
    @Implements(NetworkSecurityPolicy.class)
    public static class MyNetworkSecurityPolicy {
        @Implementation public static NetworkSecurityPolicy getInstance() {
            try {
                Class<?> shadow = MyNetworkSecurityPolicy.class.forName("android.security.NetworkSecurityPolicy");
                return (NetworkSecurityPolicy) shadow.newInstance();
            } catch (Exception e) {
                throw new AssertionError();
            }
        }

        @Implementation public boolean isCleartextTrafficPermitted() {
            return true;
        }
    }

    @Before
    public void setUp()
    {
        apiKey = new MainActivity().getResources().getString(
                R.string.apiKey);
        apiSecretKey = new MainActivity().getResources().getString(
                R.string.apiSecretKey);
        deviceID = new MainActivity().getResources().getString(
                R.string.deviceId);
        domainAccessToken = new MainActivity().getResources().getString(
                R.string.domainAccessToken);
        domainUserAccessToken = new MainActivity().getResources().getString(
                R.string.domainUserAccessToken);

        fromPhoneNumber = new MainActivity().getResources().getString(
                R.string.fromPhoneNumber);
        toPhoneNumber = new MainActivity().getResources().getString(
                R.string.toPhoneNumer);
    }

    @Test
    public void TestKandy_UserAccountAccessToken() throws IOException, JSONException {
        String userAccountAccessToken = GetUserAccountAccessToken();
        Assert.assertNotNull(userAccountAccessToken);
    }

    @Test
    public void TestKandy_DomainUserAccessToken() throws IOException, JSONException {
        domainUserAccessToken = GetDomainUserAccessToken();
    }

    @Test
    public void TestKandy_DomainUserDetails() throws IOException, JSONException {
        KandyDomainUser kandyDomainUser = new KandyDomainUser(apiKey,
                apiSecretKey);
        DomainUserDetails domainUserDetails =
                kandyDomainUser.GetDomainUserDetails(domainUserAccessToken);
    }

    @Test
    public void TestKandy_UserDeviceMessages() throws IOException, JSONException {
        KandyUserDevice kandyUserDevice = new
                KandyUserDevice(domainUserAccessToken,
                deviceID);
        List<Messages> messages = kandyUserDevice.GetDeviceMessages();
    }

    @Test
    public void TestKandy_SMSTest() throws IOException, JSONException {
        KandySMS kandySMS = new KandySMS(domainUserAccessToken);
        String response = kandySMS.SendSMS(deviceID,
                fromPhoneNumber, toPhoneNumber, "Test Message From Android Library");
    }

    @Test
    public void TestKandy_InstantMessageTest() throws IOException, JSONException {
        KandyInstantMessage kandyInstantMessage = new KandyInstantMessage(domainUserAccessToken);
        String response = kandyInstantMessage.SendInstantMessage(deviceID,
                "user2@kandy.hypercat.gmail.com", "Test Instant Message From Android Library");
    }


    @Test
    public void TestKandy_SMSSendCode() throws IOException, JSONException {
        KandySMSVerifier kandySMS = new KandySMSVerifier(domainAccessToken);
        String response = kandySMS.SendSMSVerificationCode(toPhoneNumber, "US");
    }

    @Test
    public void TestKandy_SMSVerifyCode() throws Exception {
        KandySMSVerifier kandySMS = new KandySMSVerifier(domainAccessToken);
        Boolean isValid = kandySMS.ValidateSMSCode("5023", "8473507167", "US");
    }

    @Test
    public void TestKandy_AddContacts() throws IOException, JSONException {
        KandyUserAddressBookContacts kandyUserAddressBookContacts = new
                KandyUserAddressBookContacts(domainUserAccessToken);

        Contact contact = new Contact();
        contact.setFirstName("Ranjan");
        contact.setLastName("Dailata");
        contact.setNickName("Ranjan");
        String response = kandyUserAddressBookContacts.AddContact(contact);
    }

    @Test
    public void TestKandy_GetAllContacts() throws IOException, JSONException {
        KandyUserAddressBookContacts kandyUserAddressBookContacts = new
                KandyUserAddressBookContacts(domainUserAccessToken);

        List<Contact> contacts = kandyUserAddressBookContacts.GetContacts();
    }

    @Test
    public void TestKandy_DeleteContactById() throws IOException, JSONException {
        KandyUserAddressBookContacts kandyUserAddressBookContacts = new
                KandyUserAddressBookContacts(domainUserAccessToken);

        String response =
                kandyUserAddressBookContacts.DeleteContact("9e018d28484242be83f090c7323bf275");
    }

    @Test
    public void TestKandy_GetSpidrConfiguration() throws IOException, JSONException {
        KandySpidrConfiguration kandySpidrConfiguration = new
                KandySpidrConfiguration(domainUserAccessToken);

        SpidrConfigurationResponse response =
                kandySpidrConfiguration.GetSpidrConfiguration();
    }

    private String GetUserAccountAccessToken() throws IOException, JSONException {
         KandyUserAccountAccessToken KandyAccessTokenObj = new KandyUserAccountAccessToken(apiKey, apiSecretKey);
        return KandyAccessTokenObj.GetUserAccountAccessToken();
    }

    private String GetDomainUserAccessToken() throws IOException, JSONException {
        KandyDomainUser kandyDomainUserAccessToken = new KandyDomainUser(apiKey, apiSecretKey);
        return kandyDomainUserAccessToken.GetDomainUserAccountAccessToken("user1");
    }
}