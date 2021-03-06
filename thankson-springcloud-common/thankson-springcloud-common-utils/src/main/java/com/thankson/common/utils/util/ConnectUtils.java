package com.thankson.common.utils.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 * @author Thankson
 * @date 2020年2月19日
 */
public class ConnectUtils {

	/**
	 * 关闭对象，连接
	 */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
