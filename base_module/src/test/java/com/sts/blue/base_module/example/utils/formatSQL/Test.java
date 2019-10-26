package com.sts.blue.base_module.example.utils.formatSQL;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sts.blue.base_module.static_value.annotation.EduExp;
import com.sts.blue.base_module.static_value.annotation.ForSQLClass;
import com.sts.blue.base_module.tools.AnnotationTool;
import com.sts.blue.base_module.utils.FormatSQL;

import java.util.Map;

public class Test {

    @org.junit.Test
    public void annoToolTest() {

        Entity_EduExp_Example entityEduExpExample = new Entity_EduExp_Example();
        entityEduExpExample.setBeginDate_("11111");
        entityEduExpExample.setEndDate("22222");
        entityEduExpExample.setDes("3333333");
        entityEduExpExample.setSchool("4444444");
        entityEduExpExample.setEdu("555555");
        entityEduExpExample.setMax(true);

        String enc = FormatSQL.Enc_forSql(Entity_EduExp_Example.class, entityEduExpExample, entityEduExpExample);
//
        int a = 1;

        String dec = FormatSQL.Dec_fromExp(enc, Entity_EduExp_Example.class);

        int b = 2;

    }
}
