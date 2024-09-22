package org.xhy.service;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 17:14
 */
public class HelloService implements IHelloService{

    @Override
    public Object hello(String text) {
        return "result:"+text;
    }
}
