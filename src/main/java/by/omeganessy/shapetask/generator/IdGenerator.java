package by.omeganessy.shapetask.generator;

public class IdGenerator {
    private static int counterId = 0;

    private IdGenerator() {
    }

    public static int getId() {
        return counterId++;
    }
}
