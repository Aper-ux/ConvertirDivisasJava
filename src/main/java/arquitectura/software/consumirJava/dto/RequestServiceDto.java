package arquitectura.software.consumirJava.dto;

import java.math.BigDecimal;

public class RequestServiceDto {
    private BigDecimal amount;
    private String from;
    private String to;

    /* Constructor vacio */
    public RequestServiceDto() {
    }

    /* Constructor */
    public RequestServiceDto(BigDecimal amount, String from, String to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    /* Getters and Setters */
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
}