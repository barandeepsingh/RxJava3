package com.sample.baran.continuous.stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSourceService {

    public static List<Integer> getStream(){
        Random random = new Random();
        return IntStream.range(1, random.nextInt(100)).boxed().collect(Collectors.toList());
    }
}
