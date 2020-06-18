package com.example.demo.test.testSql;

import java.sql.*;

/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2020/6/16 13:42
 * @注释：
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.0.139:33066/lims_dev?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true","root","biosan17");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select sample_id as sampleId,sample_type,create_time from lab_sample where sample_id = '3fddd58a27ba4bc8aa098161767563fa'");
//        PreparedStatement preparedStatement = connection.prepareStatement("select sample_id as sampleId,sample_type,create_time from lab_sample where sample_id = ? and create_time = ?");
//        preparedStatement.setString(1,"3fddd58a27ba4bc8aa098161767563fa");
//        preparedStatement.setDate(2,new Date(new java.util.Date().getTime()));
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("sampleId"));
//            System.out.println(resultSet.getString("sample_type"));
//            System.out.println(resultSet.getDate("create_time"));
//
//        }

        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                if (j == 2){
                    System.out.println(j);
                    break;
                }
                j++;
            }
        }

    }
}
