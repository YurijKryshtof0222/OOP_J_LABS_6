package labs.laba7;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;

public class TrainSchedule implements Iterable<TrainRoute> {
    private List<TrainRoute> routeList = new ArrayList<>();

    public void add(TrainRoute trainRoute) {
        int index = 0;
        LocalTime curr = trainRoute.getTime();
        for (; index < routeList.size(); index++) {
            LocalTime temp = routeList.get(index).getTime();
            if (curr.isBefore(temp)) break;
        }
        routeList.add(index, trainRoute);
    }

    public Map<Integer, TrainRoute> getMap() {
        Map<Integer, TrainRoute> orderedTrainRouteMap = new HashMap<>();
        Iterator<TrainRoute> iter = routeList.iterator();
        for (int i = 0; i < routeList.size(); i++) {
            orderedTrainRouteMap.put(i , iter.next());
        }
        return orderedTrainRouteMap;
    }

    public TrainRoute remove (int index) {
        return routeList.remove(index);
    }

    public boolean remove (TrainRoute tr) {
        return routeList.remove(tr);
    }

    public TrainRoute get (int index) {
        return routeList.get(index);
    }

    public int size () {
        return routeList.size();
    }

    public Stream<TrainRoute> stream() {
        return routeList.stream();
    }

    @Override
    public Iterator<TrainRoute> iterator() {
        return routeList.iterator();
    }
}