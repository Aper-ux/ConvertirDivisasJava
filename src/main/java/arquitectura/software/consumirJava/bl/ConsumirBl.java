package arquitectura.software.consumirJava.bl;

import java.math.BigDecimal;
import org.apache.log4j.Logger;

public class ConsumirBl {
    private static Logger logger = Logger.getLogger(Log4jRollingExample.class);

    /* Validar mayor a 0 */
    static public boolean validarMonto(BigDecimal amount){
        if(amount.signum() > 0){
            return true;
        }
        return false;
    }

    /* Preservar logger */
    public static void log() throws InterruptedException{
        for(int i = 0; i < 2000; i++) {
            logger.info(i + " ");
            Thread.sleep(100);
        }
    }
}