package com.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuRole {

    private final List<String> permission = Arrays.asList("c", "d", "u" ,"r", "i", "o");


    private Long menuRoleId;

    private Long roleId;

    private Long menuId;

    private String jurisdiction;

    private ArrayList<String> permissions;

    public Long getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenuRoleId(Long menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public List getPermissions()
    {
        this.permissions = new ArrayList<>();
        for(int i = 0; i < this.jurisdiction.length(); i++)
        {
            if(this.jurisdiction.charAt(i) == '1')
            {
                this.permissions.add(permission.get(i));
            }
        }
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions)
    {
        this.permissions = permissions;
    }
}