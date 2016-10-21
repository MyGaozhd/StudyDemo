package com.gaozhd.studydemo.javabase.t;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TUtil
 * @Description: ${todo}
 * @date 2016/10/16 12:06
 */
public class TUtil {

    public static void main(String[] args) {

        Box<String> box = new Box<>("gaozhd");
//        System.out.println("name:" + box.getData())

        //使用类型通配符
        print(box);
    }

    /**
     * @Title:
     * @Description: ${todo}
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/16 12:26
     */
    public static void print(Box<?> box) {
        System.out.println("name:" + box.getData());
    }

    public <T> void prints(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
}
