package org.xhy.event;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-14 23:42
 */
public interface IRpcLister<T> {

    void exec(T t);
}
