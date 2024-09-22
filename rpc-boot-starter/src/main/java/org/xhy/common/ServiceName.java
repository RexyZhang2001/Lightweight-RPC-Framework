package org.xhy.common;

import io.netty.util.concurrent.CompleteFuture;

import java.util.Objects;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 19:50
 */
public class ServiceName {

    private final String name;

    private final String version;

    public ServiceName(String name, String version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "ServiceName{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ServiceName that = (ServiceName) object;
        return Objects.equals(name, that.name) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version);
    }
}
