package com.sts.blue.app_m.mybatis_generator.entity;

public class AccountLogin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_login.passwd
     *
     * @mbggenerated
     */
    private String passwd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.id
     *
     * @return the value of account_login.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.id
     *
     * @param id the value for account_login.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.user_id
     *
     * @return the value of account_login.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.user_id
     *
     * @param userId the value for account_login.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_login.passwd
     *
     * @return the value of account_login.passwd
     *
     * @mbggenerated
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_login.passwd
     *
     * @param passwd the value for account_login.passwd
     *
     * @mbggenerated
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }
}