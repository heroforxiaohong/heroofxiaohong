package com.sts.blue.app_m.mybatis_generator.entity;

import java.util.Date;

public class AccountLogin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.login_user_id
     *
     * @mbggenerated
     */
    private Integer loginUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.login_passwd
     *
     * @mbggenerated
     */
    private String loginPasswd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.login_token
     *
     * @mbggenerated
     */
    private String loginToken;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.login_token_validity_period
     *
     * @mbggenerated
     */
    private Date loginTokenValidityPeriod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.login_warrant_status
     *
     * @mbggenerated
     */
    private Integer loginWarrantStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.login_user_id
     *
     * @return the value of account_login.login_user_id
     *
     * @mbggenerated
     */
    public Integer getLoginUserId() {
        return loginUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.login_user_id
     *
     * @param loginUserId the value for account_login.login_user_id
     *
     * @mbggenerated
     */
    public void setLoginUserId(Integer loginUserId) {
        this.loginUserId = loginUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.login_passwd
     *
     * @return the value of account_login.login_passwd
     *
     * @mbggenerated
     */
    public String getLoginPasswd() {
        return loginPasswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.login_passwd
     *
     * @param loginPasswd the value for account_login.login_passwd
     *
     * @mbggenerated
     */
    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.login_token
     *
     * @return the value of account_login.login_token
     *
     * @mbggenerated
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.login_token
     *
     * @param loginToken the value for account_login.login_token
     *
     * @mbggenerated
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.login_token_validity_period
     *
     * @return the value of account_login.login_token_validity_period
     *
     * @mbggenerated
     */
    public Date getLoginTokenValidityPeriod() {
        return loginTokenValidityPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.login_token_validity_period
     *
     * @param loginTokenValidityPeriod the value for account_login.login_token_validity_period
     *
     * @mbggenerated
     */
    public void setLoginTokenValidityPeriod(Date loginTokenValidityPeriod) {
        this.loginTokenValidityPeriod = loginTokenValidityPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.login_warrant_status
     *
     * @return the value of account_login.login_warrant_status
     *
     * @mbggenerated
     */
    public Integer getLoginWarrantStatus() {
        return loginWarrantStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.login_warrant_status
     *
     * @param loginWarrantStatus the value for account_login.login_warrant_status
     *
     * @mbggenerated
     */
    public void setLoginWarrantStatus(Integer loginWarrantStatus) {
        this.loginWarrantStatus = loginWarrantStatus;
    }
}