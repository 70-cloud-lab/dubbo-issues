package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.monitor.Monitor;
import org.apache.dubbo.monitor.support.AbstractMonitorFactory;

public class OopsMonitorFactory extends AbstractMonitorFactory {
    @Override
    protected Monitor createMonitor(URL url) {
        return new OopsMonitor(url);
    }
}
