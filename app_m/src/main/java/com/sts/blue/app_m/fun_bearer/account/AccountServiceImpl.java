package com.sts.blue.app_m.fun_bearer.account;

import com.sts.blue.app_m.base.ApplicationContextProvider;
import com.sts.blue.app_m.base.CommonDao;
import com.sts.blue.app_m.customer_mapper.C_AccountLoginMapper;
import com.sts.blue.app_m.fun_bearer.account.entity.LoginInfo;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import com.sts.blue.base_module.entity.bearer.account.Entity_resp_login;
import com.sts.blue.base_module.listener.CallFunctionListener;
import com.sts.blue.base_module.tools.StrTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CommonDao implements AccountService{

//    @Autowired
//    private AccountUserMapper accountUserMapper;
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

        AppMResponseValue value = new AppMResponseValue();

        if (cAccountLoginMapper == null){
            cAccountLoginMapper = ApplicationContextProvider.getBean(C_AccountLoginMapper.class);
        }

        //注意loginInfo的父类，在C 只用了它的父类返回给前端，来屏蔽掉 passwd 字段， 数据库中的passwd根据业务只存在于M机即可
        LoginInfo loginInfo = cAccountLoginMapper.doLoginByAccountName(param.getLoginName());

        value.setData((Entity_resp_login)loginInfo); // 存放C机需要的实体类

        if (loginInfo == null || loginInfo.getUserID() < 0){
            value.setType(1); // type值，与C机约定即可
            value.setMsg("当前用户未注册，请检查用户名是否正确");
            listener.onReturn(value);
            return;
        }

        String md5 = StrTool.getMD5(param.getLoginPasswd());

        if (!loginInfo.getPasswd().equals(StrTool.getMD5(param.getLoginPasswd()))){
            value.setType(2);
            value.setMsg("密码错误，请检查用户名是否正确");
            listener.onReturn(value);
            return;
        }

        if (loginInfo.getUserRoleID() < 0){
            value.setType(3);
            value.setMsg("该用户未设置角色");
            listener.onReturn(value);
            return;
        }

        if (loginInfo.getRolePermissionID() < 0){
            //权限丢失，此时应提示页面联系高权限账户人员重新配置改角色权限（不应出现）
            value.setType(4);
            value.setMsg("未设置角色权限");
            listener.onReturn(value);
            return;
        }

        value.setType(0);
        value.setMsg("验证通过");
        listener.onReturn(value);
    }
}
