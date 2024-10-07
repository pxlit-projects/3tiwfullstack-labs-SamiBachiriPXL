package be.pxl.Core;

import be.pxl.domain.ValueObject;

import java.util.Objects;

public abstract class Identity implements ValueObject {
    private long key;

    protected Identity(long key) {
        if (key == 0L) {
            throw new IllegalArgumentException("Key can't be empty");
        }
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Identity identity = (Identity) obj;
        return key == identity.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
