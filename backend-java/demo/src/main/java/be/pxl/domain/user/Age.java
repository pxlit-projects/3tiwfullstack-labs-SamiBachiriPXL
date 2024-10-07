package be.pxl.domain.user;

import be.pxl.domain.ValueObject;

public class Age implements ValueObject<Age> {
    private int Value;

    public int getValue() {
        return Value;
    }

    public Age(int age){
        if (age > 0){
            Value = age;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value == ((Age) obj).Value;
    }

}
