package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCar {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public void run() {
        String[] names = getName();
        Car[] cars = new Car[names.length];

        int move = Integer.valueOf(Console.readLine());

        for(int i=0;i<names.length;i++) {
            cars[i] = new Car(names[i]);
        }
        for(int i=0;i<move;i++) {
            moveCars(cars);
        }
        System.out.println(winner(cars));
    }

    public String[] getName() {
        String carNames = Console.readLine();
        String[] names = carNames.split(",");
        try {
            validateName(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getName();
        }
        return names;
    }

    public boolean validateName(String[] names) {
        for(int i=0;i<names.length;i++) {
            isNotNameEmpty(names[i]);
            isNotNameLengthOver(names[i]);
        }
        return true;
    }

    public boolean isNotNameEmpty(String name) {
        if(name==null || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public boolean isNotNameLengthOver(String name) {
        if(name.length()>5) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public void moveCars(Car[] cars) {
        for(int i=0;i<cars.length;i++) {
            cars[i].accel();
            cars[i].printDistance();
        }
        System.out.println();
    }

    public String winner(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        int max=cars[0].getDistance();
        for(int i=0;i<cars.length;i++) {
            max = checkMaxDistance(cars[i], max, sb);
        }
        if(sb.charAt(sb.length()-1)==',') {
            sb.setLength(sb.length()-1);
        }
        return "최종 우승자는 "+sb.toString()+" 입니다.";
    }

    public int checkMaxDistance(Car car, int max, StringBuilder sb) {
        if(car.getDistance()>max) {
            max = car.getDistance();
            sb.setLength(0);
            sb.append(car.getName()+",");
        } else if(car.getDistance()==max) {
            sb.append(car.getName()+",");
        }
        return max;
    }
}
