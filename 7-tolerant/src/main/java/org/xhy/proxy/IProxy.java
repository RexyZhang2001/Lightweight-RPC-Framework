package org.xhy.proxy;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:20
 */
public interface IProxy {

    <T> T getProxy(Class<T> claz) throws InstantiationException, IllegalAccessException;
}
