package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name=name;
        this.distance=0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void accel() {
        if(Randoms.pickNumberInRange(0, 9)>=4) {
            distance++;
            return;
        }
        if(distance>0) {
            distance--;
        }
    }



}
