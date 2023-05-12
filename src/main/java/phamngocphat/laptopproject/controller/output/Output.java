package phamngocphat.laptopproject.controller.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phamngocphat.laptopproject.dto.LaptopDTO;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Output {
    private int page;
    private int totalPage;
    private List<LaptopDTO> listResult = new ArrayList<>();
}
