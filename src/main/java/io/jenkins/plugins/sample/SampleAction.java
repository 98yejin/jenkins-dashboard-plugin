package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;

@Extension
public class SampleAction implements UnprotectedRootAction {

    @Override
    public String getUrlName() {
        return "sample-action"; // 액션에 접근할 URL
    }

    @Override
    public String getDisplayName() {
        return "Sample Action 2"; // Jenkins UI에 표시될 이름
    }

    @Override
    public String getIconFileName() {
        return "gear.png"; // 액션 옆에 표시될 아이콘 (필요에 따라 선택적)
    }

    // SampleConfiguration의 데이터를 사용할 수 있도록 getInstance 호출
    public String getJenkinsUptime() {
        return SampleConfiguration.get().getJenkinsUptime();
    }
}
