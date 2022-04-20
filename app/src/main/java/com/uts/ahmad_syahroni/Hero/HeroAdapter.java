package com.uts.ahmad_syahroni.Hero;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uts.ahmad_syahroni.R;

import java.util.ArrayList;


//File HeroAdapter berfungsi sebagai adapter atau penghubung antara Data Hero dan Model Hero,
// file ini berisi semua perintah untuk mengambil dan mengeksekusi data yang berada pada HeroData melalui Model yang telah dibuat pada Hero Model

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ListViewHolder> {
    //mendeklarasikan Model sebagai ArrayList
    private ArrayList<HeroModel> listHero;

    //Constructor untuk membuat default data pada ArrayList
    public HeroAdapter(ArrayList<HeroModel> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public HeroAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //menghubungkan View list_item kepada Parent atau yang menuruninya.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ListViewHolder holder, int position) {
        HeroModel heroModel = listHero.get(position);

        //penggunaan Librrarry Glide untuk images porcessing agar dapat menamiplkan images dari HeroData
        Glide.with(holder.itemView.getContext())

                .load(heroModel.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgHero);

        holder.tvHero.setText(heroModel.getNama());
        holder.tvKet.setText(heroModel.getDetail());

        //click Listener untuk setiap aksi list
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaHero = heroModel.getNama();
                //Toast Text untuk menampilkan Toast Keterangan dan nama Pahlawan
                Toast.makeText(holder.itemView.getContext(), "Anda Memilih Pahlawan " + namaHero , Toast.LENGTH_SHORT).show();
                //fungsi membuka Alert dialog
                openAlertDialog(v);
            }

            ////fungsi Alert dialog untuk membuat alert dimana fungsi tsb memiliki parameter view sebagai umpan baliknya
            private void openAlertDialog(View view) {
                int heroImg = heroModel.getPhoto();
                String namaHero = heroModel.getNama();
                String ketHero = heroModel.getDetail();
                Context context = view.getContext();

                //deklarasi alert dialog
                AlertDialog show = new AlertDialog.Builder(context)
                        .setIcon(heroImg)
                        .setTitle(namaHero)
                        .setMessage(ketHero)
                        .show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    //Class holder untuk mengambil data dari ViewHolder
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHero;
        TextView tvHero, tvKet;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHero = itemView.findViewById(R.id.img_hero);
            tvHero = itemView.findViewById(R.id.tv_item_name);
            tvKet = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
