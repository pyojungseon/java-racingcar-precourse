package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public void run() {
        RacingCarView view = new RacingCarView();
        String[] names = view.getName();
        List<Car> cars = new ArrayList<>();
        //Car[] cars = new Car[names.length];

        int move = view.getMove();

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        for (int i = 0; i < move; i++) {
            moveCars(cars, view);
        }
        view.printWinner(cars);
    }

    public void moveCars(List<Car> cars, RacingCarView view) {
        for(int i=0;i<cars.size();i++) {
            cars.get(i).accel();
            view.printDistance(cars.get(i));
        }
        System.out.println();
    }
}
