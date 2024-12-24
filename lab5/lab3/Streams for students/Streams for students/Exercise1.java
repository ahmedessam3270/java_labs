

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




public class Exercise1 {

   public static void main(String[] args) {
      CountryDao countryDao= InMemoryWorldDao.getInstance();
      //write your answer here
      countryDao.findAllCountries().stream().forEach(country -> {
        Optional<City> highestPopulatedCity = country.getCities().stream().max(Comparator.comparingInt(City::getPopulation));

        if(highestPopulatedCity.isPresent()){
         System.out.println("Iam in Country: " + country.getName() + " It's most crowded City is " +highestPopulatedCity.get().getName() + " having " + highestPopulatedCity.get().getPopulation() + " people");
        }

      });
   }

}