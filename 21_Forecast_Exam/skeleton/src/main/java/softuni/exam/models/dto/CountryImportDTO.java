package softuni.exam.models.dto;

import java.io.Serializable;

public class CountryImportDTO implements Serializable {
    private String countryName;
    private String currency;


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isValid() {
        if (countryName.length() < 2 || countryName.length() > 60) {
            return false;
        }

        if (currency.length() < 2 || currency.length() > 20) {
            return false;
        }

        return true;
    }
}
