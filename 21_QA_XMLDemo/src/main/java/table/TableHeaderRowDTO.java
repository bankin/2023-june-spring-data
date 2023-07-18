package table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class TableHeaderRowDTO {

    @XmlElement(name = "th")
    List<String> cells;

    public TableHeaderRowDTO() {}
}
