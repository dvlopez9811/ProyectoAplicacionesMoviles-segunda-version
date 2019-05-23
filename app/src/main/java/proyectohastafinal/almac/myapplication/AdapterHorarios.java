package proyectohastafinal.almac.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import proyectohastafinal.almac.myapplication.model.BusquedaSalonDeBelleza;
import proyectohastafinal.almac.myapplication.model.Horario;
import proyectohastafinal.almac.myapplication.model.Servicio;

public class AdapterHorarios extends RecyclerView.Adapter<AdapterHorarios.CustomViewHolder> {

    ArrayList<Horario> horarios;


    public AdapterHorarios(){
        horarios = new ArrayList<>();
    }
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.renglon_horario_disponible, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout root;

        public CustomViewHolder(LinearLayout v) {
            super(v);
            root = v;
        }
    }

    public void showAllHorarios(ArrayList<Horario> allhorarios) {
        for(int i = 0 ; i<allhorarios.size() ; i++){
            if(!horarios.contains(allhorarios.get(i))) horarios.add(allhorarios.get(i));
        }
        notifyDataSetChanged();
    }
    public int getItemCount() {
        return horarios.size();
    }

    public void onBindViewHolder(@NonNull final CustomViewHolder holder, final int position) {
        ((TextView) holder.root.findViewById(R.id.hora_inicio_item_horarios)).setText(horarios.get(position).getHoraInicio());
        ((TextView) holder.root.findViewById(R.id.hora_fin_item_horarios)).setText(horarios.get(position).getHoraFinal());
        holder.root.findViewById(R.id.item_renglon_horario_disponible).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(horarios.get(position));
            }
        });

    }

    //OBSERVER
    public interface OnItemClickListener{
        void onItemClick(Horario horario);
    }

    private AdapterHorarios.OnItemClickListener listener;

    public void setListener(AdapterHorarios.OnItemClickListener listener){
        this.listener = listener;
    }


}