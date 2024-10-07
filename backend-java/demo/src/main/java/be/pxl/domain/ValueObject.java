package be.pxl.domain;

public interface ValueObject<T> {

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
