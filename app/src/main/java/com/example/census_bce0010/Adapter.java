//package com.example.census_bce0010;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//public class Adapter {
//    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//
//        private Context context;
//        private ArrayList name_id, age_id, gender_id;
//
//        public MyAdapter(Context context, ArrayList name_id, ArrayList age_id, ArrayList gender_id) {
//            this.context = context;
//            this.name_id = name_id;
//            this.age_id = age_id;
//            this.gender_id = gender_id;
////        this.img_id = img_id;
//        }
//
//        public void Adapter() {
//        }
//
//        @NonNull
//        @Override
//        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
//            return new MyViewHolder(v);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
////        final ColorSpace.Model model = modelArrayList.get(position);
////        byte[]image = model.getImg();
////        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
////        holder.img_id.setImageBitmap(bitmap);
//            holder.name_id.setText(String.valueOf(name_id.get(position)));
//            holder.age_id.setText(String.valueOf(age_id.get(position)));
//            holder.gender_id.setText(String.valueOf(gender_id.get(position)));
//        }
//
//        @Override
//        public int getItemCount() {
//            return name_id.size();
//        }
//
//        public class MyViewHolder extends RecyclerView.ViewHolder {
//
//            TextView name_id, age_id, gender_id;
//            ImageView img_id;
//
//            public MyViewHolder(@NonNull View itemView) {
//
//                super(itemView);
//
//                name_id = itemView.findViewById(R.id.textname);
//                age_id = itemView.findViewById(R.id.textage);
//                gender_id = itemView.findViewById(R.id.textgender);
////            img_id = itemView.findViewById(R.id.);
//            }
//        }
//    }
//}
