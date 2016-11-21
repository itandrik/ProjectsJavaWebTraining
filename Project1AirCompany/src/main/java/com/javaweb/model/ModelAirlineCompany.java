package com.javaweb.model;

import com.javaweb.model.entity.Aircraft;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ModelAirlineCompany.java
 * <p>
 * Class that defines collection for all objects, that
 * extends {@link Aircraft}. It is using for all tasks from
 * the variant 9. Also here are some additional methods for
 * deleting and adding airplanes to the container.
 * Container - is TreeMap. It is used, because of easy filtering.
 * Key - object with aircraft, value - quantity of such airplanes
 * in the airline company.
 *
 * @author Andrii Chernysh
 * @version 1.0, 18 Nov 2016
 */
public class ModelAirlineCompany<T extends Aircraft> {
    /**
     * Container for Aircrafts
     */
    private Map<T, Integer> aircraftContainer;

    /**
     * Constructor of our airline company.
     * Here are comparator for initial sorting
     * by range of flight.
     */
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

    /**
     * Adding some airplane to airline company.
     * If there will be two equal airplanes, value of
     * entry set will increase.
     *
     * @param aircraft instance of some airplane
     */
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
    }

    /**
     * Removing some airplane from airline company.
     * If there will be two equal airplanes, value of
     * entry set will decrease.
     *
     * @param aircraft instance of some airplane
     * @return has been removed or not
     */
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

    /**
     * Checking is our airline company is empty
     *
     * @return boolean value of emptiness
     */
    public boolean isEmpty() {
        return aircraftContainer.isEmpty();
    }

    /**
     * Task from variant #9. Getting summary passenger capacity in the
     * airline company.
     *
     * @return overall passenger capacity in the airline company
     */
    public long getOverallPassengerCapacity() {
        Objects.requireNonNull(aircraftContainer);

        return aircraftContainer.entrySet().stream()
                .mapToLong(elem -> elem.getKey().getPassengerCapacity())
                .sum();
    }

    /**
     * Task from variant #9. Getting summary carrying capacity in the
     * airline company.
     *
     * @return overall carrying capacity in the airline company
     */
    public double getOverallCarryingCapacity() {
        if (aircraftContainer.isEmpty()) {
            return 0;
        }
        return aircraftContainer.entrySet().stream()
                .mapToDouble(elem -> elem.getKey().getCarryingCapacity())
                .sum();
    }

    /**
     * Task from variant #9. Getting list of airplanes, which has
     * some special diapason of fuel consumption(between from and to)
     *
     * @param from low bound of fuel consumption
     * @param to   high bound of fuel consumption
     * @return list of airplanes with special fuel consumption
     */
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

    /**
     * @return list with all airplanes in the airline company
     */
    public List<T> getAllAirplanes() {
        if (aircraftContainer.isEmpty()) {
            return new ArrayList<>();
        }
        return aircraftContainer.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
