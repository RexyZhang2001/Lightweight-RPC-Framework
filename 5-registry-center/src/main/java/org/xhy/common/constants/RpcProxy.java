package org.xhy.common.constants;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-08 11:59
 */
public enum RpcProxy {
    CG_LIB("cglib");


    public String name;
    RpcProxy(String type){
        this.name = type;
    }

    public static RpcProxy get(String type){
        for (RpcProxy value : values()) {
            if (value.name.equals(type)) {
                return value;
            }
        }
        return null;
    }
}
