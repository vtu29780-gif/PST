import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String, JourneyData> journeyMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class JourneyData {
        double totalTime = 0;
        int tripCount = 0;
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkInMap.remove(id);
        String routeKey = checkInInfo.stationName + "->" + stationName;
        int travelTime = t - checkInInfo.checkInTime;

        JourneyData journey = journeyMap.computeIfAbsent(routeKey, k -> new JourneyData());
        journey.totalTime += travelTime;
        journey.tripCount++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        JourneyData journey = journeyMap.get(routeKey);
        return journey.totalTime / journey.tripCount;
    }
}