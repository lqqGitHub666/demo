package com.example.demo.freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import freemarker.ext.dom.NodeModel;
import org.dom4j.DocumentException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.freemarker
 * @ClassName: TestDemo
 * @Author: liuqingqing
 * @Description:
 * @Date: 2022/3/8 9:31
 */
public class TestDemo {


    public static void main(String[] args) throws DocumentException, IOException, ParserConfigurationException, SAXException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<BSXml>\n" +
                "    <MsgHeader>\n" +
                "        <CreationTime>2022-03-07T04:01:06.469+08:00</CreationTime>\n" +
                "        <TargetMessageId></TargetMessageId>\n" +
                "        <Sender>GOL</Sender>\n" +
                "        <MsgType>ODS_02040005</MsgType>\n" +
                "        <MsgVersion>3.3</MsgVersion>\n" +
                "    </MsgHeader>\n" +
                "    <MsgBody>\n" +
                "        <Status>true</Status>\n" +
                "        <Code>200</Code>\n" +
                "        <Detail>调用成功!</Detail>\n" +
                "        <Data>\n" +
                "            <ResultQuantityList>\n" +
                "                <ResultQuantity>\n" +
                "                    <VisitOrganization>330108001</VisitOrganization>\n" +
                "                    <VisitOrganizationName>浦沿街道社区卫生服务中心</VisitOrganizationName>\n" +
                "                    <ParentDept>330108001_HZxx12</ParentDept>\n" +
                "                    <ParentDeptName>中医科</ParentDeptName>\n" +
                "                    <DeptInformation></DeptInformation>\n" +
                "                    <DeptList>\n" +
                "                        <Dept>\n" +
                "                            <DeptCode>2446</DeptCode>\n" +
                "                            <DeptName>中医科2</DeptName>\n" +
                "                            <AdmitAddress></AdmitAddress>\n" +
                "                            <ContactTelephone></ContactTelephone>\n" +
                "                        </Dept>\n" +
                "                    </DeptList>\n" +
                "                </ResultQuantity>\n" +
                "                <ResultQuantity>\n" +
                "                    <VisitOrganization>330108001</VisitOrganization>\n" +
                "                    <VisitOrganizationName>萧山区卫生服务中心</VisitOrganizationName>\n" +
                "                    <ParentDept>330108001_Hzxx24</ParentDept>\n" +
                "                    <ParentDeptName>全科</ParentDeptName>\n" +
                "                    <DeptInformation></DeptInformation>\n" +
                "                    <DeptList>\n" +
                "                        <Dept>\n" +
                "                            <DeptCode>1564</DeptCode>\n" +
                "                            <DeptName>全科医疗科</DeptName>\n" +
                "                            <AdmitAddress></AdmitAddress>\n" +
                "                            <ContactTelephone></ContactTelephone>\n" +
                "                        </Dept>\n" +
                "                        <Dept>\n" +
                "                            <DeptCode>1564</DeptCode>\n" +
                "                            <DeptName>全科医疗科</DeptName>\n" +
                "                            <AdmitAddress></AdmitAddress>\n" +
                "                            <ContactTelephone></ContactTelephone>\n" +
                "                        </Dept>\n" +
                "                    </DeptList>\n" +
                "                </ResultQuantity>\n" +
                "                <ResultQuantity>\n" +
                "                    <VisitOrganization>330108001</VisitOrganization>\n" +
                "                    <VisitOrganizationName>萧山区卫生服务中心</VisitOrganizationName>\n" +
                "                    <ParentDept>002</ParentDept>\n" +
                "                    <ParentDeptName>妇产科1</ParentDeptName>\n" +
                "                    <DeptInformation></DeptInformation>\n" +
                "                    <DeptList>\n" +
                "                        <Dept>\n" +
                "                            <DeptCode>1567</DeptCode>\n" +
                "                            <DeptName>妇产科科室</DeptName>\n" +
                "                            <AdmitAddress></AdmitAddress>\n" +
                "                            <ContactTelephone></ContactTelephone>\n" +
                "                        </Dept>\n" +
                "                        <Dept>\n" +
                "                            <DeptCode>1567</DeptCode>\n" +
                "                            <DeptName>妇产科科室</DeptName>\n" +
                "                            <AdmitAddress></AdmitAddress>\n" +
                "                            <ContactTelephone></ContactTelephone>\n" +
                "                        </Dept>\n" +
                "                    </DeptList>\n" +
                "                </ResultQuantity>\n" +
                "            </ResultQuantityList>\n" +
                "        </Data>\n" +
                "    </MsgBody>\n" +
                "</BSXml>";
        JSONObject jsonObject = XmlToJson.xml2Json(str);
        System.out.println(JSON.toJSONString(jsonObject));
        InputStream in = new ByteArrayInputStream(str.getBytes("UTF-8"));
        InputSource ins = new org.xml.sax.InputSource(in);
        NodeModel parse = NodeModel.parse(ins);
        String resp = null;
        Map map=new HashMap();
        map.put("data", parse);
        try {
            resp = XMLTest.process("testdemo.ftl", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resp);
    }
}
