package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class DubboMonitor {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboMonitor.MonitorConfiguration.class);
        context.start();
        Thread.currentThread().join();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.demo.monitor")
    @PropertySource("classpath:/spring/monitor.properties")
    static class MonitorConfiguration {
    }
}
