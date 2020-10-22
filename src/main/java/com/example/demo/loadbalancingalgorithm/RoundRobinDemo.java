package com.example.demo.loadbalancingalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RoundRobinDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/22 10:47
 * @Version: 1.0
 */
public class RoundRobinDemo {

    private static int index = 0;

    private static List<String> serverIPs;

    private static int size = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getWeightRoundRobinServer1());
        }
    }

    //权重 + 轮询2
    public static String getWeightRoundRobinServer1(){
        if (size == 0){
            for (Integer value : ServerIP.SERVER_IP_MAP.values()) {
                size += value;
            }
        }
        if (index >= size){
            index = 0;
        }
        index ++;
        int indexNum = index;
        for (String key : ServerIP.SERVER_IP_MAP.keySet()) {
            int num = ServerIP.SERVER_IP_MAP.get(key);
            if (indexNum > num){
                indexNum = indexNum - num;
                continue;
            }
            return key;
        }
        return "";
    }

    //权重 + 轮询1
    public static String getWeightRoundRobinServer(){
        if (serverIPs == null){
            int size = 0;
            for (Integer value : ServerIP.SERVER_IP_MAP.values()) {
                size += value;
            }
            serverIPs = new ArrayList<>(size);
            for (String key : ServerIP.SERVER_IP_MAP.keySet()) {
                int num = ServerIP.SERVER_IP_MAP.get(key);
                for (int i = 0; i < num; i++) {
                    serverIPs.add(key);
                }
            }
        }

        if (index >= serverIPs.size()){
            index = 0;
        }
        String ip = serverIPs.get(index);
        index ++;
        return ip;
    }
    //简单轮询
    public static String getRoundRobinServer(){
        if (index >= ServerIP.SERVER_IP_LIST.size()){
            index = 0;
        }
        String ip = ServerIP.SERVER_IP_LIST.get(index);
        index ++;
        return ip;
    }

}
