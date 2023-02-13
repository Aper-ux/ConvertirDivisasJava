package arquitectura.software.consumirJava.api;

import java.io.*;
import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import arquitectura.software.consumirJava.bl.ConsumirBl;
import arquitectura.software.consumirJava.dto.RequestServiceDto;
/* import arquitectura.software.consumirJava.dto.ResponseServiceDto; */

/* import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate; */

@RestController
public class ConsumirApi {

    @RequestMapping("/")
    public String Consumir() throws IOException, InterruptedException{
        /* api key IIoQmQdG2JPE4C7Ato3tjPhLHBMeKlWe */
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        /* create an object type requestServiceDto */
        RequestServiceDto requestServiceDto = new RequestServiceDto();
        requestServiceDto.setAmount(BigDecimal.valueOf(100));
        requestServiceDto.setFrom("USD");
        requestServiceDto.setTo("BOB");
        
        /* Validar mayor a 0 */
        if(requestServiceDto.getAmount().signum() > 0){
            /* Consumir el servicio */
            Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+requestServiceDto.getTo()+"&from="+requestServiceDto.getFrom()+"&amount="+requestServiceDto.getAmount())
                .addHeader("apikey", "IIoQmQdG2JPE4C7Ato3tjPhLHBMeKlWe")
                .method("GET", null)
                .build();

            Response response = client.newCall(request).execute();
            
            System.out.println(response.body().string());

            /* call log fron ConsumirBl class */
            ConsumirBl.log();

        }else{
            System.out.println("El monto debe ser mayor a 0");
        }

        return "Success";
    }

    @RequestMapping("/sym")
    public String Sym() throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/symbols")
            .addHeader("apikey", "IIoQmQdG2JPE4C7Ato3tjPhLHBMeKlWe")
            .method("GET", null)
            .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        return "Symbols";
    }
}