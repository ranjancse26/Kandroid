# Kandroid
Kandroid  - A Kandy Android Library

# Project Overview

Kandroid - A tiny, easy to use library for Kandy. Kandy provides REST API’s using which, we are going to code an Android helper library that one can use for building Android Apps consuming Kandy API.

Kandy provides an Android Library using which one can easily code and accomplish a lot. If you question about unique features, that’s where the Kandroid comes into picture. It’s just not a helper library 

# Supporting Material & Info

Please take a look into https://www.collaborizm.com/project/SJMJAKo9x

**Completed List**:

- [x] Kandy SMS and Instant Message Implementation

- [x] Kandy SMS Send Code and Verification

- [x] User, Account and Domain Access Token related implemention

- [x] Kandy Device - Fetch all device messages

- [x] Kandy User Addressbook Contact Management 
	- [x] Get Contacts
	- [x] Add/Delete Contact

- [x] Kandy Spidr Configuration Implementation

- [x] Kandy manage user personal address book contacts

- [x] WebRTC Text and Video chat using PeerJS and Kandy ICE TURN Servers

# Core Android HTTP Library

We are going to make use of OkHttp library for making a Kandy REST API call. Here’s the one liner definition about OkHttp “An HTTP & HTTP/2 client for Android and Java applications”. Source - http://square.github.io/okhttp/

# Getting Started 

Kandroid was built using Android Studio. The first thing you need to do is download and install "Android Studio" if you don't have one. Just open up the project and start building it. That's it!

There are two main projects

1) App - It's the Android Test Application consumes Kandroid Library and runs Unit Tests.
2) Kandy.io2 - It's the Kandroid Library. The core of library is the Kandy REST API

# Basic Setup

Please make sure to setup the below ones. The below ApiKey and SecretKey should be obtained as part of the Kandy.IO Registration.

<string name="apiKey"></string>
<string name="apiSecretKey"></string>

The below ones can be set by running the appropriate unit test code. You will see next.

<string name="domainAccessToken"></string>
<string name="domainUserAccessToken"></string>

![Api Keys](https://github.com/ranjancse26/Kandroid/blob/master/KandySetup-ApiKeys.png)

![String.xml](https://github.com/ranjancse26/Kandroid/blob/master/KandySetup-Strings.png)

# Unit Tests

Here's the code snippet of Kandy Unit Test which is used for setting up the Api Keys etc.

```
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
```

Here's the code snippet for fetching the User and Domain Access Token

```
private String GetUserAccountAccessToken() throws IOException, JSONException {
         KandyUserAccountAccessToken KandyAccessTokenObj = new KandyUserAccountAccessToken(apiKey, apiSecretKey);
        return KandyAccessTokenObj.GetUserAccountAccessToken();
}

private String GetDomainUserAccessToken() throws IOException, JSONException {
        KandyDomainUser kandyDomainUserAccessToken = new KandyDomainUser(apiKey, apiSecretKey);
        return kandyDomainUserAccessToken.GetDomainUserAccountAccessToken("user1");
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
```

Send SMS and Instant Message related unit tests

```
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
```

SMS Send Code and Verification related Unit Tests

```
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
```

Fetch User Device Messages

```
@Test
public void TestKandy_UserDeviceMessages() throws IOException, JSONException {
        KandyUserDevice kandyUserDevice = new
                KandyUserDevice(domainUserAccessToken,
                deviceID);
        List<Messages> messages = kandyUserDevice.GetDeviceMessages();
}
```

Kandy User Addressbook Management (Basic CRUD Operation)

```
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
 ```
 

