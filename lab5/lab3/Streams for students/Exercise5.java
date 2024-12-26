



import java.util.Objects;
import java.util.Optional;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
       //write your answer here 

       City maxPopulationCapitalCity = countryDao
       .findAllCountries()
       .stream()
       .map(country -> country.getCapital())
       .map(cityId -> cityDao.findCityById(cityId))
       .filter(city -> city != null)
       .max(Comparator.comparing(City::getPopulation))
       .get();

System.out.println(maxPopulationCapitalCity);


   



      
    }

}