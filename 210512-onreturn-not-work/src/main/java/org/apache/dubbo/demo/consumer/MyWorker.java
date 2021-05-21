package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.demo.DemoServiceA1;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("myWorker")
public class MyWorker {

    @DubboReference(methods = {@Method(name = "sayHello", async = true, onreturn = "myWorker.doReturn")})
    private DemoServiceA1 a1;

    public void doWork() throws IOException {
        while (true) {
            System.in.read();
            System.out.println("result: " + a1.sayHello("123"));
        }
    }

    public void doReturn(String out, String in) {
        System.out.println(out);
        System.out.println(in);
    }
}
