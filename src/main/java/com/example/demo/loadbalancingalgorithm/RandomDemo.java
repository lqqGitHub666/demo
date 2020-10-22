package com.example.demo.loadbalancingalgorithm;

import com.example.demo.loadbalancingalgorithm.ServerIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: RandomDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/22 9:58
 * @Version: 1.0
 */
public class RandomDemo {

    public static void main(String[] args) {
        System.out.println(getWeightRandomServer());

        for (int i = 0; i < 10; i++) {
            System.out.println(getWeightRandomServer1());
        }
    }

    //随机 + 权重负载均衡算法2
    public static String getWeightRandomServer1(){
        int size = 0;
        for (Integer value : ServerIP.SERVER_IP_MAP.values()) {
            size += value;
        }
        Random random = new Random();
        int index = random.nextInt(size);
        for (String key : ServerIP.SERVER_IP_MAP.keySet()) {
            int num = ServerIP.SERVER_IP_MAP.get(key);
            if (index > num){
                index = index - num;
                continue;
            }
            return key;
        }
        return "";
    }

    //随机 + 权重负载均衡算法1
    public static String getWeightRandomServer(){
        int size = 0;
        for (Integer value : ServerIP.SERVER_IP_MAP.values()) {
            size += value;
        }
        List<String> serverIPs = new ArrayList<>(size);
        for (String key : ServerIP.SERVER_IP_MAP.keySet()) {
            int num = ServerIP.SERVER_IP_MAP.get(key);
            for (int i = 0; i < num; i++) {
                serverIPs.add(key);
            }
        }
        Random random = new Random();
        int index = random.nextInt(size);
        return serverIPs.get(index);
    }

    //随机负载均衡
    public static String getRandomServer(){
        int size = ServerIP.SERVER_IP_LIST.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return ServerIP.SERVER_IP_LIST.get(index);
    }
}
