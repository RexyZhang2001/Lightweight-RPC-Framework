package org.xhy.provider.service;

import org.springframework.stereotype.Component;
import org.xhy.annotation.RpcService;
import org.xhy.service.HelloService;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 16:32
 */
@Component
@RpcService
public class TestService implements HelloService{
    @Override
    public Object hello(String arg) {
        return arg + "provider1";
    }
}
