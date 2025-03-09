package com.paultamayo.patterndesign.creational._01;

public class ComputerBuilder {

    private Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public ComputerBuilder cpu(String cpu) {
        computer.setCpu(cpu);

        return this;
    }

    public ComputerBuilder ram(String ram) {
        computer.setRam(ram);

        return this;
    }

    public ComputerBuilder storage(String storage) {
        computer.setStorage(storage);

        return this;
    }

    public ComputerBuilder gpu(String gpu) {
        computer.setGpu(gpu);

        return this;
    }

    public Computer build() {
        return computer;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }
}
