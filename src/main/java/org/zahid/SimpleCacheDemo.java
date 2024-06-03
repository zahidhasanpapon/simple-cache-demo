package org.zahid;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleCacheDemo {

    private static final Logger logger = Logger.getLogger(SimpleCacheDemo.class.getName());

    // Simulating a computationally expensive method
    public static int expensiveComputation(int input) {
        // Simulate a long computation
        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return input * input;
    }

    public static void main(String[] args) {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>();

        int input = 5;
        Integer result = retrieveFromCacheOrCompute(cache, input);
        logResult(input, result, "Initial check");

        // Try retrieving the same input again to see the cache in action
        result = retrieveFromCacheOrCompute(cache, input);
        logResult(input, result, "Second check");
    }

    private static Integer retrieveFromCacheOrCompute(SimpleCache<Integer, Integer> cache, int input) {
        Integer result;
        if (cache.containsKey(input)) {
            result = cache.get(input);
            logCacheHit(result);
        } else {
            result = expensiveComputation(input);
            cache.put(input, result);
            logCacheMiss(result);
        }
        return result;
    }

    private static void logCacheHit(Integer result) {
        logger.log(Level.INFO, "Cache hit! Result: {0}", result);
    }

    private static void logCacheMiss(Integer result) {
        logger.log(Level.INFO, "Cache miss! Computed and stored result: {0}", result);
    }

    private static void logResult(int input, Integer result, String checkDescription) {
        logger.log(Level.INFO, "{0} - Input: {1}, Result: {2}", new Object[]{checkDescription, input, result});
    }

}