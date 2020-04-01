package racinggame.domain.racing;

import racinggame.domain.car.Car;
import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 레이싱을 진행하는 car들의 collection
 * 1. 모든 자동차를 이동
 */
public class RacingCars {

    private static final int RANDOM_BOUND = 10;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public static RacingCars newRacingCarsFrom(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public RacingCars moveCarAll() {
        List<Car> cars = this.cars.stream()
                .map(car -> car.moveCar(NumberUtil.createRandomInt(RANDOM_BOUND)))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    private int getMaxMoveRange() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .filter(car -> car >= 0)
                .max()
                .orElse(0);
    }

    public List<String> findWinner() {
        int range = getMaxMoveRange();
        return cars.stream()
                .filter(car -> car.isMovedFarThan(range))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }
}
