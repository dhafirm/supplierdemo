package nz.co.dhafir.supplier.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public STATUS status = STATUS.SUCCESS;
    /**
     * s\Success message (optional)
     */
    public String message;
    private Object data;
    private List<ErrorInfo> errors = new ArrayList<>();

    public void addError(String code, String message) {
        errors.add(new ErrorInfo(code, message));
    }

     public static enum STATUS { SUCCESS, ERROR }

    @Getter
    @AllArgsConstructor
    private static class ErrorInfo {
        private String code;
        private String message;
    }
}
