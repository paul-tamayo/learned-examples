package com.paultamayo.patterndesign.creational._01_builder;

import lombok.Builder;

public interface ComputeBuilderWithLombok {

    @Builder
    public record Computer(String cpu, String ram, String storage, String gpu) {
    }
}
