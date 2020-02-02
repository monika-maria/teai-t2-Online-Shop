package pl.monikamaria.kurs.onlineshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("pro")
public class OnlineShopPro extends OnlineShopPlus {

    Logger logger = LoggerFactory.getLogger(OnlineShopPro.class);

    @Value("${discount}")
    private BigDecimal discount;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getLocalization(){
        logger.info("Wariant PRO");
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void getProducts() {
        super.getProducts();

        BigDecimal hundred = BigDecimal.valueOf(100);
        BigDecimal sumWithDiscount = sumPlusVat.multiply((hundred.subtract(discount).divide(hundred)));

        System.out.println("Suma z VAT(" + vat + "%) i rabatem(" + discount + "%): " + sumWithDiscount.setScale(2, RoundingMode.CEILING) + "zł");
    }
}
