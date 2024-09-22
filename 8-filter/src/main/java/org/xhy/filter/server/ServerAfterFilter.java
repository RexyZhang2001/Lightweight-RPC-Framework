package org.xhy.filter.server;

import org.xhy.filter.Filter;
import org.xhy.socket.codec.RpcResponse;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 12:47
 */
public interface ServerAfterFilter extends Filter<RpcResponse> {
}
