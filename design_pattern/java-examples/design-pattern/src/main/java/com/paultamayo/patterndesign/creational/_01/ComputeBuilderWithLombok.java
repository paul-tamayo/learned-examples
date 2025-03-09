package com.paultamayo.patterndesign.creational._01;

import lombok.Builder;
import lombok.Data;

public class ComputeBuilderWithLombok {

    @Builder
    @Data
    public static class Computer {

        private String cpu;

        private String ram;

        private String storage;

        private String gpu;
    }
}
