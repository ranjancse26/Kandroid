package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class StatusDescription {

    private String message;

    private String code;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "StatusDescription [message = "+message+", code = "+code+"]";
    }
}
