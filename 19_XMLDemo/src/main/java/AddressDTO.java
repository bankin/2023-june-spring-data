import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDTO implements Serializable {

    @XmlAttribute
    private int population;

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "city")
    private String city;

    public AddressDTO() {}

    public AddressDTO(int population, String country, String city) {
        this.population = population;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "population=" + population +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
