package com.sts.blue.app_m.fun_bearer.account;

import com.sts.blue.app_m.base.ApplicationContextProvider;
import com.sts.blue.app_m.base.CommonDao;
import com.sts.blue.app_m.customer_mapper.C_AccountLoginMapper;
import com.sts.blue.app_m.fun_bearer.account.entity.LoginInfo;
import com.sts.blue.app_m.mybatis_generator.dao.AccountLoginMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountPermissionMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountRoleMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountUserMapper;
import com.sts.blue.app_m.mybatis_generator.entity.AccountLogin;
import com.sts.blue.app_m.mybatis_generator.entity.AccountPermission;
import com.sts.blue.app_m.mybatis_generator.entity.AccountRole;
import com.sts.blue.app_m.mybatis_generator.entity.AccountUser;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import com.sts.blue.base_module.listener.CallFunctionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CommonDao implements AccountService{

    @Autowired
    private AccountUserMapper accountUserMapper;
//
//    @Autowired
//    private AccountLoginMapper accountLoginMapper;
//
//    @Autowired
//    private AccountRoleMapper accountRoleMapper;
//
//    @Autowired
//    private AccountPermissionMapper accountPermissionMapper;

    @Autowired
    private C_AccountLoginMapper cAccountLoginMapper;

    @Override
    public void doLogin(Entity_req_login param, CallFunctionListener listener) {
//        if (null == accountUserMapper){
//            accountUserMapper = ApplicationContextProvider.getBean(AccountUserMapper.class);
//        }

//        Entity_req_login reqLogin = (Entity_req_login) JSON.parse(parame);

//        if (cAccountLoginMapper == null){
//            cAccountLoginMapper = ApplicationContextProvider.getBean(C_AccountLoginMapper.class);
//        }
//
//        LoginInfo loginInfo = cAccountLoginMapper.doLoginByAccountName("13265656565");
//        if (loginInfo == null){
//
//        }
//
//        AppMResponseValue value = new AppMResponseValue();
//        value.setData(loginInfo.getUserName());
//
//        listener.onReturn(value);

        if (accountUserMapper == null){
            accountUserMapper = ApplicationContextProvider.getBean(AccountUserMapper.class);
        }

        AccountUser user = accountUserMapper.selectByPrimaryKey(Integer.valueOf(0));
        if (user == null || user.getUserId()==null){
            //TODO 2019-10-17 23:11:17 没有这个用户

            user = new AccountUser();
            user.setUserName("没有这个用户");
        }

        AppMResponseValue value = new AppMResponseValue();
        value.setData(user.getUserName());

        listener.onReturn(value);

//        if (accountLoginMapper == null){
//            accountLoginMapper = ApplicationContextProvider.getBean(AccountLoginMapper.class);
//        }
//
//        AccountLogin loginInfo = accountLoginMapper.selectByPrimaryKey(Integer.valueOf(0));
//
//        AppMResponseValue value = new AppMResponseValue();
//        value.setData(loginInfo.getLoginToken());
//
//        listener.onReturn(value);


//        if (!loginInfo.getLoginPasswd().equals(StrTool.getMD5(reqLogin.getLoginPasswd()))){
//            //TODO 2019-10-17 23:24:25 密码或账户名错误
//
//            return;
//        }

//        AccountRole role = accountRoleMapper.selectByPrimaryKey(user.getUserRole());
//        if (role == null){
//            //TODO 2019-10-17 23:28:12 没有该角色
//
//            return;
//        }
//
//        AccountPermission permission = accountPermissionMapper.selectByPrimaryKey(role.getRolePermissionId());
//        if (permission == null){
//            //TODO 2019-10-17 23:31:43 权限丢失，此时应提示页面联系高权限账户人员重新配置改角色权限（不应出现）
//
//            return;
//        }


    }
}
