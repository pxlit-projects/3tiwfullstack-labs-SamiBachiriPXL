package be.pxl.domain.song;

import be.pxl.domain.ValueObject;

public class Album implements ValueObject<Album> {
    private String Value;

    public String getValue() {
        return Value;
    }

    public Album(String album){
        if (album != null && !album.isEmpty()){
            Value = album;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Value.equals(((Album) obj).Value);
    }

}
