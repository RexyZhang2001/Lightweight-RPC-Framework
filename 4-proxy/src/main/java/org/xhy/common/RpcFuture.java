package org.xhy.common;

import io.netty.util.concurrent.Promise;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 18:56
 */
public class RpcFuture <T> {

    private Promise<T> promise;
    private long timeout;

    public Promise<T> getPromise() {
        return promise;
    }

    public void setPromise(Promise<T> promise) {
        this.promise = promise;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public RpcFuture() {
    }

    public RpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
