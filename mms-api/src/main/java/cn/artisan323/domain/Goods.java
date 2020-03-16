package cn.artisan323.domain;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer gdCde;

    private String gdGroup;

    private String gdPath;

    private String gdUrl;

    private String createTime;

    private String gdPrice;

    private Integer belongId;

    private String gdDetails;

    private Integer hitCount;

    private Integer gdIndex;

    public Integer getGdCde() {
        return gdCde;
    }

    public void setGdCde(Integer gdCde) {
        this.gdCde = gdCde;
    }

    public String getGdGroup() {
        return gdGroup;
    }

    public void setGdGroup(String gdGroup) {
        this.gdGroup = gdGroup == null ? null : gdGroup.trim();
    }

    public String getGdPath() {
        return gdPath;
    }

    public void setGdPath(String gdPath) {
        this.gdPath = gdPath == null ? null : gdPath.trim();
    }

    public String getGdUrl() {
        return gdUrl;
    }

    public void setGdUrl(String gdUrl) {
        this.gdUrl = gdUrl == null ? null : gdUrl.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getGdPrice() {
        return gdPrice;
    }

    public void setGdPrice(String gdPrice) {
        this.gdPrice = gdPrice == null ? null : gdPrice.trim();
    }

    public Integer getBelongId() {
        return belongId;
    }

    public void setBelongId(Integer belongId) {
        this.belongId = belongId;
    }

    public String getGdDetails() {
        return gdDetails;
    }

    public void setGdDetails(String gdDetails) {
        this.gdDetails = gdDetails == null ? null : gdDetails.trim();
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public Integer getGdIndex() {
        return gdIndex;
    }

    public void setGdIndex(Integer gdIndex) {
        this.gdIndex = gdIndex;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gdCde=" + gdCde +
                ", gdGroup='" + gdGroup + '\'' +
                ", gdPath='" + gdPath + '\'' +
                ", gdUrl='" + gdUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", gdPrice='" + gdPrice + '\'' +
                ", belongId=" + belongId +
                ", gdDetails='" + gdDetails + '\'' +
                ", hitCount=" + hitCount +
                ", gdIndex=" + gdIndex +
                '}';
    }
}