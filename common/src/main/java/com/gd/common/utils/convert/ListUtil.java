package com.gd.common.utils.convert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtil {

    public static <T> T matchObject(List<T> list,T value) {
        if(list == null || list.size() == 0 || value == null){
            return null;
        }
        for(T t : list) {
            if(value.equals(t)){
                return t;
            }
        }
        return null;
    }

    public static <T> T matchObject(List<T> list,Long id) {
        if(list == null || list.size() == 0 || id == null){
            return null;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("getId");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(T t : list) {
            try {
                if(id.equals(method.invoke(t))){
                    return t;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T,K> T matchObject(List<T> list,String fieldName,K id) {
        if(list == null || list.size() == 0 || id == null){
            return null;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(T t : list) {
            try {
                if(id.equals(method.invoke(t))){
                    return t;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T,K> List<T> matchBatchObject(List<T> list,String fieldName,List<K> ids) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || ids == null || ids.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" +  Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(K id :ids){
            for(T t : list) {
                try {
                    if(id.equals(method.invoke(t))){
                        result.add(t);
                        break;
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static <T> List<T> matchBatchObject(List<T> list,List<Long> ids) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || ids == null || ids.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("getId");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(Long id :ids){
            for(T t : list) {
                try {
                    if(id.equals(method.invoke(t))){
                        result.add(t);
                        break;
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static <T> List<T> matchList(List<T> list,Long id) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || id == null){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("getId");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for(T t : list) {
            try {
                if(id.equals(method.invoke(t))){
                    result.add(t);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static <T> List<T> matchList(List<T> list,List<Long> ids) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || ids == null || ids.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("getId");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for(Long id : ids){
            for(T t : list) {
                try {
                    if(id.equals(method.invoke(t))){
                        result.add(t);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static <T,K> List<T> matchList(List<T> list,String fieldName,K id) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || id == null){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" +  Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for(T t : list) {
            try {
                if(id.equals(method.invoke(t))){
                    result.add(t);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static <T,K> List<T> notMatchList(List<T> list,String fieldName,K id) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || id == null){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" +  Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for(T t : list) {
            try {
                if(!id.equals(method.invoke(t))){
                    result.add(t);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static <T,K> List<T> matchList(List<T> list,String fieldName,List<K> ids) {

        List<T> result = new ArrayList();
        if(list == null || list.size() == 0 || ids == null || ids.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" +  Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for(K id : ids){
            for(T t : list) {
                try {
                    if(id.equals(method.invoke(t))){
                        result.add(t);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static <T> List<Long> getKeyList(List<T> list) {

        List<Long> result = new ArrayList();
        if(list == null || list.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("getId");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Set<Long> set = new HashSet<>();
        for(T t : list) {
            try {
                Long id = (Long)method.invoke(t);
                if(id != null){
                    set.add(id);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        for(Long id : set){
            result.add(id);
        }
        return result;
    }


    public static <T,K> List<K> getKeyList(List<T> list,String fieldName) {

        List<K> result = new ArrayList();
        if(list == null || list.size() == 0){
            return result;
        }
        Class clazz = list.get(0).getClass();
        Method method = null;
        try {
            method = clazz.getMethod("get" +  Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Set<K> set = new HashSet<>();

        for(T t : list) {
            try {
                K k = (K)method.invoke(t);
                if(k != null){
                    set.add(k);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        for(K k : set){
            result.add(k);
        }
        return result;
    }
}
