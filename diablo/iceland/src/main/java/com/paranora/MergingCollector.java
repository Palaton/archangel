package com.paranora;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;

/**
 * Created by yangqun on 2017/06/23.
 */
public interface MergingCollector<T, A, R> extends Collector<T, A, R> {
    /**
     * A function that merges the second partial result into the first partial
     * result.
     *
     * @return a function that merges the second partial result into the first
     *         partial result.
     */
    BiConsumer<A, A> merger();

    /**
     * A function that accepts two partial results and combines them returning
     * either existing partial result or new one.
     *
     * The default implementation calls the {@link #merger()} and returns the
     * first partial result.
     *
     * @return a function which combines two partial results into a combined
     *         result
     */
    @Override
    default BinaryOperator<A> combiner() {
        BiConsumer<A, A> merger = merger();
        return (a, b) -> {
            merger.accept(a, b);
            return a;
        };
    }
}