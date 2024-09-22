package org.xhy.service;

import org.xhy.annotation.RpcService;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 17:14
 */

@RpcService
public class HelloService implements Comparable,IHelloService{

    @Override
    public Object hello(String text) {
        return "service1 result:"+text;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
