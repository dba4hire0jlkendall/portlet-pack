package org.exoplatform.addons.portlets.moodswing;

import juzu.Path;
import juzu.View;
import juzu.request.RenderContext;
import juzu.template.Template;
import org.exoplatform.social.core.activity.model.ExoSocialActivity;
import org.exoplatform.social.core.activity.model.ExoSocialActivityImpl;
import org.exoplatform.social.core.identity.model.Identity;
import org.exoplatform.social.core.identity.provider.OrganizationIdentityProvider;
import org.exoplatform.social.core.manager.ActivityManager;
import org.exoplatform.social.core.manager.IdentityManager;

import javax.inject.Inject;
import java.io.IOException;

public class MoodSwingApplication
{

    @Inject
    ActivityManager activityManager;
    @Inject
    IdentityManager identityManager;

  /** . */
  @Inject
  @Path("index.gtmpl")
  Template indexTemplate;

  @View
  public void index(RenderContext renderContext) throws IOException
  {
      indexTemplate.render();
  }


    /***
     * Publish an activity *message* in the Activities Stream of user *username*
     * @param username : username of the user in which the Activity will be deployed
     * @param message : message to be published
     * @throws Exception
     */
    private void addActivity (String username, String message) throws Exception {

        //--- Create Social Identity
        Identity identity = identityManager.getOrCreateIdentity(OrganizationIdentityProvider.NAME, username,false);

        //--- Create a Activity
        ExoSocialActivity activity = new ExoSocialActivityImpl();

        //---Set the activity Title (message de be displayed
        activity.setTitle(message);

        //--- Set the Identity in which th Activity will be displayed
        activity.setUserId(identity.getId());

        //TODO check if it is an update or a new Activity ?!

        try {

            //--- Invoke the ActivityManager to add a new Activity
            activityManager.saveActivityNoReturn(identity, activity);

        } catch (Exception e) {

        }


    }


}
