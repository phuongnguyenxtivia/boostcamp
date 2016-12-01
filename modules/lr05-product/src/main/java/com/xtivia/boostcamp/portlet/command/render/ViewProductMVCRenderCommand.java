/**
 * 
 */
package com.xtivia.boostcamp.portlet.command.render;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.xtivia.boostcamp.common.ModuleConstants;
import com.xtivia.boostcamp.common.ProductPortletKeys;
import com.xtivia.boostcamp.model.Product;
import com.xtivia.boostcamp.portlet.configuration.ProductConfiguration;
import com.xtivia.boostcamp.service.ProductLocalServiceUtil;;

/**
 * @author pnguyen
 *
 */
@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + ProductPortletKeys.PRODUCTS,
	       "mvc.command.name=" + ModuleConstants.URL_PRODUCT_VIEW
	    },
	    service = MVCRenderCommand.class
	)
public class ViewProductMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		if (Validator.isNumber(ParamUtil.getString(renderRequest, "prodId"))) {
			try {
				long key = ParamUtil.getLong(renderRequest, "prodId");
				renderRequest.setAttribute("product", ProductLocalServiceUtil.getProduct(key));
				
				return ModuleConstants.URL_PRODUCT_VIEW;
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		
		return ModuleConstants.URL_PRODUCTS_VIEW;
	}

}
