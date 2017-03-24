package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class Iceserver
{
    private String credential;

    private String url;

    public String getCredential ()
    {
        return credential;
    }

    public void setCredential (String credential)
    {
        this.credential = credential;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "Iceserver [credential = "+credential+", url = "+url+"]";
    }
}
