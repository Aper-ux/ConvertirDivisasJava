package arquitectura.software.consumirJava.dto;

public class ResponseServiceDto {
    private String success;

    /* Constructor vacio */
    public ResponseServiceDto() {
    }
    
    /* Constructor */
    public ResponseServiceDto(String success) {
        this.success = success;
    }

    /* Getters and Setters */
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
}
