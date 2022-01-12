package com.zhaoyd.lang;
/**
 * <p>
 *  迭代器模式
 *  迭代器设计模式的特点是实现Iterable接口
 *  通过nex的方式获取集合元素，同时具备对元素
 *  的删除。这种设计模式的优点是可以让我们以相同
 *  的方式，遍历不同的数据元素，这些元素包括：
 *  数组、链表、树等，而用户在使用遍历的时候并
 *  不需要关系每一种数据结构的遍历处理逻辑
 *
 *  @Description:
 *  @author: zhao_yd
 *  @Date: 2021/8/26 3:14 下午
 *
 */

public interface Iterator<E> {

    boolean hasNext();

    E next();
}
