package com.ymj.array;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.array
 * @date 2020/8/24 16:34
 * @description
 */
public class MyList {

    public int size = 0;

    private int capacity = 12;

    private Object[] obj = new Object[capacity];

    //增
    public void add(Object object) {
        obj[size] = object;
        size++;
    }

    //删
    public void remove(int index) throws Exception {
        if (index > size) {
            throw new Exception("索引越界");
        }
        if (size - index >= 0) {
            System.arraycopy(obj, index + 1, obj, index, size - index);
        }
        size--;
    }

    //改
    public void update(int index, Object o) {
        obj[index] = o;
    }

    //查
    public Object get(int index) {
        return obj[index];
    }
}