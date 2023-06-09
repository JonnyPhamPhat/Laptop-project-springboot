package phamngocphat.laptopproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AbstractDTO<T> {
    private Long id;
    private List<T> listResult = new ArrayList<>();
}
