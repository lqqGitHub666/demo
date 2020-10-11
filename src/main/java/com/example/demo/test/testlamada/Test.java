package com.example.demo.test.testlamada;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/9/27 17:40
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<PoolingExportDto> list = new LinkedList<>();
        PoolingExportDto poolingExportDto = new PoolingExportDto(1,"labNo1-ngbs","labNo1","seq1","batch1","sampleremark1","familyNo1","barcode1",
                "patient1","sex1",new Date(),"age1",new Date(),"itemName1","sampleType1",
                "departmentName1","mobile1","doc1",new Date(),"1111","112");
        list.add(poolingExportDto);
        List<PoolingExportDto> list1 = new LinkedList<>();
        PoolingExportDto poolingExportDto1 = new PoolingExportDto(1,"labNo1-ngbs","labNo1","seq1","batch1","sampleremark1","familyNo1","barcode1",
                "patient1","sex1",new Date(),"age1",new Date(),"itemName1","sampleType1",
                "departmentName1","mobile1","doc1",new Date(),"1111","112");
        PoolingExportDto poolingExportDto3 = new PoolingExportDto(3,"labNo1-ngbs","labNo1","seq1","batch1","sampleremark1","familyNo1","barcode1",
                "patient1","sex1",new Date(),"age3",new Date(),"itemName1","sampleType1",
                "departmentName1","mobile1","doc1",new Date(),"1111","112");
        list1.add(poolingExportDto1);
        list1.add(poolingExportDto3);
        List<PoolingExportDto> list2 = new LinkedList<>();
        list.parallelStream().forEach(s -> list1.stream().filter(ss -> s.getAge().equals(ss.getAge())).forEach(poolingExportDto2 -> {
            poolingExportDto2.setSex("22222");
            list2.add(poolingExportDto2);
        }));

        Map<Integer,PoolingExportDto> map = list.stream().collect(Collectors.toMap(p -> p.getOrderNo(), p -> p));
        List<PoolingExportDto> collect = list1.stream().filter(p1 -> map.get(p1.getOrderNo()) != null).collect(Collectors.toList());


//        list.stream().forEach(s -> list2.addAll(list.stream().filter(ss -> ss.getAge().equals(s.getAge())).collect(Collectors.toList())));
        System.out.println();
        list2.forEach(poolingExportDto2 -> System.out.println(poolingExportDto2.getSex()));
    }
}
