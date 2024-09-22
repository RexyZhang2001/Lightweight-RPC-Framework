package org.xhy.router;

import org.xhy.common.URL;

import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 00:16
 */
public interface LoadBalancer {

    URL select(List<URL> urls);

}
