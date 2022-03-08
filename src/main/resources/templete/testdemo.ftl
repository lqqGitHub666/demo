{
  "resultQuantityList": [

    <#list (data.BSXml.MsgBody.Data.ResultQuantityList.ResultQuantity) as resultQuantity>
    {
      "deptInformation": "<#if resultQuantity.DeptInformation??>${resultQuantity.DeptInformation}<#else>1234</#if>",
      "parentDept": "${resultQuantity.ParentDept}",
      "parentDeptName": "${resultQuantity.ParentDeptName}",
      "visitOrganization": "${resultQuantity.VisitOrganization}",
      "visitOrganizationName": "${resultQuantity.VisitOrganizationName}",
      "deptList": [
        <#list (resultQuantity.DeptList.Dept) as dept>
        {
          "admitAddress": "<#if dept.AdmitAddress??>${dept.AdmitAddress}<#else>无</#if>",
          "contactTelephone": "<#if dept.ContactTelephone??>${dept.ContactTelephone}<#else>无</#if>",
          "deptCode": "${dept.DeptCode}",
          "deptName": "${dept.DeptName}"
        }
        </#list>
      ]
    }
    </#list>
  ]
}