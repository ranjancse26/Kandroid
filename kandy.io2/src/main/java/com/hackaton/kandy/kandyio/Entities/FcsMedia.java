package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class FcsMedia
{
    private String webrtcdtls;

    private String pluginMode;

    private Iceserver[] iceserver;

    public String getWebrtcdtls ()
    {
        return webrtcdtls;
    }

    public void setWebrtcdtls (String webrtcdtls)
    {
        this.webrtcdtls = webrtcdtls;
    }

    public String getPluginMode ()
    {
        return pluginMode;
    }

    public void setPluginMode (String pluginMode)
    {
        this.pluginMode = pluginMode;
    }

    public Iceserver[] getIceserver ()
    {
        return iceserver;
    }

    public void setIceserver (Iceserver[] iceserver)
    {
        this.iceserver = iceserver;
    }

    @Override
    public String toString()
    {
        return "FcsMedia [webrtcdtls = "+webrtcdtls+", pluginMode = "+pluginMode+", iceserver = "+iceserver+"]";
    }
}