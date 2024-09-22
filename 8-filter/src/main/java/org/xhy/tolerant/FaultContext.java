package org.xhy.tolerant;

import org.xhy.common.URL;
import org.xhy.socket.codec.RpcProtocol;

import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 23:30
 */
public class FaultContext {

    private URL currentURL;

    private List<URL> urls;

    private RpcProtocol rpcProtocol;

    private Long requestId;

    private Exception exception;



    public FaultContext() {
    }

    public FaultContext(URL currentURL, List<URL> urls, RpcProtocol rpcProtocol, Long requestId, Exception e) {
        this.currentURL = currentURL;
        this.urls = urls;
        this.rpcProtocol = rpcProtocol;
        this.requestId = requestId;
        this.exception = e;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public URL getCurrentURL() {
        return currentURL;
    }

    public void setCurrentURL(URL currentURL) {
        this.currentURL = currentURL;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public RpcProtocol getRpcProtocol() {
        return rpcProtocol;
    }

    public void setRpcProtocol(RpcProtocol rpcProtocol) {
        this.rpcProtocol = rpcProtocol;
    }
}
