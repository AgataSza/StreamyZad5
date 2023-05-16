package streamy;

import org.testng.annotations.Test;
import streamy.model.Life;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamyTest {

    @Test
    public void zadanie5() {
        List<Life> model = Arrays.asList(
                new Life("Polska", Arrays.asList("Lis", "Wąż", "Sikorka"), Arrays.asList("Dąb", "Paprotka")),
                new Life("Niemcy", Arrays.asList("Kruk", "Pies", "Zaba"), Arrays.asList("Sosna", "Tulipan")),
                new Life("Brazylia", Arrays.asList("Sokol", "Krowa", "Dzik"), Arrays.asList("Jesion", "Marchew")),
                new Life("Brazylia", Arrays.asList("Wydra", "Papuga", "Dzik"), Arrays.asList("Marchew", "Dąb"))
        );

        Stream<String> mappedStreamCountry = model.stream().map(Life::getCountry);
        List<String> mappedCountry = mappedStreamCountry.collect(Collectors.toList());
        System.out.println(mappedCountry);

        Collections.sort(mappedCountry);
        System.out.println(mappedCountry);

//       Stream<Life> sortedByStringStream = model.stream().sorted(Comparator.comparing(Life::getCountry));
//       List<Life> sortedByString = sortedByStringStream.collect(Collectors.toList());
//       System.out.println(sortedByString);
    }

    @Test
    public void zadanie7(){
        List<Life> model = Arrays.asList(
                new Life("Polska", Arrays.asList("Lis", "Wąż", "Sikorka"), Arrays.asList("Dąb", "Paprotka")),
                new Life("Niemcy", Arrays.asList("Kruk", "Pies", "Zaba"), Arrays.asList("Sosna", "Tulipan")),
                new Life("Brazylia", Arrays.asList("Sokol", "Krowa", "Dzik"), Arrays.asList("Jesion", "Marchew")),
                new Life("Brazylia", Arrays.asList("Wydra", "Papuga", "Dzik"), Arrays.asList("Marchew", "Dąb"))
        );

        Stream<Life> filteredStreamAnimal = model.stream().filter(e -> e.getAnimals().contains("Wąż"));
        List<Life> filteredAnimal = filteredStreamAnimal.collect(Collectors.toList());
        System.out.println(filteredAnimal);
    }
}
