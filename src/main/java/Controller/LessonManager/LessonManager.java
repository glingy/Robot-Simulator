package Controller.LessonManager;

import java.util.HashMap;
import java.util.Map;

import Controller.Lesson;

/**
 * Created by gregory.ling on 2/4/18.
 */
public class LessonManager {
    public Map<Integer, Lesson> Lessons = new HashMap<>();

    public LessonManager() {
        Lessons.put(0, new L0());
        Lessons.put(1, new L1());
        Lessons.put(2, new L2());
        Lessons.put(3, new L3());
        Lessons.put(4, new L4());
        Lessons.put(5, new L5());
    }
}
