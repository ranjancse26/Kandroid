package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class Versions
{
    private String useProxy;

    private FcsApi fcsApi;

    public String getUseProxy ()
    {
        return useProxy;
    }

    public void setUseProxy (String useProxy)
    {
        this.useProxy = useProxy;
    }

    public FcsApi getFcsApi ()
    {
        return fcsApi;
    }

    public void setFcsApi (FcsApi fcsApi)
    {
        this.fcsApi = fcsApi;
    }

    @Override
    public String toString()
    {
        return "Versions [useProxy = "+useProxy+", fcsApi = "+fcsApi+"]";
    }
}