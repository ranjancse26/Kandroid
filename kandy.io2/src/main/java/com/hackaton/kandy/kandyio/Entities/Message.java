package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class Message
{
    private String text;

    private String mimeType;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getMimeType ()
    {
        return mimeType;
    }

    public void setMimeType (String mimeType)
    {
        this.mimeType = mimeType;
    }

    @Override
    public String toString()
    {
        return "Message [text = "+text+", mimeType = "+mimeType+"]";
    }
}