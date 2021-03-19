package com.example.demo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: MsgClient
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/2/4 10:51
 * @Version: 1.0
 */
@ExcelTarget("msgClient")
public class MsgClient implements Serializable {
    @Excel(name = "姓名")
    private String clientName;
    @Excel(name = "生日")
    private Date birthday;
    @Excel(name = "clientPhone")
    private String clientPhone;
    @Excel(name = "createBy")
    private String createBy;
    @Excel(name = "id")
    private String id;
    @Excel(name = "remark")
    private String remark;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
}
