package cn.artisan323.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AesEncryptHandler extends BaseTypeHandler {
    /**
     * API 密钥：
     */
    private static String Key = "192006250b4c0924";

    /**
     * 设置非空参数
     * @param preparedStatement
     * @param i
     * @param o
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        if (o == null){
            preparedStatement.setString(i, null);
        }else if ("".equals(o)){
            preparedStatement.setString(i, "");
        }else {
            preparedStatement.setString(i, AesEncryptUtil.encrypt((String) o, Key));
        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String columnValue = resultSet.getString(columnName);
        return AesEncryptUtil.decrypt(columnValue,Key);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String columnValue = resultSet.getString(columnIndex);
        return AesEncryptUtil.decrypt(columnValue,Key);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String columnValue = callableStatement.getString(columnIndex);
        return AesEncryptUtil.decrypt(columnValue,Key);
    }
}
