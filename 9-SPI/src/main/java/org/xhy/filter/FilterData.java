package org.xhy.filter;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 12:48
 */
public class FilterData<T> {

    private T object;

    public FilterData(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
