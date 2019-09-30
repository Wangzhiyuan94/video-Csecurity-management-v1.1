package com.wzy.video.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenter implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("---------------------------->请求创建");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("---------------------------->请求销毁");
    }
}
