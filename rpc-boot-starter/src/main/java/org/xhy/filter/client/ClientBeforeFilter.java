package org.xhy.filter.client;

import org.xhy.filter.Filter;
import org.xhy.filter.FilterData;
import org.xhy.socket.codec.RpcRequest;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 12:47
 */
public interface ClientBeforeFilter extends Filter<RpcRequest> {
}
