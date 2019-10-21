package com.sts.blue.app_m.customer_mapper;

import com.sts.blue.app_m.fun_bearer.account.entity.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface C_AccountLoginMapper {

    LoginInfo doLoginByAccountName(String accountName);

}