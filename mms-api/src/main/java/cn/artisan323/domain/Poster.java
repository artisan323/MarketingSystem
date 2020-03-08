package cn.artisan323.domain;

import java.io.Serializable;

/**
 * 海报文件实体类
 * @author wannengqingnian
 */
public class Poster implements Serializable {

    /**
     * 主键ID
     */
    private Integer posterId;

    /**
     * 文件所有者ID
     */
    private Integer belongUsrId;

    /**
     * 生成海报全路径
     */
    private String posterFullPath;

    /**
     * 生成海报存放路径
     */
    private String posterFolderPath;

    /**
     * 上传图片名称
     */
    private String upImgName;

    /**
     * 上传图片全路径
     */
    private String upImgFullPath;

    /**
     * 最终生成文件大小
     */
    private String posterFileSize;

    /**
     * 文件后缀
     */
    private String suffix;

    /**
     * 图片文字信息
     */
    private String slogen;

    /**
     * 背景图片位置
     */
    private String backgrandFullPath;

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public Integer getBelongUsrId() {
        return belongUsrId;
    }

    public void setBelongUsrId(Integer belongUsrId) {
        this.belongUsrId = belongUsrId;
    }

    public String getPosterFullPath() {
        return posterFullPath;
    }

    public void setPosterFullPath(String posterFullPath) {
        this.posterFullPath = posterFullPath;
    }

    public String getPosterFolderPath() {
        return posterFolderPath;
    }

    public void setPosterFolderPath(String posterFolderPath) {
        this.posterFolderPath = posterFolderPath;
    }

    public String getUpImgName() {
        return upImgName;
    }

    public void setUpImgName(String upImgName) {
        this.upImgName = upImgName;
    }

    public String getUpImgFullPath() {
        return upImgFullPath;
    }

    public void setUpImgFullPath(String upImgFullPath) {
        this.upImgFullPath = upImgFullPath;
    }

    public String getPosterFileSize() {
        return posterFileSize;
    }

    public void setPosterFileSize(String posterFileSize) {
        this.posterFileSize = posterFileSize;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSlogen() {
        return slogen;
    }

    public void setSlogen(String slogen) {
        this.slogen = slogen;
    }

    public String getBackgrandFullPath() {
        return backgrandFullPath;
    }

    public void setBackgrandFullPath(String backgrandFullPath) {
        this.backgrandFullPath = backgrandFullPath;
    }
}
