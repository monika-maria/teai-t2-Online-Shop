Kurs Spring Boot 2.0 - Tydzień 2

Treść zadania:
Zaimplementuj sklep internetowy, który oferuje 3 warianty. Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „START”. Umożliwia on dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę), oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów. Pakiet „PLUS” dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym. Pakiet „PRO” oprócz wyliczania podatku ma również możliwość wyliczenia rabatu, którego wartość jest uwzględniona w pliku konfiguracyjnym. Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) i wyświetla ich sumaryczną cenę.


Odpalanie profili aplikacji:
I - w application.properties podać start/plus/pro i uruchomić
II - w edycji konfiguracji obok zielonej strzałki wpisać "-Dspring.profiles.active=TU-PODAC"
III - przez paczkę jar 1 - "java -jar -/nazwa.jar" 2 - "--spring.profiles.active=TU-PODAC"