package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class Sender
{
    private String full_user_id;

    private String domain_name;

    private String user_id;

    public String getFull_user_id ()
    {
        return full_user_id;
    }

    public void setFull_user_id (String full_user_id)
    {
        this.full_user_id = full_user_id;
    }

    public String getDomain_name ()
    {
        return domain_name;
    }

    public void setDomain_name (String domain_name)
    {
        this.domain_name = domain_name;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    @Override
    public String toString()
    {
        return "Sender [full_user_id = "+full_user_id+", domain_name = "+domain_name+", user_id = "+user_id+"]";
    }
}