package demo.jsb2.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GlobalErrorDTO {
    private String messageRaw;
    private String messageCode;
    private String status;
    private int statusCode;
    private String date;
}
