package org.apache.dubbo.demo.configcenter;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.config.configcenter.AbstractDynamicConfigurationFactory;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;

public class TestDynamicConfigurationFactory extends AbstractDynamicConfigurationFactory {
    @Override
    protected DynamicConfiguration createDynamicConfiguration(URL url) {
        return new TestDynamicConfiguration(url);
    }
}
