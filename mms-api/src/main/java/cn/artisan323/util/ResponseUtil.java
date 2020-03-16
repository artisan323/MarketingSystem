package cn.artisan323.util;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回工具类
 * @author wannengqingnian
 */
public class ResponseUtil implements Serializable {
    /**
     * 成功失败标志
     */
    private boolean success = true;
    /**
     * 消息码
     */
    private String messageCode = "";
    /**
     * 消息描述
     */
    private String message = "";
    /**
     * 用于存放数据的MAP
     */
    private Map<Object, Object> data = new HashMap<>();

    /**
     * 私有的构造方法，防止new
     */
    private ResponseUtil() {
    }

    public static ResponseUtil createResponseUtil() {
        ResponseUtil responseUtil = new ResponseUtil();
        return responseUtil;
    }

    /**
     * 封装data
     *
     * @param key
     * @param value
     */
    public void putValueToData(Object key, Object value) {
        this.getData().put(key, value);
    }

    /**
     * 根据key获取data值
     *
     * @param key
     * @return
     */
    public Object getValueFormData(Object key) {
        return this.getData().get(key);
    }


    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseUtil{" +
                "success=" + success +
                ", messageCode='" + messageCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
