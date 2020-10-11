package com.example.demo.test.testlamada;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName: PoolingExportDto
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/9/27 9:40
 * @Version: 1.0
 */
public class PoolingExportDto {

    private Integer orderNo;
    private String labNoNGBS;
    private String labNo;
    private String seq;
    private String batchNo;
    private String sampleRemark;
    private String familyNo;
    private String barcode;
    private String patientName;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date birthday;
    private String age;
    private Date collectDate;
    private String itemName;
    private String sampleType;
    private String departmentName;
    private String mobile;
    private String applyDocName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date receiveDate;
    private String clinicalDiagnosis;
    private String thirdNumber;

    public PoolingExportDto() {
    }

    public PoolingExportDto(Integer orderNo, String labNoNGBS, String labNo, String seq, String batchNo, String sampleRemark, String familyNo, String barcode, String patientName, String sex, Date birthday, String age, Date collectDate, String itemName, String sampleType, String departmentName, String mobile, String applyDocName, Date receiveDate, String clinicalDiagnosis, String thirdNumber) {
        this.orderNo = orderNo;
        this.labNoNGBS = labNoNGBS;
        this.labNo = labNo;
        this.seq = seq;
        this.batchNo = batchNo;
        this.sampleRemark = sampleRemark;
        this.familyNo = familyNo;
        this.barcode = barcode;
        this.patientName = patientName;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.collectDate = collectDate;
        this.itemName = itemName;
        this.sampleType = sampleType;
        this.departmentName = departmentName;
        this.mobile = mobile;
        this.applyDocName = applyDocName;
        this.receiveDate = receiveDate;
        this.clinicalDiagnosis = clinicalDiagnosis;
        this.thirdNumber = thirdNumber;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public String getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(String thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getLabNoNGBS() {
        return labNoNGBS;
    }

    public void setLabNoNGBS(String labNoNGBS) {
        this.labNoNGBS = labNoNGBS;
    }

    public String getLabNo() {
        return labNo;
    }

    public void setLabNo(String labNo) {
        this.labNo = labNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSampleRemark() {
        return sampleRemark;
    }

    public void setSampleRemark(String sampleRemark) {
        this.sampleRemark = sampleRemark;
    }

    public String getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(String familyNo) {
        this.familyNo = familyNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getApplyDocName() {
        return applyDocName;
    }

    public void setApplyDocName(String applyDocName) {
        this.applyDocName = applyDocName;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
}
