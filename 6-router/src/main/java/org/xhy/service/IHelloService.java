package org.xhy.service;

import org.xhy.annotation.RpcReference;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 17:14
 */
@RpcReference
public interface IHelloService {

    Object hello(String text);
}
