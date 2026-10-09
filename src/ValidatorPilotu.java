import java.util.regex.Pattern;

public class ValidatorPilotu {

    // Regulární výrazy pro jednotlivá pole
    private Pattern patternKodPilota = Pattern.compile("^[A-Z]{3}[0-9]{3}$");
    private Pattern patternPlaneta = Pattern.compile("^(Země|Mars|Venuše|Titan|Krypton)$");
    private Pattern patternRokNarozeni = Pattern.compile("^(19\\d{2}|20[01]\\d|202[0-6])$");
    Pattern patternTypLodi = Pattern.compile("^(Stíhač|Transportér|Explorer|Bitevník)$");
    private Pattern patternPocetVyher = Pattern.compile("^(1000|[0-9]\\d{0,2})$");

    boolean jePlatnyRadek(String radek) {
        if (radek == null || radek.trim().isEmpty()) {
            System.out.println("Chyba: Prázdný řádek!");
            return false;
        }

        // Parametr -1 zajistí, že split nevymaže prázdné hodnoty na konci řádku
        String[] udaje = radek.split(";", -1);

        if (udaje.length != 5) {
            System.out.println("Chyba: Špatný počet údajů (očakáváno 5, nalezeno " + udaje.length + ")");
            return false;
        }

        boolean jeVseOk = true;

        String kodPilota = udaje[0].trim();
        String planeta = udaje[1].trim();
        String rokNarozeni = udaje[2].trim();
        String typLodi = udaje[3].trim();
        String pocetVyher = udaje[4].trim();

        if (!patternKodPilota.matcher(kodPilota).matches()) {
            System.out.println("Neplatný kód pilota: " + kodPilota);
            jeVseOk = false;
        }

        if (!patternPlaneta.matcher(planeta).matches()) {
            System.out.println("Neplatná planeta: " + planeta);
            jeVseOk = false;
        }

        if (!patternRokNarozeni.matcher(rokNarozeni).matches()) {
            System.out.println("Neplatný rok narozeni: " + rokNarozeni);
            jeVseOk = false;
        }

        if (!patternTypLodi.matcher(typLodi).matches()) {
            System.out.println("Neplatný typ lodi: " + typLodi);
            jeVseOk = false;
        }

        if (!patternPocetVyher.matcher(pocetVyher).matches()) {
            System.out.println("Neplatný počet výher: " + pocetVyher);
            jeVseOk = false;
        }

        return jeVseOk;
    }
}
