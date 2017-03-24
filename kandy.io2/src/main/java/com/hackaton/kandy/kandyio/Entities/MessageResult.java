package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class MessageResult
{
    private String server_timestamp;

    private Messages[] messages;

    public String getServer_timestamp ()
    {
        return server_timestamp;
    }

    public void setServer_timestamp (String server_timestamp)
    {
        this.server_timestamp = server_timestamp;
    }

    public Messages[] getMessages ()
    {
        return messages;
    }

    public void setMessages (Messages[] messages)
    {
        this.messages = messages;
    }

    @Override
    public String toString()
    {
        return "MessageResult [server_timestamp = "+server_timestamp+", messages = "+messages+"]";
    }
}