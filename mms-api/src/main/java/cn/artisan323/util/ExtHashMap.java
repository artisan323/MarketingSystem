package cn.artisan323.util;

import java.util.HashMap;

/**
 * @Description: 用于查询结果列名的转换
 * @author: Dongjiawei
 * @date: 2018/4/8 10:59
 * @system name:新一代消费金融系统
 * @copyright:长安新生（深圳）金融投资有限公司
 */

@SuppressWarnings("serial")
public final class ExtHashMap<K, V> extends HashMap<K, V> {
    private static String KEY = "192006250b4c09247ec02edce69f6a2d";


    public ExtHashMap() {
        super();
    }

    public ExtHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ExtHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        if (key instanceof String) {
            String param = (String) key;
            if (param.indexOf("_") > 0) {
                StringBuilder sb = new StringBuilder();
                String lowKey = param.toLowerCase();
                String[] lowKeys = lowKey.split("_");
                sb.append(lowKeys[0]);
                for (int i = 1; i < lowKeys.length; i++) {
                    sb.append(lowKeys[i].substring(0, 1).toUpperCase().concat(lowKeys[i].substring(1).toLowerCase()));
                }
                String result = sb.toString();
                switch (result)
                {
                    case "naMe":
                        value = (V) AesEncryptUtil.decrypt((String)value, "192006250b4c0924");
                        break;
                    default:
                        break;
                }
                return super.put((K) result, value);
            } else {
                if (ExtHashMap.isUppercase(param)) {
                    String lowKey = param.toLowerCase();
                    return super.put((K) lowKey, value);
                } else {
                    return super.put(key, value);
                }
            }
        }
        return super.put(key, value);
    }

    /**
     * @Description:判断第一个字符是否为大写
     * @author: Dongjiawei
     * @date:2018-4-17 18:26:54
     */
    private static boolean isUppercase(String str) {
        char c = str.charAt(0);
        return Character.isUpperCase(c);
    }
}
