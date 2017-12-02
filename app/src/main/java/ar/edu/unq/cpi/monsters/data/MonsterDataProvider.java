package ar.edu.unq.cpi.monsters.data;

import android.content.Context;

import java.util.List;

/**
 * Created by Carlos on 01/12/2017.
 */

public abstract class MonsterDataProvider {
    private static FixedMonsterDataProvider fixedInstance;
    private static ApiMonsterDataProvider apiInstance;

    private Context context;

    public static FixedMonsterDataProvider fixed(Context ctx) {
        if (fixedInstance == null) { fixedInstance = new FixedMonsterDataProvider (); }
        fixedInstance.setContext(ctx);
        return fixedInstance;
    }

    public static ApiMonsterDataProvider api(Context ctx) {
        if (apiInstance == null) { apiInstance = new ApiMonsterDataProvider (); }
        apiInstance.setContext(ctx);
        return apiInstance;
    }

    public void setContext(Context ctx) { this.context = ctx.getApplicationContext(); }
    public Context getContext() { return this.context; }

    public abstract void fetchBandNames(MonsterBandListConsumer consumer);
}
