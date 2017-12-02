package ar.edu.unq.cpi.monsters.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ar.edu.unq.cpi.monsters.R;
import ar.edu.unq.cpi.monsters.data.MonsterDataProvider;
import ar.edu.unq.cpi.monsters.tools.ApplicationToolset;

public class Bandas extends AppCompatActivity {

    private ListView listView;
    private BandasListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandas);
        ApplicationToolset.setContext(this);

        this.listView = this.findViewById(R.id.listaDeBandas);

        MonsterDataProvider.api(this.getApplicationContext()).fetchBandNames((data) -> {
            this.listAdapter = new BandasListAdapter(this, data);
            this.listView.setAdapter(this.listAdapter);
        });
    };
}
