package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

import java.io.IOException;

public class Register {
    public static void main(String[] args) throws IOException, InterruptedException {
        RegistryFactory factory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = factory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));

        String url = "override://0.0.0.0/org.apache.dubbo.demo.DemoService?category=configurators&dynamic=false&weight=200";
        registry.register(URL.valueOf(url));

        Thread.sleep(5000);
    }
}
