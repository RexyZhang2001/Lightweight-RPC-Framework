package org.xhy.filter;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 01:04
 */
public interface Filter<T> {

    FilterResponse doFilter(FilterData<T> filterData);

}
