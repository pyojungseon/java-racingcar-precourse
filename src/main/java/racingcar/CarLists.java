package racingcar;

import java.util.List;

public class CarLists {

    private List<Car> cars = null;

    public CarLists(List<Car> cars) {
        this.cars=cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
