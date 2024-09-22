package org.xhy.consumer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhy.annotation.RpcReference;
import org.xhy.common.constants.LoadBalance;
import org.xhy.service.HelloService;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 16:22
 */
@RestController
@RequestMapping
public class Web {

    @RpcReference
    HelloService helloService;

    @GetMapping
    public Object hello(String arg){
        return helloService.hello(arg);
    }
}
