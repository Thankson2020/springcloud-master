package com.thankson.common.components.canal.annotation.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.components.canal.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 刪除表操作監聽器
 *

 * @CopyRight 万物皆导
 * @created 2018年05月28日 19:27:00
 * @Modified_By 阿导 2018/5/28 19:27
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.ERASE)
public @interface DropTableListenPoint {
	/**
	 * canal 指令
	 * default for all
	 *
	 * @return canal destination

	 * @time 2018/5/28 15:49
	 * @CopyRight 万物皆导
	 */
	@AliasFor(annotation = ListenPoint.class)
	String destination() default "";
	
	/**
	 * 数据库实例
	 *
	 * @return canal destination

	 * @time 2018/5/28 15:49
	 * @CopyRight 万物皆导
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] schema() default {};
}
