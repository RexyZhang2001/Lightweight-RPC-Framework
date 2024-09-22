package org.xhy.provider.filter;

import org.xhy.filter.FilterData;
import org.xhy.filter.FilterResponse;
import org.xhy.filter.client.ClientBeforeFilter;
import org.xhy.filter.server.ServerBeforeFilter;
import org.xhy.socket.codec.RpcRequest;

import java.nio.file.AccessDeniedException;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 17:23
 */
public class TokenFilter implements ServerBeforeFilter {

    @Override
    public FilterResponse doFilter(FilterData<RpcRequest> filterData) {
        final RpcRequest rpcRequest = filterData.getObject();
        Object token = rpcRequest.getClientAttachments().get("token");
        if (!token.equals("xhy")){
            return new FilterResponse(false,new Exception("token不正确"));
        }
        return new FilterResponse(true,null);
    }
}
