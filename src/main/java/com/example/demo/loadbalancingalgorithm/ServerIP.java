package com.example.demo.loadbalancingalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ServerIP
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/22 9:58
 * @Version: 1.0
 */
public class ServerIP {

    public static List<String> SERVER_IP_LIST;

    public static Map<String,Integer> SERVER_IP_MAP;

    static {
        SERVER_IP_LIST = new ArrayList<>(8);
        SERVER_IP_LIST.add("A");
        SERVER_IP_LIST.add("B");
        SERVER_IP_LIST.add("C");
        SERVER_IP_MAP = new HashMap<>(8);
        SERVER_IP_MAP.put("A",5);
        SERVER_IP_MAP.put("B",1);
        SERVER_IP_MAP.put("C",1);
    }
}
