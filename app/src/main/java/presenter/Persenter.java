package presenter;

import java.util.ArrayList;
import java.util.List;

import Bean.Data;
import ivew.Ivew;
import mouder.Callback;
import mouder.Mouder;

public class Persenter implements IPersenter {

    private final Mouder mouder;
    Ivew ivew;

    public Persenter(Ivew ivew) {
        this.ivew = ivew;
        mouder = new Mouder();
    }

    @Override
    public void p_datapresenter() {
        mouder.m_datalist(new Callback() {
            @Override
            public void c_callback(List<Data.ResultsEntity> results) {
                ivew.v_datalist((ArrayList<Data.ResultsEntity>) results);
            }
        });
    }
}
