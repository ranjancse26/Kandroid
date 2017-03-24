package com.hackaton.kandy.kandyio.Entities;

import java.util.ArrayList;

/**
 * Created by RanjanD on 3/13/2017.
 */

public class GroupInfo
{
    private String group_id;

    public String getGroupId() { return this.group_id; }

    public void setGroupId(String group_id) { this.group_id = group_id; }

    private String group_name;

    public String getGroupName() { return this.group_name; }

    public void setGroupName(String group_name) { this.group_name = group_name; }

    private GroupImage group_image;

    public GroupImage getGroupImage() { return this.group_image; }

    public void setGroupImage(GroupImage group_image) { this.group_image = group_image; }

    private String max_members;

    public String getMaxMembers() { return this.max_members; }

    public void setMaxMembers(String max_members) { this.max_members = max_members; }

    private ArrayList<Owner> owners;

    public ArrayList<Owner> getOwners() { return this.owners; }

    public void setOwners(ArrayList<Owner> owners) { this.owners = owners; }
}