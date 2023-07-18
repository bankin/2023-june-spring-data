package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import softuni.exam.models.dto.CountryImportDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/files/json/countries.json");
        byte[] bytes = stream.readAllBytes();

        return new String(bytes);
    }

    @Override
    public String importCountries() throws IOException {
        List<String> result = new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        ModelMapper mapper = new ModelMapper();

        String json = this.readCountriesFromFile();

        CountryImportDTO[] countryImportDTOs = gson.fromJson(json, CountryImportDTO[].class);

        for (CountryImportDTO countryDTO : countryImportDTOs) {
            if (countryDTO.isValid()) {
                Optional<Country> exising =
                    countryRepository.findByCountryName(countryDTO.getCountryName());

                if (exising.isPresent()) {
                    result.add("Invalid Country");

                    continue;
                }

                Country country = mapper.map(countryDTO, Country.class);
                countryRepository.save(country);

                result.add(
                    String.format(
                        "Successfully imported country %s - %s", country.getCountryName(), country.getCurrency()));
            } else {
                result.add("Invalid country");
            }
        }

        return String.join("\n", result);
    }
}
