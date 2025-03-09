package com.paultamayo.patterndesign.creational._01_builder;

import lombok.Builder;
import lombok.Data;

public interface ComputeBuilderWithLombok {

    @Builder
    @Data
    public static class Computer {

        private String cpu;

        private String ram;

        private String storage;

        private String gpu;
    }
}
