package org.xhy.proxy;

import org.xhy.annotation.RpcReference;
import org.xhy.common.constants.FaultTolerant;
import org.xhy.common.constants.LoadBalance;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:20
 */
public interface IProxy {

    <T> T getProxy(Class claz, RpcReference rpcReference);
}
