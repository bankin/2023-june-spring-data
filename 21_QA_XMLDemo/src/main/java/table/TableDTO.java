package table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class TableDTO {

    @XmlElement(name = "thead")
    private TableHeaderDTO header;

    @XmlElementWrapper(name = "tbody")
    @XmlElement(name = "tr")
    private List<TableBodyRowDTO> rows;

    public TableDTO() {}
}
