package com.zhaoyd.mediator;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 *  @Description: SqlSession 默认实现类
 *  @author: zhao_yd
 *  @Date: 2021/8/19 5:41 下午
 *
 */


public class DefaultSqlSession implements SqlSession {

    private Connection connection;
    private Map<String,XNode> mapperElement;

    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objects = resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
            return objects.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement,parameter,parameterMap);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objects = resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
            return objects.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public <T> List<T> selectList(String statement) {
        XNode xNode = mapperElement.get(statement);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet2Obj(resultSet,Class.forName(xNode.getParameterType()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement,parameter,parameterMap);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet2Obj(resultSet,Class.forName(xNode.getParameterType()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {
        if(null ==connection){
            return;
        }
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private <T> List<T> resultSet2Obj(ResultSet resultSet,Class<?> clazz){
        List<T> list = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //每次遍历行值
            T obj = (T) clazz.newInstance();

            if(columnCount > 0){
                for(int i = 1; i<= columnCount;i++){
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    String setMethod = "set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if(value instanceof Timestamp){
                        method = clazz.getMethod(setMethod, Date.class);
                    }else {
                        method = clazz.getMethod(setMethod,value.getClass());
                    }
                    method.invoke(obj,value);
                }
            }
            list.add(obj);

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    private void buildParameter(PreparedStatement preparedStatement,Object parameter,Map<Integer,String> parameterMap) throws SQLException, IllegalAccessException {

        int size = parameterMap.size();

        if(parameter instanceof Long){
            for(int i = 1; i<=size; i++){
                preparedStatement.setLong(i,Long.parseLong(parameter.toString()));
            }
            return;
        }

        if(parameter instanceof Integer){
            for(int i = 1; i<= size; i++){
                preparedStatement.setInt(i,Integer.parseInt(parameter.toString()));
            }
            return;
        }

        if(parameter instanceof  String){
            for(int i = 1;i<=size; i++){
                preparedStatement.setString(i,parameter.toString());
            }
            return;
        }

        Map<String,Object> fieldMap = new HashMap<>();
        //对象参数
        Field[] declaredFields = parameter.getClass().getDeclaredFields();
        for(Field field : declaredFields){
            String name = field.getName();
            field.setAccessible(true);
            Object o = field.get(parameter);
            field.setAccessible(false);
            fieldMap.put(name,o);
        }

        for(int i= 1;i<= size;i++){
            String parameterDefine = parameterMap.get(i);
            Object obj = fieldMap.get(parameterDefine);

            if(obj instanceof Short){
                preparedStatement.setShort(i,Short.valueOf(obj.toString()));
                continue;
            }

            if(obj instanceof Integer){
                preparedStatement.setInt(i,Integer.valueOf(obj.toString()));
                continue;
            }

            if(obj instanceof  Long){
                preparedStatement.setLong(i,Long.valueOf(obj.toString()));
                continue;
            }

            if(obj instanceof String){
                preparedStatement.setString(i,obj.toString());
                continue;
            }

            if(obj instanceof Date){
                preparedStatement.setDate(i, (java.sql.Date) obj);
            }
        }

    }

}
