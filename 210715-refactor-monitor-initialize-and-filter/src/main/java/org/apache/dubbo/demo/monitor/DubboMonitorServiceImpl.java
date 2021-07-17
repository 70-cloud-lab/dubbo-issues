package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.monitor.MonitorService;

import java.util.ArrayList;
import java.util.List;

@DubboService
public class DubboMonitorServiceImpl implements MonitorService {

    List<URL> Collectors = new ArrayList<>();

    @Override
    public void collect(URL statistics) {
        System.out.println("++++++++" + statistics);
        Collectors.add(statistics);
    }

    @Override
    public List<URL> lookup(URL query) {
        System.out.println("---------");
        return Collectors;
    }
}
