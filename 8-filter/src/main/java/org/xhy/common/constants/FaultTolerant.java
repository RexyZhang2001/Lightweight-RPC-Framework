package org.xhy.common.constants;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-08 11:59
 */
public enum FaultTolerant {
    Failover("failover");


    public String name;
    FaultTolerant(String type){
        this.name = type;
    }


}
