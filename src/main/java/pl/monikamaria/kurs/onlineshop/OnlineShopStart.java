package pl.monikamaria.kurs.onlineshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("start")
public class OnlineShopStart {

    Logger logger = LoggerFactory.getLogger(OnlineShopStart.class);
    protected List<Product> products = new ArrayList<>();
    protected BigDecimal sum = BigDecimal.ZERO;

    public OnlineShopStart() {
        products.add(new Product("Podkład", generatePrice()));
        products.add(new Product("Szminka", generatePrice()));
        products.add(new Product("Korektor", generatePrice()));
        products.add(new Product("Rozświetlacz", generatePrice()));
        products.add(new Product("Tusz", generatePrice()));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getLocalization(){
        logger.info("Wariant START");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getProducts() {
        System.out.println("Produkty w koszyku:");
        products.forEach(System.out::println);
        products.forEach(product -> sum = sum.add(product.getPrice()));
        System.out.println("Suma: " + sum + "zł");
    }

    private BigDecimal generatePrice(){
        return new BigDecimal(new Random().nextInt(250) + 50);
    }
}
