package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class SpidrConfiguration
{
    private String ice_collection_timeout;

    private String preferred_audio_codec_enum;

    private String audit_packet_frequency;

    private String REST_server_port;

    private FcsApi fcsApi;

    private String webSocket_server_port;

    private String use_DTLS;

    private String webSocket_secure;

    private String REST_server_address;

    private String webSocket_server_address;

    private Versions[] versions;

    private String subscription_expire_time_seconds;

    private FcsMedia fcsMedia;

    private String ICE_server_address;

    private String[] ICE_servers;

    private String REST_API_version;

    private String audit_enable;

    private String REST_protocol;

    private String ICE_server_port;

    public String getIce_collection_timeout ()
    {
        return ice_collection_timeout;
    }

    public void setIce_collection_timeout (String ice_collection_timeout)
    {
        this.ice_collection_timeout = ice_collection_timeout;
    }

    public String getPreferred_audio_codec_enum ()
    {
        return preferred_audio_codec_enum;
    }

    public void setPreferred_audio_codec_enum (String preferred_audio_codec_enum)
    {
        this.preferred_audio_codec_enum = preferred_audio_codec_enum;
    }

    public String getAudit_packet_frequency ()
    {
        return audit_packet_frequency;
    }

    public void setAudit_packet_frequency (String audit_packet_frequency)
    {
        this.audit_packet_frequency = audit_packet_frequency;
    }

    public String getREST_server_port ()
    {
        return REST_server_port;
    }

    public void setREST_server_port (String REST_server_port)
    {
        this.REST_server_port = REST_server_port;
    }

    public FcsApi getFcsApi ()
    {
        return fcsApi;
    }

    public void setFcsApi (FcsApi fcsApi)
    {
        this.fcsApi = fcsApi;
    }

    public String getWebSocket_server_port ()
    {
        return webSocket_server_port;
    }

    public void setWebSocket_server_port (String webSocket_server_port)
    {
        this.webSocket_server_port = webSocket_server_port;
    }

    public String getUse_DTLS ()
    {
        return use_DTLS;
    }

    public void setUse_DTLS (String use_DTLS)
    {
        this.use_DTLS = use_DTLS;
    }

    public String getWebSocket_secure ()
    {
        return webSocket_secure;
    }

    public void setWebSocket_secure (String webSocket_secure)
    {
        this.webSocket_secure = webSocket_secure;
    }

    public String getREST_server_address ()
    {
        return REST_server_address;
    }

    public void setREST_server_address (String REST_server_address)
    {
        this.REST_server_address = REST_server_address;
    }

    public String getWebSocket_server_address ()
    {
        return webSocket_server_address;
    }

    public void setWebSocket_server_address (String webSocket_server_address)
    {
        this.webSocket_server_address = webSocket_server_address;
    }

    public Versions[] getVersions ()
    {
        return versions;
    }

    public void setVersions (Versions[] versions)
    {
        this.versions = versions;
    }

    public String getSubscription_expire_time_seconds ()
    {
        return subscription_expire_time_seconds;
    }

    public void setSubscription_expire_time_seconds (String subscription_expire_time_seconds)
    {
        this.subscription_expire_time_seconds = subscription_expire_time_seconds;
    }

    public FcsMedia getFcsMedia ()
    {
        return fcsMedia;
    }

    public void setFcsMedia (FcsMedia fcsMedia)
    {
        this.fcsMedia = fcsMedia;
    }

    public String getICE_server_address ()
    {
        return ICE_server_address;
    }

    public void setICE_server_address (String ICE_server_address)
    {
        this.ICE_server_address = ICE_server_address;
    }

    public String[] getICE_servers ()
    {
        return ICE_servers;
    }

    public void setICE_servers (String[] ICE_servers)
    {
        this.ICE_servers = ICE_servers;
    }

    public String getREST_API_version ()
    {
        return REST_API_version;
    }

    public void setREST_API_version (String REST_API_version)
    {
        this.REST_API_version = REST_API_version;
    }

    public String getAudit_enable ()
    {
        return audit_enable;
    }

    public void setAudit_enable (String audit_enable)
    {
        this.audit_enable = audit_enable;
    }

    public String getREST_protocol ()
    {
        return REST_protocol;
    }

    public void setREST_protocol (String REST_protocol)
    {
        this.REST_protocol = REST_protocol;
    }

    public String getICE_server_port ()
    {
        return ICE_server_port;
    }

    public void setICE_server_port (String ICE_server_port)
    {
        this.ICE_server_port = ICE_server_port;
    }

    @Override
    public String toString()
    {
        return "SpidrConfiguration [ice_collection_timeout = "+ice_collection_timeout+"," +
                " preferred_audio_codec_enum = "+preferred_audio_codec_enum+", " +
                "audit_packet_frequency = "+audit_packet_frequency+", " +
                "REST_server_port = "+REST_server_port+"," +
                " fcsApi = "+fcsApi+", " +
                "webSocket_server_port = "+webSocket_server_port+"," +
                " use_DTLS = "+use_DTLS+", webSocket_secure = "+webSocket_secure+", " +
                "REST_server_address = "+REST_server_address+", " +
                "webSocket_server_address = "+webSocket_server_address+", " +
                "versions = "+versions+", " +
                "subscription_expire_time_seconds = "+subscription_expire_time_seconds+", " +
                "fcsMedia = "+fcsMedia+", ICE_server_address = "+ICE_server_address+", " +
                "ICE_servers = "+ICE_servers+", REST_API_version = "+REST_API_version+"," +
                "audit_enable = "+audit_enable+", REST_protocol = "+REST_protocol+", " +
                "ICE_server_port = "+ICE_server_port+"]";
    }
}