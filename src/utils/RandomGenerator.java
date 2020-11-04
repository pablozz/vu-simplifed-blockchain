package utils;

public class RandomGenerator {

    public int getRandomInt(double min, double max) {
        return (int) getRandomDouble(min, max);
    }

    public double getRandomDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
