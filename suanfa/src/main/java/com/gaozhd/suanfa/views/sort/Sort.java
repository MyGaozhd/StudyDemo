package com.gaozhd.suanfa.views.sort;


import com.gaozhd.gkit.common.util.LogUtil;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Sort
 * @Description: ${todo}
 * @Date: 2017/7/17 0017 19:03
 */
public class Sort {

    //降序排序
    public int[] data = new int[]{1, 4, 2, 3, 0, 7, 6, 5, 8, 9};

    //冒泡排序
    public void mapPao() {
        int tem;

        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] > data[j - 1]) {
                    tem = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tem;
                }
            }
            log();
        }
    }

    //快速排序
    public void kuaisu(int[] numbers, int low, int high) {
        log();
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            kuaisu(numbers, low, middle - 1);   //对低字段表进行递归排序
            kuaisu(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    //快速排序
    public int getMiddle(int[] data, int low, int high) {

        int temp = data[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && data[high] > temp) {
                high--;
            }
            data[low] = data[high];//比中轴小的记录移到低端

            while (low < high && data[low] < temp) {
                low++;
            }
            data[high] = data[low]; //比中轴大的记录移到高端
        }
        data[low] = temp; //中轴记录到尾
        return low;
    }

    //
    //打印日志
    private void log() {
        StringBuffer log = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            log.append(data[i] + " ");
        }
        LogUtil.log(log.toString());
    }
}
