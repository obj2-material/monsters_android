package ar.edu.unq.cpi.monsters.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Carlos on 01/12/2017.
 */

public class FixedMonsterDataProvider extends MonsterDataProvider {
    @Override
    public void fetchBandNames(MonsterBandListConsumer consumer) {
        List<String> names = Arrays.asList("Soda Stereo", "Divididos", "Molotov", "Los tipitos");
        consumer.accept(names);
    }
}
