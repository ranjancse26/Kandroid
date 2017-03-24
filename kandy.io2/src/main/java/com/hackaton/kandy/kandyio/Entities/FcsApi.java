package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class FcsApi
{
    private String audit_packet_frequency;

    private String subscription_expire_time_seconds;

    private String websocketIP;

    private String protocol;

    private String iceCandidateCollectionTimeoutInterval;

    private String websocketProtocol;

    private String serverProvidedTurnCredentials;

    private String websocketPort;

    private String restUrl;

    private String audit_enable;

    private String restPort;

    public String getAudit_packet_frequency ()
    {
        return audit_packet_frequency;
    }

    public void setAudit_packet_frequency (String audit_packet_frequency)
    {
        this.audit_packet_frequency = audit_packet_frequency;
    }

    public String getSubscription_expire_time_seconds ()
    {
        return subscription_expire_time_seconds;
    }

    public void setSubscription_expire_time_seconds (String subscription_expire_time_seconds)
    {
        this.subscription_expire_time_seconds = subscription_expire_time_seconds;
    }

    public String getWebsocketIP ()
    {
        return websocketIP;
    }

    public void setWebsocketIP (String websocketIP)
    {
        this.websocketIP = websocketIP;
    }

    public String getProtocol ()
    {
        return protocol;
    }

    public void setProtocol (String protocol)
    {
        this.protocol = protocol;
    }

    public String getIceCandidateCollectionTimeoutInterval ()
    {
        return iceCandidateCollectionTimeoutInterval;
    }

    public void setIceCandidateCollectionTimeoutInterval (String iceCandidateCollectionTimeoutInterval)
    {
        this.iceCandidateCollectionTimeoutInterval = iceCandidateCollectionTimeoutInterval;
    }

    public String getWebsocketProtocol ()
    {
        return websocketProtocol;
    }

    public void setWebsocketProtocol (String websocketProtocol)
    {
        this.websocketProtocol = websocketProtocol;
    }

    public String getServerProvidedTurnCredentials ()
    {
        return serverProvidedTurnCredentials;
    }

    public void setServerProvidedTurnCredentials (String serverProvidedTurnCredentials)
    {
        this.serverProvidedTurnCredentials = serverProvidedTurnCredentials;
    }

    public String getWebsocketPort ()
    {
        return websocketPort;
    }

    public void setWebsocketPort (String websocketPort)
    {
        this.websocketPort = websocketPort;
    }

    public String getRestUrl ()
    {
        return restUrl;
    }

    public void setRestUrl (String restUrl)
    {
        this.restUrl = restUrl;
    }

    public String getAudit_enable ()
    {
        return audit_enable;
    }

    public void setAudit_enable (String audit_enable)
    {
        this.audit_enable = audit_enable;
    }

    public String getRestPort ()
    {
        return restPort;
    }

    public void setRestPort (String restPort)
    {
        this.restPort = restPort;
    }

    @Override
    public String toString()
    {
        return "FcsApi [audit_packet_frequency = "+audit_packet_frequency+", subscription_expire_time_seconds = "+subscription_expire_time_seconds+", websocketIP = "+websocketIP+", protocol = "+protocol+", iceCandidateCollectionTimeoutInterval = "+iceCandidateCollectionTimeoutInterval+", websocketProtocol = "+websocketProtocol+", serverProvidedTurnCredentials = "+serverProvidedTurnCredentials+", websocketPort = "+websocketPort+", restUrl = "+restUrl+", audit_enable = "+audit_enable+", restPort = "+restPort+"]";
    }
}
