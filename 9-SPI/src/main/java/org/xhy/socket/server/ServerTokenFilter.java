package org.xhy.socket.server;

import org.xhy.filter.FilterData;
import org.xhy.filter.FilterResponse;
import org.xhy.filter.server.ServerBeforeFilter;
import org.xhy.socket.codec.RpcRequest;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 14:14
 */
public class ServerTokenFilter implements ServerBeforeFilter {
    @Override
    public FilterResponse doFilter(FilterData<RpcRequest> filterData) {
        final RpcRequest rpcRequest = filterData.getObject();
        Object value = rpcRequest.getClientAttachments().get("token");
        if (!value.equals("xhy")){
            return new FilterResponse(false,new Exception("token 不正确,当前token为:" + value));
        }
        return new FilterResponse(true,null);
    }
}
