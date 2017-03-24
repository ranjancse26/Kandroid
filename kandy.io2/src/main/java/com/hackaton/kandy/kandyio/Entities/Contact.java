package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/11/2017.
 */

public class Contact
{
    private static final long serialVersionUID = 1L;
    private String sources;
    private String emailAddress;
    private int entryId;
    private String fax;
    private String firstName;
    private String lastName;
    private Boolean friend;
    private String homePhone;
    private String mobilePhone;
    private String nickName;
    private String pager;
    private String photoUrl;
    private String primaryContact;
    private String workPhone;

    public String getSources()
    {
        return this.sources;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public int getEntryId()
    {
        return this.entryId;
    }

    public String getFax()
    {
        return this.fax;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public Boolean getFriend()
    {
        return this.friend;
    }

    public String getHomePhone()
    {
        return this.homePhone;
    }

    public String getMobilePhone()
    {
        return this.mobilePhone;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public String getPager()
    {
        return this.pager;
    }

    public String getPhotoUrl()
    {
        return this.photoUrl;
    }

    public String getPrimaryContact()
    {
        return this.primaryContact;
    }

    public String getWorkPhone()
    {
        return this.workPhone;
    }

    public void setSources(String paramString)
    {
        this.sources = paramString;
    }

    public void setEmailAddress(String paramString)
    {
        this.emailAddress = paramString;
    }

    public void setEntryId(int paramInt)
    {
        this.entryId = paramInt;
    }

    public void setFax(String paramString)
    {
        this.fax = paramString;
    }

    public void setFirstName(String paramString)
    {
        this.firstName = paramString;
    }

    public void setLastName(String paramString)
    {
        this.lastName = paramString;
    }

    public void setFriend(Boolean paramBoolean)
    {
        this.friend = paramBoolean;
    }

    public void setHomePhone(String paramString)
    {
        this.homePhone = paramString;
    }

    public void setMobilePhone(String paramString)
    {
        this.mobilePhone = paramString;
    }

    public void setNickName(String paramString)
    {
        this.nickName = paramString;
    }

    public void setPager(String paramString)
    {
        this.pager = paramString;
    }

    public void setPhotoUrl(String paramString)
    {
        this.photoUrl = paramString;
    }

    public void setPrimaryContact(String paramString)
    {
        this.primaryContact = paramString;
    }

    public void setWorkPhone(String paramString)
    {
        this.workPhone = paramString;
    }
}
