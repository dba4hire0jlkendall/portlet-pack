package org.exoplatform.addons.portlets.moodswing;

import juzu.Path;
import juzu.Resource;
import juzu.View;
import juzu.request.RenderContext;
import juzu.template.Template;
import org.exoplatform.addons.statistics.api.services.StatisticsService;
import org.exoplatform.addons.statistics.api.web.listener.StatisticsLifecycleListener;
import org.exoplatform.commons.juzu.ajax.Ajax;
import org.exoplatform.social.core.activity.model.ExoSocialActivity;
import org.exoplatform.social.core.activity.model.ExoSocialActivityImpl;
import org.exoplatform.social.core.identity.model.Identity;
import org.exoplatform.social.core.identity.provider.OrganizationIdentityProvider;
import org.exoplatform.social.core.manager.ActivityManager;
import org.exoplatform.social.core.manager.IdentityManager;
import org.exoplatform.web.application.RequestContext;

import javax.inject.Inject;
import java.io.IOException;

public class MoodSwingApplication {

    /**
     * .
     */
    StatisticsService statisticsService;
    public MoodSwingApplication() {
        try {
            statisticsService = StatisticsLifecycleListener.getInstance().getInstance(StatisticsService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Inject
    ActivityManager activityManager;
    @Inject
    IdentityManager identityManager;

    @Inject
    @Path("index.gtmpl")
    Template indexTemplate;

    @View
    public void index(RenderContext renderContext) throws IOException {
        indexTemplate.render();
    }

    @Ajax
    @Resource
    public void storeStatus(String status) throws Exception {
       String remoteUser = RequestContext.getCurrentInstance().getRemoteUser();
       statisticsService.addEntry("root", "", status, "Mood", "SWING", "", "", "", "");
       System.out.println(">>>>>>>> DONE: " + statisticsService.getStatistics(0).size());
       indexTemplate.render();
    }

    /*private void addActivity (String username, String message) throws Exception {

        Identity identity = identityManager.getOrCreateIdentity(OrganizationIdentityProvider.NAME, username,false);
        ExoSocialActivity activity = new ExoSocialActivityImpl();
        activity.setTitle(message);
        activity.setUserId(identity.getId());
        try {
            activityManager.saveActivityNoReturn(identity, activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
