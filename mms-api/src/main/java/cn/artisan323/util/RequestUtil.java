package cn.artisan323.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 请求工具类
 * @author wannengqingnian
 */
public class RequestUtil implements Serializable {

    /**
     * 用于存放数据的MAP
     */
    private Map<String, Object> data = new HashMap<>();

    private RequestUtil() {
    }
    private static RequestUtil staticRequestUtil;

    public static RequestUtil getRequestUtil() {
        return staticRequestUtil = new RequestUtil();
    }

    /**
     * 封装data
     *
     * @param key
     * @param value
     */
    public void putValueToData(String key, Object value) {
        this.getData().put(key, value);
    }

    /**
     * 根据key获取data的值
     *
     * @param key
     * @return
     */
    public Object getValueFormData(String key) {
        return this.getData().get(key);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
