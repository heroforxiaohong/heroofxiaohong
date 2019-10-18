package com.sts.blue.app_m.fun_bearer.account;

import com.sts.blue.app_m.base.CommonDao;
import com.sts.blue.app_m.mybatis_generator.dao.AccountLoginMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountPermissionMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountRoleMapper;
import com.sts.blue.app_m.mybatis_generator.dao.AccountUserMapper;
import com.sts.blue.app_m.mybatis_generator.entity.AccountLogin;
import com.sts.blue.app_m.mybatis_generator.entity.AccountPermission;
import com.sts.blue.app_m.mybatis_generator.entity.AccountRole;
import com.sts.blue.app_m.mybatis_generator.entity.AccountUser;
import com.sts.blue.base_module.listener.CallFunctionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CommonDao implements AccountService{

    @Autowired
    private AccountUserMapper accountUserMapper = null;

    @Autowired
    private AccountLoginMapper accountLoginMapper = null;

    @Autowired
    private AccountRoleMapper accountRoleMapper = null;

    @Autowired
    private AccountPermissionMapper accountPermissionMapper = null;

//    @Autowired
//    private C_AccountLoginMapper cAccountLoginMapper = null;

    @Override
    public void doLogin(String parame, CallFunctionListener listener) {
//        if (null == accountUserMapper){
//            accountUserMapper = ApplicationContextProvider.getBean(AccountUserMapper.class);
//        }

//        Entity_req_login reqLogin = (Entity_req_login) JSON.parse(parame);

//        if (cAccountLoginMapper == null){
//            cAccountLoginMapper = ApplicationContextProvider.getBean(C_AccountLoginMapper.class);
//        }

//        LoginInfo loginInfo = cAccountLoginMapper.doLoginByAccountName("13265656565");
//        if (loginInfo == null){
//
//        }

        AccountUser user = accountUserMapper.FindUserByPhoneAndEmail("13265656565");
        if (user == null || user.getUserId()==null){
            //TODO 2019-10-17 23:11:17 没有这个用户

            return;
        }

        AccountLogin loginInfo = accountLoginMapper.selectByPrimaryKey(user.getUserId());
//        if (!loginInfo.getLoginPasswd().equals(StrTool.getMD5(reqLogin.getLoginPasswd()))){
//            //TODO 2019-10-17 23:24:25 密码或账户名错误
//
//            return;
//        }

        AccountRole role = accountRoleMapper.selectByPrimaryKey(user.getUserRole());
        if (role == null){
            //TODO 2019-10-17 23:28:12 没有该角色

            return;
        }

        AccountPermission permission = accountPermissionMapper.selectByPrimaryKey(role.getRolePermissionId());
        if (permission == null){
            //TODO 2019-10-17 23:31:43 权限丢失，此时应提示页面联系高权限账户人员重新配置改角色权限（不应出现）

            return;
        }



    }
}
