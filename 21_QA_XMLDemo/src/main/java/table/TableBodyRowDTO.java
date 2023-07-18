package table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class TableBodyRowDTO {

    @XmlElement(name = "td")
    private List<String> cells;

    public TableBodyRowDTO() {}
}
