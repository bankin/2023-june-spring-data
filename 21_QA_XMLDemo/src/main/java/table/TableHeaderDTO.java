package table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TableHeaderDTO {

    @XmlElement(name = "tr")
    TableHeaderRowDTO row;

    public TableHeaderDTO() {}
}
