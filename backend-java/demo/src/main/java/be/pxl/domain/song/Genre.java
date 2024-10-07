package be.pxl.domain.song;

import be.pxl.domain.ValueObject;

public class Genre implements ValueObject<Genre> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Genre(String genre){
        if (genre != null && !genre.isEmpty()){
            Value = genre;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Genre) obj).Value);
    }

}
