package com.example.demo.test.testabstract;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestAbstract
 * @date 2019/8/28 10:16
 * @注释：
 */
public abstract class TestAbstract {

    private String content;

    public TestAbstract(String content) {
        this.content = content;
    }

    public abstract void test(String content);

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
