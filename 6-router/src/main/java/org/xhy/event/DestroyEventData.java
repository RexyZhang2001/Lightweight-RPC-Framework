package org.xhy.event;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-14 23:48
 */
public class DestroyEventData implements RpcEventData{

    private Object o;

    public DestroyEventData(Object o) {
        this.o = o;
    }

    @Override
    public void setData(Object o) {
        this.o = o;
    }

    @Override
    public Object getData() {
        return o;
    }
}
