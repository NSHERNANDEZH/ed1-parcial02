package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {
    private final Map<String, Integer> messageTimestamps;

    public E02Logger() {
        messageTimestamps = new HashMap<>();


    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }

        int lastPrintedTime = messageTimestamps.get(message);
        if (timestamp >= lastPrintedTime + 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }


        return false;
    }
}

