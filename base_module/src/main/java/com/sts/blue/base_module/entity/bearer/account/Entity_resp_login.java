package com.sts.blue.base_module.entity.bearer.account;

public class Entity_resp_login {

    private int userID;

    private String userHeadIco;

    private int userRoleID;

    private String userName;

    private String userPhone;

    private String userMail;

    private String loginToken;

    private int loginWarrantStatus;

    private String roleName;

    private int rolePermissionID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserHeadIco() {
        return userHeadIco;
    }

    public void setUserHeadIco(String userHeadIco) {
        this.userHeadIco = userHeadIco;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public int getLoginWarrantStatus() {
        return loginWarrantStatus;
    }

    public void setLoginWarrantStatus(int loginWarrantStatus) {
        this.loginWarrantStatus = loginWarrantStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRolePermissionID() {
        return rolePermissionID;
    }

    public void setRolePermissionID(int rolePermissionID) {
        this.rolePermissionID = rolePermissionID;
    }
}
