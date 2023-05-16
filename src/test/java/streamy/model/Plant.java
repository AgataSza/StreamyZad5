package streamy.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Plant {

    private final String species;
    private final Double standardHigh;
    private final String fruitName;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Plant)) {
            return false;
        }

        Plant c = (Plant) o;
        return this.toString().equals(c.toString());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
