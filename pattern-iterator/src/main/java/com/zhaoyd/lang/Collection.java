package com.zhaoyd.lang;

public interface Collection<E,L> extends Iterator<E> {

    boolean add (E e);

    boolean remove(E e);

    boolean addLink(String key,L l);

    boolean removeLin(String key);

    Iterator<E> iterator();
}
