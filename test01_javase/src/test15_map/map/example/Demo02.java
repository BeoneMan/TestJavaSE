package test15_map.map.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * 具体规则：
 * 1. 组装54张扑克牌将
 * 2. 54张牌顺序打乱
 * 3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
 * 4. 查看三人各自手中的牌（按照牌的大小排序）、底牌
 * 规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
public class Demo02 {

    public static void main(String[] args) {

        //创建牌
        HashMap<Integer, String> pokerMap = new HashMap<>();
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();

        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        Collections.addAll(colors, "♠", "♥", "♣", "♦");

        int count = 0;
        pokerMap.put(count++, "大王");
        pokerMap.put(count++, "小王");


        for (String number : numbers) {
            for (String color : colors) {
                pokerMap.put(count++, color + number);
            }
        }
        System.out.println(pokerMap);
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = pokerMap.keySet();
        for (Integer i : set) {
            list.add(i);
        }
        System.out.println(list);
        //打乱牌
        Collections.shuffle(list);

        //发牌
        ArrayList<Integer> no1 = new ArrayList<>();
        ArrayList<Integer> no2 = new ArrayList<>();
        ArrayList<Integer> no3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        Integer noPoker = null;
        for (int i = 0; i < list.size(); i++) {
            noPoker = list.get(i);
            if (i >= 51) {
                diPai.add(noPoker);
            } else {
                if (i % 3 == 0) {
                    no1.add(noPoker);
                } else if (i % 3 == 1) {
                    no2.add(noPoker);
                } else if (i % 3 == 2) {
                    no3.add(noPoker);
                }
            }

        }
        //排序牌面
        Collections.sort(no1);
        Collections.sort(no2);
        Collections.sort(no3);
        Collections.sort(diPai);

        //转换牌面
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> dp = new ArrayList<>();

        for (Integer i : no1) {
            String pokerString = pokerMap.get(i);
            play1.add(pokerString);
        }
        for (Integer i : no2) {
            String pokerString = pokerMap.get(i);
            play2.add(pokerString);
        }
        for (Integer i : no3) {
            String pokerString = pokerMap.get(i);
            play3.add(pokerString);
        }
        for (Integer i : diPai) {
            String pokerString = pokerMap.get(i);
            dp.add(pokerString);
        }


        //显示牌面
        System.out.println(play1+"张数："+play1.size()+"牌索引："+no1);
        System.out.println(play2+"张数："+play2.size()+"牌索引："+no2);
        System.out.println(play3+"张数："+play3.size()+"牌索引："+no3);
        System.out.println(dp);

    }
}
