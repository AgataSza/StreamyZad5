package streamy;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import streamy.model.Animal;
import streamy.model.Life;
import streamy.model.Plant;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamyTest {

    List<Life> model ;

    @BeforeClass
    public void setup (){
        Animal animal1 = new Animal("Gady", 4, false);
        Animal animal2 = new Animal("Gady", 0, true);
        Animal animal3 = new Animal("Ssaki", 4, false);
        Animal animal4 = new Animal("Ptaki", 2, false);
        Plant plant1 = new Plant("Lisciaste",1.5, "Jabłka");
        Plant plant2 = new Plant("Iglaste",2.5, "Szyszki");
        Plant plant3 = new Plant("Mieszane",1.8, "Owoce");
        model = Arrays.asList(
                new Life("Polska", Arrays.asList(animal1,animal3,animal4), List.of(plant3)),
                new Life("Niemcy", Arrays.asList(animal3, animal4), Arrays.asList(plant1, plant3)),
                new Life("Brazylia", List.of(animal2), Arrays.asList(plant2, plant3)),
                new Life("Brazylia", Arrays.asList(animal1, animal3), List.of(plant3))
        );
    }

    @Test
    public void zadanie5() {

/*        Stream<String> mappedStreamCountry = model.stream().map(Life::getCountry);
        List<String> mappedCountry = mappedStreamCountry.collect(Collectors.toList());
        System.out.println(mappedCountry);

        Collections.sort(mappedCountry);
        System.out.println(mappedCountry);*/

       Stream<String> mappedStreamCountry = model.stream().map(Life::getCountry).distinct().sorted();
       List<String> sortedByString = mappedStreamCountry.collect(Collectors.toList());
       System.out.println(sortedByString);
    }

    @Test
    public void zadanie6(){

        Stream<String> mappedStreamCountry = model.stream().map(Life::getCountry).distinct().sorted(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.substring(1, 2).compareTo(o2.substring(1, 2));
                    }
                }
        );
        List<String> sortedByString = mappedStreamCountry.collect(Collectors.toList());
        System.out.println(sortedByString);

    }

    @Test
    public void zadanie7(){

        Stream<Life> filteredStreamAnimal = model.stream().filter(
                e -> e.getAnimals().stream().anyMatch(Animal::isVenomous)
        );
        List<String> countries = filteredStreamAnimal.map(Life::getCountry).toList();
        System.out.println(countries);
    }

    @Test
    public void zadanie3(){

        Stream<Life> filteredLife = model.stream().filter(
                l ->l.getCountry().toLowerCase().startsWith("b")
        );
        Optional<Life> optionalLife = filteredLife.findFirst();
        Assert.assertTrue(optionalLife.isPresent());
        List<Plant> listPlant = optionalLife.get().getPlants();
        List<Plant> sortedList = listPlant.stream().sorted(
                (o2, o1) -> o1.getStandardHigh().compareTo(o2.getStandardHigh())
        ).toList();
        System.out.println(sortedList);
    }

    @Test
    public void podpowiedzDoZad1(){

        List<List<String>> podpowiedzK = List.of(
                List.of(""),
                List.of("")
        );
        System.out.println(podpowiedzK);
        String[] array = podpowiedzK.toString()/* cos jeszcze, zamiana [] na ()*/.split(",");

    }
}
