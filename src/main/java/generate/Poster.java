package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * POSTER
 * @author 
 */
@Data
public class Poster implements Serializable {
    private Integer posterId;

    /**
     * 文件所属者id
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

    private static final long serialVersionUID = 1L;
}