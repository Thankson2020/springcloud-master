package com.thankson.common.components.canal.client.abstracts.option.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.springcloud.common.components.canal.client.abstracts.option.AbstractDBOption;

/**
 * 修改表操作
 */
public abstract class AlertTableOption extends AbstractDBOption {
    /**
     * 修改表操作
     */
    @Override
    protected void setEventType() {
        this.eventType = CanalEntry.EventType.ALTER;
    }
}
