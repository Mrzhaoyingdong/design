package com.zhaoyd.group;

import com.zhaoyd.lang.Collection;
import com.zhaoyd.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 *  @Description: 迭代器模式开发
 *  @author: zhao_yd
 *  @Date: 2021/8/13 2:11 下午
 *
 */


public class GroupStructure implements Collection<Employee,Link> {

    private String groupId;                                                    //组织ID,也是一个组织链的头部ID
    private String groupName;                                                 //组织名称
    private Map<String ,Employee> employeeMap = new ConcurrentHashMap<>();   //员工列表
    private Map<String , List<Link>> linkMap = new ConcurrentHashMap<>();   //组织架构关系  id-list
    private Map<String,String> invertedMap = new ConcurrentHashMap<>();    //反向关系链


    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }


    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(),employee);
    }


    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }


    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(),link.getFromId());
        if(linkMap.containsKey(key)){
            return linkMap.get(key).add(link);
        }else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key,links);
            return true;
        }
    }


    public boolean removeLin(String key) {
        return null != linkMap.remove(key);
    }


    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            HashMap<String,Integer> keyMap = new HashMap<>();

            int totalIdx = 0;
            private String fromId = groupId;    //员工ID,from
            private String toId = groupId;      //员工ID ,To


            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {

                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                //同级节点扫描
                if(null == links){
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                //上级节点扫描
                while(cursorIdx > links.size() -1){
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                //获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                //返回结果
                return employeeMap.get(link.getToId());
            }


            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }


    public boolean hasNext() {
        return false;
    }


    public Employee next() {
        return null;
    }
}
