package HW3_ElevatorSimulator;

public class BooleanSource {

    private double probability;

    public BooleanSource(double p) throws IllegalArgumentException {

        if (p < 0.0 || p > 1.0)

            throw new IllegalArgumentException();

        probability = p;

    }

    public boolean requestArrived() {

        return (Math.random() < probability);

    }

}

