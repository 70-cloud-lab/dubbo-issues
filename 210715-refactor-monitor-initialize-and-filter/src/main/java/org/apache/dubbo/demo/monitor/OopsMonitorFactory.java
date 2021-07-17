package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.monitor.Monitor;
import org.apache.dubbo.monitor.support.AbstractMonitorFactory;

public class OopsMonitorFactory extends AbstractMonitorFactory {
    @Override
    protected Monitor createMonitor(URL url) {
        System.out.println("NEW OOPS");
        return new OopsMonitor(url);
    }
}
