package com.ww;

public class CustomLogger {
    private static volatile CustomLogger instance = null;

    private CustomLogger() {
        //init some data some config
    }

    // 线程安全的单例模式
    public static CustomLogger getInstance() {
        if (instance == null) {  // 第一次检查：无锁快速判断实例是否已存在
            synchronized (CustomLogger.class) {  // 同步块，确保线程安全
                if (instance == null) {  // 第二次检查：确保在等待锁的过程中实例未被其他线程创建
                    instance = new CustomLogger();  // 创建实例
                }
            }
        }
        return instance;
    }

    public void info(String message) {
        System.out.println("[■Flight■ INFO] " + message);
    }

    public void debug(String message) {
        System.out.println("[■Flight■ DEBUG] " + message);
    }

    public void error(String message) {
        System.out.println("[■Flight■ ERROR] " + message);
    }

}
