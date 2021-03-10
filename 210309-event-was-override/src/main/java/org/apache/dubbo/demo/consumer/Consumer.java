/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.DemoServiceA1;
import org.apache.dubbo.demo.DemoServiceA2;
import org.apache.dubbo.demo.DemoServiceB1;
import org.apache.dubbo.event.AbstractEventDispatcher;
import org.apache.dubbo.event.Event;
import org.apache.dubbo.event.EventDispatcher;
import org.apache.dubbo.event.EventListener;
import org.apache.dubbo.registry.client.event.ServiceInstancesChangedEvent;
import org.apache.dubbo.registry.client.event.listener.ServiceInstancesChangedListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static org.apache.dubbo.common.constants.RegistryConstants.REGISTRY_CLUSTER_KEY;

public class Consumer {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        DemoServiceA1 demoServiceA1 = context.getBean("demoServiceA1", DemoServiceA1.class);
        DemoServiceA2 demoServiceA2 = context.getBean("demoServiceA2", DemoServiceA2.class);
        DemoServiceB1 demoServiceB1 = context.getBean("demoServiceB1", DemoServiceB1.class);

        EventDispatcher ed = ExtensionLoader.getExtensionLoader(EventDispatcher.class).getDefaultExtension();
        ConcurrentMap<Class<? extends Event>, List<EventListener>> listenersCache = ((AbstractEventDispatcher) ed).getListenersCache();

        listenersCache.keySet().forEach(event -> {
            if (event.equals(ServiceInstancesChangedEvent.class)) ;
            listenersCache.get(event).forEach(listener -> {
                if (listener instanceof ServiceInstancesChangedListener) {
                    ServiceInstancesChangedListener listener1 = (ServiceInstancesChangedListener) listener;
                    System.out.println(listener1.getServiceNames() + "->" + listener1.getUrl().getParameter(REGISTRY_CLUSTER_KEY) + ":" + listener1.getServiceDiscovery().getUrl());
                }
            });
        });

        while (true) {
            System.in.read();
            System.out.println("result: " + demoServiceA1.sayHello("123"));
        }
    }
}
