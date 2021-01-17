package com.ymj.array;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.array
 * @date 2020/8/24 16:31
 * @description
 */
public class ArrayTest {

    public static void main(String[] args) throws Exception {
        MyList myList = new MyList();
        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");
        myList.add("ddd");
        print(myList);

        System.out.println("------增-------");
        myList.add("yuio");
        print(myList);
        System.out.println("------删-------");
        myList.remove(2);
        print(myList);
        System.out.println("------改-------");
        myList.update(1, "pppp");
        print(myList);
        System.out.println("------查-------");
        System.out.println(myList.get(3));
    }

    private static void print(MyList myList) {
        for(int i = 0; i < myList.size; i++) {
            System.out.print(myList.get(i) + ", ");
        }
        System.out.println();
    }

}