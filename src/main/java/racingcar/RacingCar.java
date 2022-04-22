package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCar {

    public void run() {
        RacingCarView view = new RacingCarView();
        String[] names = view.getName();
        Car[] cars = new Car[names.length];

        int move = view.getMove();

        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        for (int i = 0; i < move; i++) {
            moveCars(cars, view);
        }
        view.printWinner(cars);
    }

    public void moveCars(Car[] cars, RacingCarView view) {
        for(int i=0;i<cars.length;i++) {
            cars[i].accel();
            view.printDistance(cars[i]);
        }
        System.out.println();
    }
}
