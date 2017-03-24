package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class Messages
{
    private String timestamp;

    private Sender sender;

    private Message message;

    private String UUID;

    private String contentType;

    private String messageType;

    private String destination;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public Sender getSender ()
    {
        return sender;
    }

    public void setSender (Sender sender)
    {
        this.sender = sender;
    }

    public Message getMessage ()
    {
        return message;
    }

    public void setMessage (Message message)
    {
        this.message = message;
    }

    public String getUUID ()
    {
        return UUID;
    }

    public void setUUID (String UUID)
    {
        this.UUID = UUID;
    }

    public String getContentType ()
    {
        return contentType;
    }

    public void setContentType (String contentType)
    {
        this.contentType = contentType;
    }

    public String getMessageType ()
    {
        return messageType;
    }

    public void setMessageType (String messageType)
    {
        this.messageType = messageType;
    }

    public String getDestination ()
    {
        return destination;
    }

    public void setDestination (String destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString()
    {
        return "Messages [timestamp = "+timestamp+", sender = "+sender+", message = "+message+", UUID = "+UUID+", contentType = "+contentType+", messageType = "+messageType+", destination = "+destination+"]";
    }
}