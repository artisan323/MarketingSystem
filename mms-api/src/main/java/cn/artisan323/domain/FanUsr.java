package cn.artisan323.domain;

import java.io.Serializable;

public class FanUsr implements Serializable {
    private Integer fanCde;

    private String fanName;

    private String fanPassword;

    private String wechatId;

    private String fanPhone;

    private String qqId;

    private String reward;

    public Integer getFanCde() {
        return fanCde;
    }

    public void setFanCde(Integer fanCde) {
        this.fanCde = fanCde;
    }

    public String getFanName() {
        return fanName;
    }

    public void setFanName(String fanName) {
        this.fanName = fanName == null ? null : fanName.trim();
    }

    public String getFanPassword() {
        return fanPassword;
    }

    public void setFanPassword(String fanPassword) {
        this.fanPassword = fanPassword == null ? null : fanPassword.trim();
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getFanPhone() {
        return fanPhone;
    }

    public void setFanPhone(String fanPhone) {
        this.fanPhone = fanPhone == null ? null : fanPhone.trim();
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId == null ? null : qqId.trim();
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward == null ? null : reward.trim();
    }

    @Override
    public String toString() {
        return "FanUsr{" +
                "fanCde=" + fanCde +
                ", fanName='" + fanName + '\'' +
                ", fanPassword='" + fanPassword + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", fanPhone='" + fanPhone + '\'' +
                ", qqId='" + qqId + '\'' +
                ", reward='" + reward + '\'' +
                '}';
    }
}