package org.xhy.socket.codec;

import java.io.Serializable;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 16:47
 */
public class RpcResponse implements Serializable {
    private Object data;
    private Exception exception;

    public Exception getException() {
        return exception;
    }

    public Object getData() {
        return data;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
