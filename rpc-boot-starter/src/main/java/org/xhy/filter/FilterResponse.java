package org.xhy.filter;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 13:03
 */
public class FilterResponse {

    private final Boolean result;

    private final Exception exception;

    public FilterResponse(Boolean result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public Boolean getResult() {
        return result;
    }
}
