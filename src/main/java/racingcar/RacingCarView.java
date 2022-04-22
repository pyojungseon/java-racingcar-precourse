package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public int getMove() {
        return Integer.valueOf(Console.readLine());
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

    public void printWinner(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        int max=cars[0].getDistance();
        for(int i=0;i<cars.length;i++) {
            max = checkMaxDistance(cars[i], max, sb);
        }
        if(sb.charAt(sb.length()-1)==',') {
            sb.setLength(sb.length()-1);
        }
        System.out.println("최종 우승자는 "+sb.toString()+" 입니다.");
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

    public void printDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<car.getDistance();i++) {
            sb.append("-");
        }
        System.out.println(car.getName()+" : "+sb.toString());
    }

}
