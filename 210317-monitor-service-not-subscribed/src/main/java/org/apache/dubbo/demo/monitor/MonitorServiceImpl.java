package org.apache.dubbo.demo.monitor;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.monitor.MonitorService;

import java.util.ArrayList;
import java.util.List;

public class MonitorServiceImpl implements MonitorService {
    private List<URL> collectedStatistics = new ArrayList<>();


    @Override
    public void collect(URL statistics) {
        System.out.println("collect:" + statistics);
        collectedStatistics.add(statistics);
    }

    @Override
    public List<URL> lookup(URL query) {
        System.out.println("lookup:" + collectedStatistics.size());
        return new ArrayList<>(collectedStatistics);
    }
}
