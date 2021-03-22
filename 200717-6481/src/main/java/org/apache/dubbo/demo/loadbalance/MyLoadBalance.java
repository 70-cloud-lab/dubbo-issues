package org.apache.dubbo.demo.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;

import java.util.List;

public class MyLoadBalance extends RandomLoadBalance {
    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        System.out.println("----Run MyLoadBalance----");
        return super.doSelect(invokers, url, invocation);
    }
}
