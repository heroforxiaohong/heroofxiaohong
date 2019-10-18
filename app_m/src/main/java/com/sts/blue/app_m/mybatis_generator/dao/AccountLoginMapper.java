package com.sts.blue.app_m.mybatis_generator.dao;

import com.sts.blue.app_m.mybatis_generator.entity.AccountLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer loginUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    int insert(AccountLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    int insertSelective(AccountLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    AccountLogin selectByPrimaryKey(Integer loginUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AccountLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_login
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AccountLogin record);
}