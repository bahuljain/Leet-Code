public class BullsCows {
    public String getHint(String secret, String guess) {
        int c = 0, b = 0;

        Map<String, Long> m = Stream
                .of(secret.split(""))
                .collect(Collectors.groupingBy(String::toString,
                                Collectors.counting()));

        for (int i = 0; i < secret.length(); i++) {
            String s = secret.charAt(i) + "";
            String g = guess.charAt(i) + "";

            if (s.equals(g)) {
                if (m.get(s) == 0) {
                    c--;
                } else {
                    Long l = m.get(s);
                    l--;
                    m.put(s, l);
                }
                b++;
                continue;
            }

            if (!m.containsKey(g)) continue;

            if (m.get(g) > 0) {
                c++;
                Long l = m.get(g);
                l--;
                m.put(g, l);
            }
        }

        return b + "A" + c + "B";

    }
}
