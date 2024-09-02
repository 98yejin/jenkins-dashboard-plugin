package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.bind.JavaScriptMethod;

/**
 * Example of Jenkins global configuration.
 */
@Extension
public class SampleConfiguration extends GlobalConfiguration {

    /** @return the singleton instance */
    public static SampleConfiguration get() {
        return ExtensionList.lookupSingleton(SampleConfiguration.class);
    }

    private String dbConnectionInfo;
    private int dashboardPort;
    private int dataRetentionPeriod;
    private String jobNameRegex;

    public SampleConfiguration() {
        // When Jenkins is restarted, load any saved configuration from disk.
        load();
    }

    @DataBoundSetter
    public void setDbConnectionInfo(String dbConnectionInfo) {
        this.dbConnectionInfo = dbConnectionInfo;
        save();
    }

    public String getDbConnectionInfo() {
        return dbConnectionInfo;
    }

    @JavaScriptMethod
    public FormValidation doTestConnection(@QueryParameter("dbConnectionInfo") final String dbConnectionInfo) {
        try {
            // 예시: 데이터베이스 연결 테스트 로직 (JDBC 사용 예)
            if (dbConnectionInfo == null || dbConnectionInfo.isEmpty()) {
                return FormValidation.error("Database connection information is empty");
            }

            // Connection connection = DriverManager.getConnection(dbConnectionInfo);
            // connection.close();

            return FormValidation.ok("Connection successful!");
        } catch (Exception e) {
            return FormValidation.error("Connection failed: " + e.getMessage());
        }
    }

    @DataBoundSetter
    public void setDashboardPort(int dashboardPort) {
        this.dashboardPort = dashboardPort;
        save();
    }

    public int getDashboardPort() {
        return dashboardPort;
    }

    @DataBoundSetter
    public void setDataRetentionPeriod(int dataRetentionPeriod) {
        this.dataRetentionPeriod = dataRetentionPeriod;
        save();
    }

    public int getDataRetentionPeriod() {
        return dataRetentionPeriod;
    }

    @DataBoundSetter
    public void setJobNameRegex(String jobNameRegex) {
        this.jobNameRegex = jobNameRegex;
        save();
    }

    public String getJobNameRegex() {
        return jobNameRegex;
    }

    //    public String getLabel() {
    //        return label;
    //    }
    //
    //    @DataBoundSetter
    //    public void setLabel(String label) {
    //        this.label = label;
    //        save();
    //    }

    public FormValidation doCheckLabel(@QueryParameter String value) {
        if (StringUtils.isEmpty(value)) {
            return FormValidation.warning("Please specify a label.");
        }
        return FormValidation.ok();
    }
}
