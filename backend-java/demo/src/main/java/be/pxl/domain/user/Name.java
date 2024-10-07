package be.pxl.domain.user;

import be.pxl.domain.ValueObject;

public class Name implements ValueObject<Name> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Name(String name){
        if (name != null && !name.isEmpty()){
            Value = name;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Name) obj).Value);
    }
}
