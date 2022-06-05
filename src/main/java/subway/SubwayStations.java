package subway;

import java.util.HashMap;

public class SubwayStations {
    
    private HashMap<Integer,String> stations;
    
    public SubwayStations() {
        this.stations = new HashMap<Integer,String>();
    }
    
    public String getStationName(int stationID) {
        return this.stations.get(stationID);
    }
    
    public void addStation(int stationID, String stationName) {
        this.stations.put(stationID, stationName);
    }
    
    public int getStationID(String stationName) {
        for (int stationID : this.stations.keySet()) {
            String station = this.stations.get(stationID);
            if (station.equals(stationName)) {
                return stationID;
            }
        }
        return 0;
    }
}
