package com.spring.core.lesson16.dao;

import java.util.List;

public interface StudentDao<T>{

        void create(T t);

        T read(long id) throws Exception;

        List<T> readAll();

        void update(int id, String property, String newValue) throws Exception;

        void delete(int id) throws Exception;
}
