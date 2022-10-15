public class GuitarHero {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        String keyboard = "2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] keys = new GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++) {
            int calc = (int) Math.round((CONCERT_A) * Math.pow(1.05956, i - 24));
            keys[i] = new GuitarString(calc);
        }

        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    keys[keyboard.indexOf(key)].pluck();
                }

            }

            // compute the superposition of the samples

            double sample = 0;

            for (int i = 0; i < keys.length; i++) {
                sample += keys[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < keys.length; i++) {
                keys[i].tic();
            }

        }
    }

}