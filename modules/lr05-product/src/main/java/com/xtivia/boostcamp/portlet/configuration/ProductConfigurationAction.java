/**
 * 
 */
package com.xtivia.boostcamp.portlet.configuration;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import aQute.bnd.annotation.metatype.Configurable;

/**
 * @author pnguyen
 *
 */
@Component(
	     configurationPid = "com.xtivia.boostcamp.portlet.configuration.ProductConfiguration",
	     configurationPolicy = ConfigurationPolicy.OPTIONAL,
	     immediate = true,
	     property = {
	         "javax.portlet.name=com_xtivia_boostcamp_portlet_LR05ProductPortlet"
	     },
	     service = ConfigurationAction.class
	 )
public class ProductConfigurationAction extends DefaultConfigurationAction {
	
	private volatile ProductConfiguration _configuration;

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.BaseJSPSettingsConfigurationAction#include(javax.portlet.PortletConfig, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute(ProductConfiguration.class.getName(), _configuration);

		super.include(portletConfig, request, response);
	}

	/**
	 * This method is invoked when the application starts (due to the @Activate
	 * annotation) and whenever the configuration is modified (due to
	 * the @Modified annotation)
	 */
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(ProductConfiguration.class, properties);
	}
}
