void main() {
    ValidatorPilotu val =  new ValidatorPilotu();
    List<Pilot> piloti = new ArrayList<>();
    Path objednavky = Path.of("data", "trenink_piloti_testovaci_data.txt");

    try {
        try (BufferedReader objednavkyReader = Files.newBufferedReader(objednavky))
        {
            String[] radkyPilotu = objednavkyReader.lines().toArray(String[]::new);
            for (int i = 0; i< radkyPilotu.length; i++) {

                if (val.jePlatnyRadek(radkyPilotu[i])){
                    System.out.println("===== VALIDNI RADEN: "+i+" ["+ radkyPilotu[i]+"]=====");
                    String[] radka = radkyPilotu[i].split(";");
                    piloti.add(new Pilot(radka[0],radka[1],Integer.parseInt(radka[2]),radka[3],Integer.parseInt(radka[4])));
                    System.out.println("Radek nacten do objektu.\n");

                }else{
                    System.out.println("===== NEVALIDNI RADEN: "+i+" ["+ radkyPilotu[i]+"]=====\n");
                }


            }
        }
    } catch (IOException e) {
        System.out.println("Chyba při čtení souboru:");
        e.printStackTrace();
    }
    System.out.println("\nPiloti nad 50 let:");
    for (Pilot p : piloti) {
        if ((2026 - p.getRokNarozeni()) > 50){
            System.out.println(p);
        }
    }
    System.out.println("\nPilot s nejvice vyhrami:");
    Pilot pl = piloti.get(0);
    for (Pilot p : piloti) {
        if (p.getPocetVyher() > pl.getPocetVyher()){
            pl = p;
        }
    }
    for (Pilot p : piloti) {
        if (p.getPocetVyher() == pl.getPocetVyher()){
            System.out.println(p);
        }
    }
    System.out.println("\nVek nejmladsiho pilota:");
    Pilot pl1 =  piloti.get(0);
    for (Pilot p : piloti) {
        if (p.getPocetVyher() < pl.getPocetVyher()){
            pl1 = p;
        }
    }
    System.out.println(pl1);
    System.out.println("\nTypy lodí podle počtu výskytů (sestupně):");

    piloti.stream()
            .collect(Collectors.groupingBy(Pilot::getTypLodi, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

}
