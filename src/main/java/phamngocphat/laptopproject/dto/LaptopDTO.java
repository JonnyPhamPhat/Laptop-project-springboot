package phamngocphat.laptopproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LaptopDTO extends AbstractDTO{
    private String name;
    private String drive;
    private String screen;
    private String card;
    private String operatingSystem;
    private String size;
    private String brandCode;
}
