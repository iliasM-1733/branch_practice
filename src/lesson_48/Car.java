package lesson_48;

public class Car {
    private String modelName;
    private int year;
    private double millage;
    private Engine engine;
    // ...

    public Car(String modelName, int year) {
        this.modelName = modelName;
        this.year = year;
        this.millage = 0;
        this.engine = new Engine(100, EngineType.DIESEL, "");


    }

    // getters and setters

    // some logic

    private class Engine {
        private int power;
        private EngineType type;
        private String engineType;

        public Engine(int power, EngineType type, String engineType) {
            this.power = power;
            this.type = type;
            this.engineType = engineType;
        }
    }

    private enum EngineType {
        DIESEL,
        ELECTRO,
        PETROLIUM,
        HYBRID,
        HYDROGEN;
    }
}
