package com.sts.blue.app_m.mybatis_generator.dao;

import com.sts.blue.app_m.mybatis_generator.entity.AccountUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    int insert(AccountUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    int insertSelective(AccountUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    AccountUser selectByPrimaryKey(Integer userId);

    /**
     * 通过手机号或邮箱寻找userID
     * */
    AccountUser FindUserByPhoneAndEmail(String accountName);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    Integer updateByPrimaryKeySelective(AccountUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AccountUser record);


}