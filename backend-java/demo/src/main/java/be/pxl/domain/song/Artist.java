package be.pxl.domain.song;

import be.pxl.domain.ValueObject;

public class Artist implements ValueObject<Artist> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Artist(String artist){
        if (artist != null && !artist.isEmpty()){
            Value = artist;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Artist) obj).Value);
    }

}
