package org.xhy.common;

import java.util.Objects;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-15 11:11
 */
public class Host {

    private final String ip;

    private final Integer port;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Host ip = (Host) object;
        return Objects.equals(this.ip, ip.ip) && Objects.equals(port, ip.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    public Host(String host, Integer port) {
        this.ip = host;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Host{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
