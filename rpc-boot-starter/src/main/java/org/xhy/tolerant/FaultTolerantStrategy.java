package org.xhy.tolerant;

import org.xhy.common.URL;

import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 23:22
 */
public interface FaultTolerantStrategy {

    Object handler(FaultContext faultContext) throws Exception;
}
