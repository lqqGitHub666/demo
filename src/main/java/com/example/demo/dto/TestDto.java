package com.example.demo.dto;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestDto
 * @date 2019/8/8 12:47
 * @注释：
 */
public class TestDto {

    private String testName;

    private String testWeight;

    private String testLength;

    private String testAge;

    public String getTestLength() {
        return testLength;
    }

    public void setTestLength(String testLength) {
        this.testLength = testLength;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestAge() {
        return testAge;
    }

    public void setTestAge(String testAge) {
        this.testAge = testAge;
    }

    public String getTestWeight() {
        return testWeight;
    }

    public void setTestWeight(String testWeight) {
        this.testWeight = testWeight;
    }
}
