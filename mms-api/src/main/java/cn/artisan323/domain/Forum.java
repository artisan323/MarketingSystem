package cn.artisan323.domain;

import java.io.Serializable;

public class Forum implements Serializable {
    private Integer fCde;

    private Integer funId;

    private String content;

    private String createTime;

    private Integer approvalStatus;

    public Integer getfCde() {
        return fCde;
    }

    public void setfCde(Integer fCde) {
        this.fCde = fCde;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}