package ru.teacher.retrofit_v0322.data.LocalHost;

public class DataRequest {
    private final int mark_min;
    private final int mark_max;

    public DataRequest(int mark_min, int mark_max) {
        this.mark_min = mark_min;
        this.mark_max = mark_max;
    }

    public int getMark_min() {
        return mark_min;
    }

    public int getMark_max() {
        return mark_max;
    }

    @Override
    public String toString() {
        return "mark_min=" + mark_min + "\nmark_max=" + mark_max;
    }
}
