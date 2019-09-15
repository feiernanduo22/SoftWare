package com.software.dongtaiguihua;

/**
 * @auther Yvqanlee
 * @data 2019/5/27 21:43
 */
public class BuyChicken {


    /*算法应用之百钱买白鸡
    案列说明：主要内容是：公鸡5元一只，母鸡3元一只，小鸡1元三只，问100元怎样可以买100鸡？
    思想：想要实现此算法，只要明白各种条件的关系即可，而且知道公鸡最多买20只，母鸡最多买33只，小鸡最多买100只，这样买各种鸡的钱总为100,元，鸡的只数也是100；
    */


    public static void main(String[] args) {
        final Integer MAXCOCKCOUNT = 20;//公鸡最大数量
        final Integer MAXHENCOUNT = 33;//母鸡最大数量
        int cock, hen, chicken = 0;
        for (cock=0;cock<MAXCOCKCOUNT;cock++){
            for (hen=0;hen<=MAXHENCOUNT;hen++){
                chicken = 100 - cock - hen;
                if ((cock * 5 + hen * 3 + chicken / 3 == 100) && (chicken % 3 == 0)){
                    System.out.println("公鸡有：" + cock);
                    System.out.println("母鸡有：" + hen);
                    System.out.println("小鸡有：" + chicken);
                    System.out.println("\n");
                }
            }
        }
    }
}

