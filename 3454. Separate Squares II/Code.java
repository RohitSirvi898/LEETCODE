class Solution {
    public double separateSquares(int[][] squares) {

        Set<Integer> xSet = new HashSet<>();
        for (int[] sq : squares) {
            xSet.add(sq[0]);
            xSet.add(sq[0] + sq[2]);
        }
        List<Integer> xCoords = new ArrayList<>(xSet);
        Collections.sort(xCoords);
        
        Map<Integer, Integer> xMap = new HashMap<>();
        for (int i = 0; i < xCoords.size(); i++) {
            xMap.put(xCoords.get(i), i);
        }

        List<Event> events = new ArrayList<>();
        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort((a, b) -> Integer.compare(a.y, b.y));

        SegmentTree st = new SegmentTree(xCoords);
        List<Strip> strips = new ArrayList<>();
        double totalArea = 0;
        int prevY = events.get(0).y;

        for (Event e : events) {

            int h = e.y - prevY;

            if (h > 0) {
                double width = st.getCoveredLength();
                double stripArea = width * h;
                
                totalArea += stripArea;
                strips.add(new Strip(prevY, h, width, stripArea));
            }

            st.update(1, 0, xCoords.size() - 2, xMap.get(e.x1), xMap.get(e.x2) - 1, e.type);
            prevY = e.y;
        }

        double targetArea = totalArea / 2.0;
        double currentArea = 0;

        for (Strip s : strips) {
            if (currentArea + s.area >= targetArea) {
                double neededArea = targetArea - currentArea;

                return s.startY + (neededArea / s.width);
            }
            currentArea += s.area;
        }

        return prevY;
    }


    static class Event {
        int y, type, x1, x2;
        public Event(int y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class Strip {
        int startY, height;
        double width, area;
        public Strip(int startY, int height, double width, double area) {
            this.startY = startY;
            this.height = height;
            this.width = width;
            this.area = area;
        }
    }

    static class SegmentTree {
        List<Integer> xCoords;
        int[] count;
        double[] length;

        public SegmentTree(List<Integer> xCoords) {
            this.xCoords = xCoords;
            int n = xCoords.size();
            this.count = new int[4 * n];
            this.length = new double[4 * n];
        }

        public void update(int node, int start, int end, int l, int r, int val) {
            if (l > end || r < start) return;

            if (l <= start && end <= r) {
                count[node] += val;
            } else {
                int mid = start + (end - start) / 2;
                update(2 * node, start, mid, l, r, val);
                update(2 * node + 1, mid + 1, end, l, r, val);
            }
            pushUp(node, start, end);
        }

        private void pushUp(int node, int start, int end) {
            if (count[node] > 0) {
                length[node] = xCoords.get(end + 1) - xCoords.get(start);
            } else if (start != end) {
                length[node] = length[2 * node] + length[2 * node + 1];
            } else {
                length[node] = 0;
            }
        }

        public double getCoveredLength() {
            return length[1];
        }
    }
}