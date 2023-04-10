package com.dongle.demo.netty.handler;

import com.dongle.demo.netty.annotation.Controller;
import com.dongle.demo.netty.core.NettyClassLoader;
import com.dongle.demo.netty.core.RequestMapper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ControllerHandler {

    public static final Map<String, RequestMapper> REQUEST_MAPPER_MAP = new ConcurrentHashMap<>();

    public final ControllerHandler INSTANCE = new ControllerHandler();
    private NettyClassLoader classLoader;

    private ControllerHandler() {
        // 1. 读取Controller修饰
        if (classLoader == null){
            classLoader = new NettyClassLoader();
        }

        List<Class<?>>list = classLoader.findClasses(Controller.class);



        // 2. 解析RequestMapping

        // 3.绑定uri和 RequestMapper

    }
}
