package com.example.demo.freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.freemarker
 * @ClassName: XmlToJso
 * @Author: liuqingqing
 * @Description:
 * @Date: 2022/3/8 9:22
 */
public class XmlToJson {


    public static void main(String[] args) throws DocumentException {
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
                "                    </DeptList>\n" +
                "                </ResultQuantity>\n" +
                "            </ResultQuantityList>\n" +
                "        </Data>\n" +
                "    </MsgBody>\n" +
                "</BSXml>";
        JSONObject jsonObject = xml2Json(str);
        System.out.println(JSON.toJSONString(jsonObject));
    }

    /**
     * xml转json
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public static JSONObject xml2Json(String xmlStr) throws DocumentException{
        Document doc= DocumentHelper.parseText(xmlStr);
        JSONObject json=new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }

    /**
     * xml转json
     * @param element
     * @param json
     */
    public static void dom4j2Json(Element element,JSONObject json){
        //如果是属性
        for(Object o:element.attributes()){
            Attribute attr=(Attribute)o;
            if(!isEmpty(attr.getValue())){
                json.put("@"+attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl=element.elements();
        if(chdEl.isEmpty()&&!isEmpty(element.getText())){//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }

        for(Element e:chdEl){//有子元素
            if(!e.elements().isEmpty()){//子元素也有子元素
                JSONObject chdjson=new JSONObject();
                dom4j2Json(e,chdjson);
                Object o=json.get(e.getName());
                if(o!=null){
                    JSONArray jsona=null;
                    if(o instanceof JSONObject){//如果此元素已存在,则转为jsonArray
                        JSONObject jsono=(JSONObject)o;
                        json.remove(e.getName());
                        jsona=new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if(o instanceof JSONArray){
                        jsona=(JSONArray)o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                }else{
                    if(!chdjson.isEmpty()){
                        json.put(e.getName(), chdjson);
                    }
                }


            }else{//子元素没有子元素
                for(Object o:element.attributes()){
                    Attribute attr=(Attribute)o;
                    if(!isEmpty(attr.getValue())){
                        json.put("@"+attr.getName(), attr.getValue());
                    }
                }
                if(!e.getText().isEmpty()){
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    public static boolean isEmpty(String str) {

        if (str == null || str.trim().isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }
}
