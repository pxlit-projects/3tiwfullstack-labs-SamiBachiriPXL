package be.pxl.domain.user;

import be.pxl.domain.ValueObject;

public class Email implements ValueObject<Email> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Email(String email){
        if (email.contains("@") && email.contains(".")){
            Value = email;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Email) obj).Value);
    }

}
