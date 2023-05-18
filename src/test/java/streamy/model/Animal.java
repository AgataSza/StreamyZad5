package streamy.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Animal {


    private final String species;
    private final int numberOfLegs;
    private final boolean venomous;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Animal)) {
            return false;
        }

        Animal c = (Animal) o;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
