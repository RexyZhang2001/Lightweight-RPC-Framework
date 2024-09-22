package org.xhy.common.constants;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-08 11:59
 */
public enum RpcSerialization {
    JSON("json"),
    JDK("jdk"),

    HESSIAN("hessian"),

    KRYO("kryo");

    public String name;
    RpcSerialization(String type){
        this.name = type;
    }

    public static RpcSerialization get(String type){
        for (RpcSerialization value : values()) {
            if (value.name.equals(type)) {
                return value;
            }
        }
        return null;
    }
}
