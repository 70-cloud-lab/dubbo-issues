package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.monitor.Monitor;
import org.apache.dubbo.rpc.RpcContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OopsMonitor implements Monitor {
    private static final Logger logger = LoggerFactory.getLogger(OopsMonitor.class);

    URL url;

    public OopsMonitor(URL url) {
        this.url = url;
    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void destroy() {
        logger.info("Oops~destroy");
    }

    @Override
    public void collect(URL statistics) {
        logger.info("Oops~collect:ROUND=" + RpcContext.getContext().getAttachment("ROUND"));
//        logger.info("Oops~collect:url=" + statistics);
    }

    @Override
    public List<URL> lookup(URL query) {
        logger.info("Oops~lookup");
        return null;
    }
}
