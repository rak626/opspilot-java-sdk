package com.opspilot.sdk;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class EventBuilder {

    public static ErrorEvent fromException(Exception ex,
                                           Map<String, Object> metadata) {

        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));

        return new ErrorEvent(
                SdkState.getConfig().getAppName(),
                SdkState.getConfig().getEnvironment(),
                ex.getMessage(),
                sw.toString(),
                metadata
        );
    }
}
