package org.xhy.common;

import java.util.Objects;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:35
 */
public class URL {

    private String ip;

    private Integer port;

    public URL(String host, Integer port) {
        this.ip = host;
        this.port = port;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        URL url = (URL) object;
        return Objects.equals(ip, url.ip) && Objects.equals(port, url.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

}
