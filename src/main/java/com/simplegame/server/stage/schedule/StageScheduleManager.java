package com.simplegame.server.stage.schedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class StageScheduleManager {

    private Map<String, String> scheduleMap = new HashMap();

    public void schedule(String paramString1, String paramString2, String paramString3, Object paramObject, long paramLong, TimeUnit paramTimeUnit) {
        this.scheduleMap.put(paramString2, paramString1);
    }

    public void schedule(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject,
            long paramLong, TimeUnit paramTimeUnit) {
        this.scheduleMap.put(paramString4, paramString1);
    }

    public void cancelSchedule(String component, String taskId) {
    }

    public void clear() {
        Iterator localIterator = this.scheduleMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            cancelSchedule((String) this.scheduleMap.get(str), str);
        }
    }
}