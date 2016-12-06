package com.xtivia.book.portlet.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import org.osgi.service.component.annotations.Component;

/**
 * Created by ddavis on 8/16/16.
 */
@Component
public class PortletInstanceClientConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    @Override
    public Class<?> getConfigurationBeanClass() {
        return PortletInstanceClientConfiguration.class;
    }
}
