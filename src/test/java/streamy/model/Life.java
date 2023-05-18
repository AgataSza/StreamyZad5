package streamy.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Life {

    private final String country;
    private final List<Animal> animals;
    private final List<Plant> plants;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Life)) {
            return false;
        }

        Life c = (Life) o;
        return this.toString().equals(c.toString());
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}