package racingcar;

import java.util.List;

public class CarLists {

    private final List<Car> cars;

    public CarLists(List<Car> cars) {
        this.cars=cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
