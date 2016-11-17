package com.javaweb.model;

import com.javaweb.model.entity.Aircraft;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by Dron on 12-Nov-16.
 */
public class ModelAirlineCompany<T extends Aircraft> {
    private Map<T, Integer> aircraftContainer;

    public ModelAirlineCompany() {
        Comparator<T> comparator = (p1, p2) ->
                (p1.getRangeOfFlight() >= p2.getRangeOfFlight() ? 1 : -1);
        aircraftContainer = new TreeMap<>(comparator);
    }

    public void addAircraft(T aircraft) {
        if (aircraftContainer.containsKey(aircraft)) {
            aircraftContainer.replace(
                    aircraft,
                    aircraftContainer.get(aircraft) + 1);
        } else {
            aircraftContainer.put(aircraft, 1);
        }
    }

    public boolean removeAircraft(T aircraft) {
        if (aircraftContainer.containsKey(aircraft)) {
            if (aircraftContainer.get(aircraft) > 1) {
                aircraftContainer.replace(
                        aircraft,
                        aircraftContainer.get(aircraft) - 1
                );
            } else {
                aircraftContainer.remove(aircraft);
            }
            return true;
        }
        return false;
    }

    public long getOverallPassengerCapacity() {
        return aircraftContainer.entrySet().stream()
                .mapToLong(elem -> elem.getKey().getPassengerCapacity())
                .sum();
    }

    public double getOverallCarryingCapacity() {
        return aircraftContainer.entrySet().stream()
                .mapToDouble(elem -> elem.getKey().getCarryingCapacity())
                .sum();
    }

    public List<T> findAircraftWithFuelConsumption(double from, double to){
        return aircraftContainer.entrySet().stream()
                .filter(elem -> ((elem.getKey().getFuelConsumption() >= from)
                        && (elem.getKey().getFuelConsumption() <= to)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<T> getAllAirplanes(){
        return aircraftContainer.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
