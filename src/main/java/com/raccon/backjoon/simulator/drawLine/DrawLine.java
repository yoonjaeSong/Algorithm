package com.raccon.backjoon.simulator.drawLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://chw0501.tistory.com/9
public class DrawLine {
    public int[] solution(int[][] input) {
        int n = input.length;
        List<int[]> points = new ArrayList<>();

        int start = 0;
        for (int i = 1; i < n; i++) {
            if (input[start][0] > input[i][0]) {
                start = i;
            } else if ((input[start][0] == input[i][0]) && (input[start][1] > input[i][1])) {
                start = i;
            }
        }

        int type;
        int[] before, after;

        before = input[start];
        for (int i = 0; i < n - 1; i++) {
            start = (start + 1) % n;
            after = input[start];

            type = find(before, after);
            if (type == 1) {
                points.add(new int[]{before[0], 0});
            } else if (type == 2) {
                points.add(new int[]{before[0], 0});
            }

            before = after;
        }

        Range[] ranges = new Range[points.size() / 2];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = new Range();
            ranges[i].setRange(points.get(i * 2), points.get(i * 2 + 1));
        }

        Arrays.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return (o1.start > o2.start) ? 1 : -1;
            }
        });

        int a = 1, b = 1;
        int inBound = ranges[0].end, outBound = ranges[0].end;
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i].end > outBound) {
                a++;
                b++;
                inBound = ranges[i].end;
                outBound = ranges[i].end;
            } else if (ranges[i].end < inBound) {
                inBound = ranges[i].end;
            } else {
                b++;
                inBound = ranges[i].end;
            }
        }

        return new int[]{a, b};
    }

    private int find(int[] before, int[] after) {
        if (before[1] < 0) {
            return (after[1] < 0) ? 0 : 1;
        } else {
            return (after[1] < 0) ? 2 : 3;
        }
    }
}

class Range {

    int start;
    int end;

    public void setRange(int[] a, int[] b) {
        if (a[0] < b[0]) {
            start = a[0];
            end = b[0];
        } else {
            start = b[0];
            end = a[0];
        }
    }
}
