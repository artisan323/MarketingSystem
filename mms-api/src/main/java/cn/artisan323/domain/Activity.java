package cn.artisan323.domain;

public class Activity {
    private Integer aCde;

    private String name;

    private String startTime;

    private String endTime;

    private String desc;

    public Integer getaCde() {
        return aCde;
    }

    public void setaCde(Integer aCde) {
        this.aCde = aCde;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}