import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.util.List;

public class MarshallMain {

    public static void main(String[] args) throws JAXBException {
        AddressDTO addressDTO = new AddressDTO(10000, "BG", "Sofia");
        JAXBContext jaxbContext = JAXBContext.newInstance(AddressDTO.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(addressDTO, System.out);

        JAXBContext jaxbListContext = JAXBContext.newInstance(AddressesDTO.class);

        Marshaller listMarshaller = jaxbListContext.createMarshaller();
        listMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        AddressDTO mainAddress = new AddressDTO(1231321, "Country", "City");
        AddressesDTO addressesDTO = new AddressesDTO(List.of(addressDTO, addressDTO), mainAddress);
        listMarshaller.marshal(addressesDTO, System.out);
    }
}
