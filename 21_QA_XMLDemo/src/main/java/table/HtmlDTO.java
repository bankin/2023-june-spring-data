package table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "html")
@XmlAccessorType(XmlAccessType.FIELD)
public class HtmlDTO {

    @XmlElement(name = "table")
    private TableDTO table;

    public HtmlDTO() {}
}
