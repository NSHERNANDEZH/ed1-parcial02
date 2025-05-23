package ed.lab;

import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }


        meetingIntervals.sort((a, b) -> Integer.compare(a.startTime(), b.startTime()));


        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {

            if (!endTimes.isEmpty() && interval.startTime() >= endTimes.peek()) {
                endTimes.poll(); // Reutilizamos la sala
            }


            endTimes.offer(interval.endTime());
        }

        return endTimes.size(); // El tamaño del heap es el número de salas necesarias
    }
}
