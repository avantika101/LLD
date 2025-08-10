package caseStudies.carBookingSystem.strategies.CabMatchingStrategy;

public class Pair<T, T1> {
    T key;
    T1 val;

    public Pair(T t, T1 t1){
        this.key = t;
        this.val = t1;
    }

    public T getKey() {
        return key;
    }

    public T1 getVal() {
        return val;
    }
}
