package com.zww.ssm.domain;

/**
 * 游客实体类
 */
public class Traveller {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;//证件类型 0 身份证 1 其他
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;//游客类型 0 成人 1 儿童
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsType == 0){
            credentialsTypeStr = "身份证";
        }else{
            credentialsTypeStr ="其他";
        }
        return credentialsTypeStr;
    }



    public String getTravellerTypeStr() {
        if (travellerType == 0){
            travellerTypeStr = "成人";
        }else{
            travellerTypeStr ="儿童";
        }
        return travellerTypeStr;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }
}
