package org.apache.dubbo.demo.configcenter;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.config.configcenter.ConfigurationListener;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;

public class TestDynamicConfiguration implements DynamicConfiguration {

    private URL url;

    public TestDynamicConfiguration(URL url) {
        this.url = url;
    }

    @Override
    public String getProperties(String key, String group, long timeout) throws IllegalStateException {
        System.out.println("----getProperties: key=" + key + "; group=" + group);
        return null;
    }

    @Override
    public Object getInternalProperty(String key) {
        System.out.println("----getInternalProperty: key=" + key);
        return null;
    }

    @Override
    public void addListener(String key, String group, ConfigurationListener listener) {
        System.out.println("----addListener: key=" + key + "; group=" + group);
    }

    @Override
    public void removeListener(String key, String group, ConfigurationListener listener) {
        System.out.println("----removeListener: key=" + key + "; group=" + group);
    }

    @Override
    public String getConfig(String key, String group, long timeout) throws IllegalStateException {
        System.out.println("----getConfig: key=" + key + "; group=" + group);
        return null;
    }
}
