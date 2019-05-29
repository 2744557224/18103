package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a27445.myapplication.Main2Activity_viewpage;
import com.example.a27445.myapplication.MainActivity;
import com.example.a27445.myapplication.R;

import java.util.ArrayList;

import Bean.Data;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHodler> {
    private ArrayList<Data.ResultsEntity>  arrayList=new ArrayList<>();
    private Context context;
    private onClier onClier;

    public void setOnClier(RlvAdapter.onClier onClier) {
        this.onClier = onClier;
    }

    public RlvAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<Data.ResultsEntity> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, final int i) {
        Glide.with(context).load(arrayList.get(i).getUrl()).into(viewHodler.image);
        viewHodler.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClier.getOnClier(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
    public interface onClier{
        void getOnClier(int i);
    }
}
