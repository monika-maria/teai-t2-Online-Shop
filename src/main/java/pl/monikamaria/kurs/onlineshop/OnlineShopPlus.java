package pl.monikamaria.kurs.onlineshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("plus")
//@ConfigurationProperties(prefix = "vat")
public class OnlineShopPlus extends OnlineShopStart {

    Logger logger = LoggerFactory.getLogger(OnlineShopPlus.class);

    protected BigDecimal sumPlusVat = BigDecimal.ZERO;

    @Value("${vat}")
    protected BigDecimal vat;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getLocalization(){
        logger.info("Wariant PLUS");
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getProducts() {
        super.getProducts();

        sumPlusVat = sum.multiply((vat.add(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100))));

        System.out.println("Suma z VAT(" + vat + "%): " + sumPlusVat.setScale(2, RoundingMode.CEILING) + "zł");
    }
}
