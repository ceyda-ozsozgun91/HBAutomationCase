Feature: Hepsiburada Case
  Scenario: Login kullanici Petshop urunlerinden birini sepete ekleyebilir ve sepetinden silebilir
    Given  Valid kullanici ile login olunur
    And Yurtdisindan Petshop kategorisine gider
    And Kullanici kategorideki bir urunu sepetine ekler
    And Kullanici sepetine gider
    Then kullanici sepetindeki ürünü ve fiyatini kontrol eder
    And kullanici sepetindeki urun sayisini bir artirir ve bilgileri kontrol eder
    And kullanici sepetindeki urunu siler ve bilgileri kontrol eder

  Scenario: Login olmayan kullanici Petshop urunlerinden birini sepete ekleyebilir ve sepetinden silebilir
    Given  Kullanici login olmadan Yurtdisindan Petshop kategorisine gider
    And Kullanici kategorideki bir urunu sepetine ekler
    And Kullanici sepetine gider
    Then kullanici sepetindeki ürünü ve fiyatini kontrol eder
    And kullanici sepetindeki urun sayisini bir artirir ve bilgileri kontrol eder
    And kullanici sepetindeki urunu siler ve bilgileri kontrol eder
