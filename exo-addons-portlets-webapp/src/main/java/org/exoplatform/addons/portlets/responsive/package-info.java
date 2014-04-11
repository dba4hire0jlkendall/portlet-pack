@Assets(
        location = AssetLocation.SERVER,
        scripts = {
                @Script(src = "js/jquery-1.8.3.min.js", id = "jquery"),
                @Script(src = "js/responsive.js", id = "responsive", depends = "jquery")
        },
        stylesheets = {
                @Stylesheet(src = "/org/exoplatform/addons/portlets/responsive/assets/responsive.css", location = AssetLocation.APPLICATION)
        }
)
@Less(value = "responsive.less", minify = true)


@Application(defaultController = ResponsiveApplication.class)
@Portlet(name="ResponsivePortlet") package org.exoplatform.addons.portlets.responsive;

import juzu.Application;
import juzu.asset.AssetLocation;
import juzu.plugin.asset.Assets;
import juzu.plugin.asset.Script;
import juzu.plugin.asset.Stylesheet;
import juzu.plugin.less.Less;
import juzu.plugin.portlet.Portlet;
