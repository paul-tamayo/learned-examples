package com.paultamayo.patterndesign.creational._01;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ComputerBuilderTest {

    @Test
    void testBuild() {
        Computer computer = ComputerBuilder.builder()
                .cpu("Intel i7")
                .ram("16GB")
                .storage("1TB")
                .gpu("Nvidia RTX 2080")
                .build();

        assertNotNull(computer);
    }

    @Test
    void testBuildWithLombok() {
        ComputeBuilderWithLombok.Computer computer = ComputeBuilderWithLombok.Computer.builder()
                .cpu("Intel i7")
                .ram("16GB")
                .storage("1TB")
                .gpu("Nvidia RTX 2080")
                .build();

        assertNotNull(computer);
    }
}
