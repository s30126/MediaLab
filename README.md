Krótki opis klas:
Klasa Main tworzy menu i opisuje jego działanie, tworzy przykładowe dane startowe (studentów i sprzęt) i inicjalizuje potrzebne ArrayListy oraz tworzy instancję klasy ReservationService.
Klasa Student przechowuje dane studentów w systemie.
Klasa Equipment jest abstrakcyjną klasą i posiada pola, które dziedziczone są przez bardziej szczegółowe klasy opisujące konkretne rodzaje sprzętu.
Klasa LaptopSet opisuje konkretny rodzaj sprzętu (zestaw laptopowy), a więc dziedziczy po klasie Equipment, ale zawiera też unikatowe pola/cechy.
Klasa CameraKit też opisuje konkretny rodzaj sprzętu (zestaw kamerowy) i działa podobnie jak klasa LaptopSet (tylko że posiada inne pola).
Klasa Reservation łączy studentów z wypożyczonym przez nich sprzętem, a także mówi, jak policzyć pełny koszt rezerwacji.
Klasa ReservationService zawiera główną logikę programu i większość metod, które opisują jego działanie. Mówi na przykład, w jaki sposób przebiega tworzenie nowej rezerwacji, zwrot sprzętu itp.

Krótki opis użytych interfejsów:
Displayable jest zaimplementowany w Equipment (a ponieważ LaptopSet i CameraKit dziedziczą po klasie Equipment, także implementują ten interfejs) oraz w Reservation, jest odpowiednio nadpisany w zależności od klasy, ale w każdej  nich służy do wypisania informacji o obiektach.
DiscountPolicy jest zaimplementowany i nadpisany w LoyaltyDiscountPolicy, użyty jest do naliczenia zniżki w sytuacji, gdy student ma 100 lub więcej punktów lojalnościowych.

Sytuacja, w której działa polimorfizm:
Przy wywołaniu metody, która działa na ArrayLiście equipment (np.

for (Equipment e : myService.getEquipment()) {
                        System.out.println(e.getDisplayText());
                    }
                    
program automatycznie wybiera i implementuje metodę z właściwej klasy (LaptopSet bądż CameraKit) w celu wywołania metody getDisplayText.



Zrzuty ekranu pokazujące utworzenie i zwrot rezerwacji:
<img width="1113" height="858" alt="Zrzut ekranu 2026-06-09 204926" src="https://github.com/user-attachments/assets/80b2a49b-bbf4-4b5e-bcc0-5d30d7f003aa" />
<img width="1185" height="735" alt="Zrzut ekranu 2026-06-09 204958" src="https://github.com/user-attachments/assets/e627e804-ee86-4443-9c5e-f9f860173fed" />

