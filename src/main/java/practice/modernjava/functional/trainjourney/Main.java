package practice.modernjava.functional.trainjourney;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        TrainJourney journeyOne = new TrainJourney(1200, "서울대입구",
                null);

        TrainJourney journeyTwo = new TrainJourney(1250, "선릉역",
                null);

        TrainJourney journeyThree = new TrainJourney(0, "회사",
                null);

        // append를 사용하면 journeyOne이 변하지 않지만 link를 사용하면 jonryOne이 변한다.
        System.out.println(journeyOne);
        System.out.println(append(append(journeyOne, journeyTwo), journeyThree));
        System.out.println(journeyOne);
        System.out.println(link(journeyOne, journeyTwo));
        System.out.println(journeyOne);
    }

    static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (Objects.isNull(a)) {
            return b;
        } else {
            TrainJourney t = a;
            while (Objects.nonNull(t.getOnward())) {
                t = t.getOnward();
            }
            t.setOnward(b);
            return a;
        }
    }

    static TrainJourney append(TrainJourney a, TrainJourney b) {
        return Objects.isNull(a) ? b
                : new TrainJourney(a.getPrice() + b.getPrice(), a.getDestination(),
                        append(a.getOnward(), b));
    }
}
