package practice.modernjava.functional.trainjourney;

import java.util.Objects;
import java.util.Optional;

public class TrainJourney {

    private int price;
    private String destination;
    private TrainJourney onward;

    public int getPrice() {
        return price;
    }

    public String getDestination() {
        return destination;
    }

    public TrainJourney getOnward() {
        return onward;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOnward(TrainJourney onward) {
        this.onward = onward;
    }

    public TrainJourney(int p, String n, TrainJourney t) {
        price = p;
        destination = n;
        onward = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("현재 목적지: " + this.getDestination());

        TrainJourney nextJourney = this.getOnward();
        while (!Objects.isNull(nextJourney)) {
            sb.append(", 그 다음 목적지: ")
                    .append(Optional.ofNullable(
                            this.onward).orElse(new TrainJourney(0, "없음", null)).getDestination());

            nextJourney = nextJourney.getOnward();
        }

        return sb.toString();
    }
}
