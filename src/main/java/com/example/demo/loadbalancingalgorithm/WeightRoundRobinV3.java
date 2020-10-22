package com.example.demo.loadbalancingalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者 lqq
 * @ClassName 类名 WeightRoundRobinV3
 * @date 2020/10/22 23:28
 * @注释：
 */
public class WeightRoundRobinV3 {

    private static Map<String,Weight> weightMap = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 14 ; i++) {
            System.out.println(getServer());
        }
    }
    public static String getServer(){

        int size = ServerIP.SERVER_IP_MAP.values().stream().mapToInt(val -> val).sum();
        if (weightMap.isEmpty()){
            ServerIP.SERVER_IP_MAP.forEach((ip,weight) ->{
                weightMap.put(ip, new Weight(ip, weight, 0));
            });
        }
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }
        Weight currentMaxWeight = null;
        for (Weight weight : weightMap.values()) {
            if (currentMaxWeight == null || weight.getCurrentWeight() > currentMaxWeight.getCurrentWeight()){
                currentMaxWeight = weight;
            }
        }
        currentMaxWeight.setCurrentWeight(currentMaxWeight.getCurrentWeight()-size);
        return currentMaxWeight.getIp();
    }

}

class Weight{
    private String ip;

    private Integer weight;

    private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
