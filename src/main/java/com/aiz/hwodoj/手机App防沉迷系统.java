package com.aiz.hwodoj;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 手机App防沉迷系统
 * @description 手机App防沉迷系统
 * @date Create in 00:34 2025/2/8
 */
public class 手机App防沉迷系统 {

    public static class App {
        // App名称
        String appName;
        // 优先级 1~5
        int priority;
        // 起始时间
        int startTime;
        // 结束时间
        int endTime;

        public App(String appName, int priority, int startTime, int endTime) {
            this.appName = appName;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<App> appList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            appList.add(new App(sc.next(), sc.nextInt(), convertTime(sc.next()), convertTime(sc.next())));
        }
        String timeStr = sc.next();

        System.out.println(findAppName(appList, convertTime(timeStr)));
    }

    public static String findAppName(List<App> appList, int time) {
        List<App> registeredApps = new ArrayList<>();
        for (App app : appList) {
            // 如果startTime大于endTime，则跳过
            if (app.startTime >= app.endTime) {
                continue;
            }
            // 遍历已经注册的App列表
            for (int i = registeredApps.size() - 1; i >= 0; i--) {
                App registeredApp = registeredApps.get(i);
                // 如果时间冲突
                if (Math.max(app.startTime, registeredApp.startTime) <= Math.min(app.endTime, registeredApp.endTime)) {
                    // 如果优先级高于已注册的app
                    if (app.priority > registeredApp.priority) {
                        registeredApps.remove(i);
                    }
                }
            }
            // 将当前App添加到已注册的App列表中
            registeredApps.add(app);
        }
        for (App registeredApp : registeredApps) {
            if (registeredApp.startTime <= time && time < registeredApp.endTime) {
                return registeredApp.appName;
            }
        }
        return "NA";
    }

    private static int convertTime(String timeStr) {
        String[] split = timeStr.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    @Test
    public void test() {
        List<App> appList = new ArrayList<>();
        {
            App app = new App("App1", 1, convertTime("09:00"), convertTime("10:00"));
            appList.add(app);
        }
        int time = convertTime("09:30");

        String appName = findAppName(appList, time);
        assert "App1".equals(appName);
    }

    @Test
    public void test2() {
        List<App> appList = new ArrayList<>();
        {
            App app = new App("App1", 1, convertTime("09:00"), convertTime("10:00"));
            appList.add(app);
        }
        {
            App app = new App("App2", 2, convertTime("09:10"), convertTime("09:30"));
            appList.add(app);
        }
        int time = convertTime("09:20");

        String appName = findAppName(appList, time);
        assert "App2".equals(appName);
    }

}
