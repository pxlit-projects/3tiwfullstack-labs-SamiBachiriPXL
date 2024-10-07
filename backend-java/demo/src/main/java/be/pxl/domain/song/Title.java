package be.pxl.domain.song;

import be.pxl.domain.ValueObject;

public class Title implements ValueObject<Title> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Title(String title){
        if (title != null && !title.isEmpty()){
            Value = title;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Title) obj).Value);
    }
}
