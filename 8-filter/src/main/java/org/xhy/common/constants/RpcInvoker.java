package org.xhy.common.constants;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 17:00
 */
public enum RpcInvoker {
    JDK("jdk");

    public String name;
    RpcInvoker(String type){
        this.name = type;
    }


}
