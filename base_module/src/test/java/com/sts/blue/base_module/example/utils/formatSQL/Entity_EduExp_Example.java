package com.sts.blue.base_module.example.utils.formatSQL;

import com.sts.blue.base_module.static_value.annotation.EduExp;
import com.sts.blue.base_module.static_value.annotation.Enum_AnnoType;
import com.sts.blue.base_module.static_value.annotation.Enum_EduExpMean;
import com.sts.blue.base_module.static_value.annotation.ForSQLClass;

@ForSQLClass(Enum_AnnoType.EDU_EXP)
public class Entity_EduExp_Example {

    @EduExp(Enum_EduExpMean.BEGIN_DATE)
    private String beginDate_;// 开始日期

    @EduExp(Enum_EduExpMean.END_DATE)
    private String endDate; // 结束日期

    @EduExp(Enum_EduExpMean.SCHOOL)
    private String school; // 学校

    @EduExp(Enum_EduExpMean.EDU)
    private String edu; //学历

    @EduExp(Enum_EduExpMean.DES)
    private String des; //描述

    @EduExp(Enum_EduExpMean.IS_MAX)
    private String isMax; // 是否为第一学历

    public String getBeginDate_() {
        return beginDate_;
    }

    public void setBeginDate_(String beginDate) {
        this.beginDate_ = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isMax() {
        return Boolean.getBoolean(isMax);
    }

    public void setMax(boolean max) {
        isMax = max+"";
    }

    public void setIsMax(String max) {
        isMax = max;
    }
}
