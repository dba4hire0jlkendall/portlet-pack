package org.exoplatform.addons.portlets.moodswing;

import juzu.Path;
import juzu.Resource;
import juzu.View;
import juzu.request.RenderContext;
import juzu.template.Template;
import org.exoplatform.addons.portlets.rss.model.Feed;
import org.exoplatform.addons.portlets.rss.model.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.portlet.PortletPreferences;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoodSwingApplication
{

  /** . */
  @Inject
  @Path("index.gtmpl")
  Template indexTemplate;

  @View
  public void index(RenderContext renderContext) throws IOException
  {
      indexTemplate.render();
  }

}
