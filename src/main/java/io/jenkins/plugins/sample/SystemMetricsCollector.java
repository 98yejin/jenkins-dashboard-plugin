package io.jenkins.plugins.sample;

import com.sun.management.OperatingSystemMXBean;
import hudson.model.Computer;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import jenkins.model.Jenkins;

public class SystemMetricsCollector {
    public static int getOnlineAgentCount() {
        int count = 0;
        for (Computer computer : Jenkins.get().getComputers()) {
            if (!computer.isOffline()) { // 온라인 상태는 오프라인이 아닌 경우
                count++;
            }
        }
        return count;
    }

    public static int getOfflineAgentCount() {
        int count = 0;
        for (Computer computer : Jenkins.get().getComputers()) {
            if (computer.isOffline()) { // 오프라인 상태
                count++;
            }
        }
        return count;
    }

    public static int getTotalAgentCount() {
        return Jenkins.get().getComputers().length;
    }

    public static String getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory(); // in bytes
        long freeMemory = runtime.freeMemory(); // in bytes
        long usedMemory = totalMemory - freeMemory;

        long totalMemoryInMB = totalMemory / (1024 * 1024);
        long usedMemoryInMB = usedMemory / (1024 * 1024);

        return String.format(
                "%d MB / %d MB (%.2f%% used)",
                usedMemoryInMB, totalMemoryInMB, (double) usedMemory / totalMemory * 100);
    }

    public static String getCpuUsage() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuLoad = osBean.getSystemCpuLoad() * 100;
        return String.format("CPU Usage: %.2f%%", cpuLoad);
    }

    public static String getDiskUsage() {
        File jenkinsHome = Jenkins.get().getRootDir();
        long totalSpace = jenkinsHome.getTotalSpace(); // in bytes
        long freeSpace = jenkinsHome.getUsableSpace(); // in bytes
        long usedSpace = totalSpace - freeSpace;

        long totalSpaceInGB = totalSpace / (1024 * 1024 * 1024);
        long usedSpaceInGB = usedSpace / (1024 * 1024 * 1024);

        return String.format(
                "%d GB / %d GB (%.2f%% used)", usedSpaceInGB, totalSpaceInGB, (double) usedSpace / totalSpace * 100);
    }

    public static String getJenkinsUptime() {
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        long uptime = rb.getUptime(); // in milliseconds

        long uptimeSeconds = uptime / 1000;
        long uptimeMinutes = uptimeSeconds / 60;
        long uptimeHours = uptimeMinutes / 60;
        long uptimeDays = uptimeHours / 24;

        return String.format("%d days, %d hours, %d minutes", uptimeDays, uptimeHours % 24, uptimeMinutes % 60);
    }
}
