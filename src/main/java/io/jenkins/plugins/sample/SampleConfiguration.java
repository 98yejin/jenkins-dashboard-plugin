package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.bind.JavaScriptMethod;

@Extension
public class SampleConfiguration extends GlobalConfiguration {

    private boolean showUptime;
    private boolean showOnlineAgents;
    private boolean showOfflineAgents;
    private boolean showTotalAgents;
    private boolean showMemoryUsage;
    private boolean showCpuUsage;
    private boolean showDiskUsage;

    public SampleConfiguration() {
        load();
    }

    @DataBoundSetter
    public void setShowUptime(boolean showUptime) {
        this.showUptime = showUptime;
        save();
    }

    public boolean isShowUptime() {
        return showUptime;
    }

    @DataBoundSetter
    public void setShowOnlineAgents(boolean showOnlineAgents) {
        this.showOnlineAgents = showOnlineAgents;
        save();
    }

    public boolean isShowOnlineAgents() {
        return showOnlineAgents;
    }

    @DataBoundSetter
    public void setShowOfflineAgents(boolean showOfflineAgents) {
        this.showOfflineAgents = showOfflineAgents;
        save();
    }

    public boolean isShowOfflineAgents() {
        return showOfflineAgents;
    }

    @DataBoundSetter
    public void setShowTotalAgents(boolean showTotalAgents) {
        this.showTotalAgents = showTotalAgents;
        save();
    }

    public boolean isShowTotalAgents() {
        return showTotalAgents;
    }

    @DataBoundSetter
    public void setShowMemoryUsage(boolean showMemoryUsage) {
        this.showMemoryUsage = showMemoryUsage;
        save();
    }

    public boolean isShowMemoryUsage() {
        return showMemoryUsage;
    }

    @DataBoundSetter
    public void setShowCpuUsage(boolean showCpuUsage) {
        this.showCpuUsage = showCpuUsage;
        save();
    }

    public boolean isShowCpuUsage() {
        return showCpuUsage;
    }

    @DataBoundSetter
    public void setShowDiskUsage(boolean showDiskUsage) {
        this.showDiskUsage = showDiskUsage;
        save();
    }

    public boolean isShowDiskUsage() {
        return showDiskUsage;
    }
}
