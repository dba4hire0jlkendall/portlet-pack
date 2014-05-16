/*
 * Copyright (C) 2003-2014 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.addons.portlets.moodtrend;

import juzu.Path;
import juzu.Resource;
import juzu.View;
import juzu.request.RenderContext;
import juzu.template.Template;
import org.exoplatform.addons.statistics.api.bo.StatisticBO;
import org.exoplatform.addons.statistics.api.services.StatisticsService;
import org.exoplatform.addons.statistics.api.web.listener.StatisticsLifecycleListener;
import org.exoplatform.commons.juzu.ajax.Ajax;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class MoodTrendApplication {
    private static Logger log = Logger.getLogger("org.exoplatform.addons.portlets.moodtrend.MoodTrendApplication");

    StatisticsService statisticsService;

    public MoodTrendApplication() {
        try {
            statisticsService = StatisticsLifecycleListener.getInstance().getInstance(StatisticsService.class);
        } catch (Exception e) {
            log.info("##### Statistics Service initialization error");
        }
    }

    /**
     * .
     */
    @Inject
    @Path("index.gtmpl")
    Template indexTemplate;

    @View
    public void index(RenderContext renderContext) throws IOException {
        indexTemplate.render();
    }

    @Ajax
    @Resource
    public long getMoodTrendStats(String moodType) throws Exception {
        List<StatisticBO> statisticBOs = null;
        try {
            statisticBOs = statisticsService.filter(null, null, null, moodType, null, null, null, false, 0);
        } catch (Exception E) {
            log.info("##### Statistics Service usage error");
        }
        log.info("##### Statistics :: Mood Trend [" + moodType + "] :: " + statisticBOs.size());
        indexTemplate.render();
        return statisticBOs.size();
    }
}
