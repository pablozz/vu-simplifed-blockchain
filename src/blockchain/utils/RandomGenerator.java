package blockchain.utils;

public class RandomGenerator {

    public static int getRandomInt(double min, double max) {
        return (int) getRandomDouble(min, max);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
