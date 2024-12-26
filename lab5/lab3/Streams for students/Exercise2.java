

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Exercise2 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        //      write your answer here
        
      List<City> mostPopulatedCityInContinent =   countryDao.getAllContinents().stream()
            .map(continentName -> countryDao.findCountriesByContinent(continentName).stream()
                .map(continent -> continent.getCities())
                .map(cityInCountry -> cityInCountry.stream().max(Comparator.comparingInt(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(maxCityInCountry -> maxCityInCountry.get()))
                .map(cityInContinent -> cityInContinent.collect(Collectors.toList()))
                .map(maxCityInContinent -> maxCityInContinent.stream().max(Comparator.comparingInt(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(maxCityInCountry -> maxCityInCountry.get())
                .collect(Collectors.toList());


                mostPopulatedCityInContinent.forEach(city-> System.out.println(city));
                


    }

}
