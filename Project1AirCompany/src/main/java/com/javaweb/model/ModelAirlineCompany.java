package com.javaweb.model;

import com.javaweb.model.entity.Aircraft;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Dron on 12-Nov-16.
 */
public class ModelAirlineCompany<T extends Aircraft> {
    private Map<T, Integer> aircraftContainer;

    public ModelAirlineCompany() {
        Comparator<T> comparator = (p1, p2) -> {
            if (p1.equals(p2)) {
                return 0;
            } else if (p1.getRangeOfFlight() > p2.getRangeOfFlight()) {
                return 1;
            } else {
                return -1;
            }
        };
        aircraftContainer = new TreeMap<>(comparator);
    }

    public void addAircraft(T aircraft) {
        if (aircraft == null) {
            return;
        }
        if (aircraftContainer.containsKey(aircraft)) {
            aircraftContainer.replace(
                    aircraft,
                    aircraftContainer.get(aircraft) + 1);
        } else {
            aircraftContainer.put(aircraft, 1);
        }
        int i = aircraft.hashCode();

    }

    public boolean removeAircraft(T aircraft) {
        if (aircraft == null) {
            return false;
        }
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

    public boolean isEmpty() {
        return aircraftContainer.isEmpty();
    }

    public long getOverallPassengerCapacity() {
        if (aircraftContainer.isEmpty()) {
            return 0;
        }
        return aircraftContainer.entrySet().stream()
                .mapToLong(elem -> elem.getKey().getPassengerCapacity())
                .sum();
    }

    public double getOverallCarryingCapacity() {
        if (aircraftContainer.isEmpty()) {
            return 0;
        }
        return aircraftContainer.entrySet().stream()
                .mapToDouble(elem -> elem.getKey().getCarryingCapacity())
                .sum();
    }

    public List<T> findAircraftWithFuelConsumption(double from, double to) {
        if (aircraftContainer.isEmpty()) {
            return new ArrayList<>();
        }
        return aircraftContainer.entrySet().stream()
                .filter(elem -> ((elem.getKey().getFuelConsumption() >= from)
                        && (elem.getKey().getFuelConsumption() <= to)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<T> getAllAirplanes() {
        if (aircraftContainer.isEmpty()) {
            return new ArrayList<>();
        }
        return aircraftContainer.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
