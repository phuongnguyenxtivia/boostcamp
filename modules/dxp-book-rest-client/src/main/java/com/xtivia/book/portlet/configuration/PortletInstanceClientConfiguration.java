package com.xtivia.book.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * Created by ddavis on 8/16/16.
 */
@ExtendedObjectClassDefinition(
        category = "productivity",
        scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(id = "client.portlet.PortletInstanceClientConfiguration")
public interface PortletInstanceClientConfiguration {
    @Meta.AD(
            deflt = "/index",
            required = false
    )
    public String defaultRoute();
}
