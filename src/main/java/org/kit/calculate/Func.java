package org.kit.calculate;
@FunctionalInterface
interface Func<T, V> {
    T apply(T t1, T t2, V t3);
}
