package org.xhy.event;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-14 23:48
 */
public class UpdateRpcLister implements IRpcLister<UpdateRpcEventData>{
    @Override
    public void exec(UpdateRpcEventData updateRpcEventData) {
        System.out.println("触发修改件" + updateRpcEventData);

    }
}
