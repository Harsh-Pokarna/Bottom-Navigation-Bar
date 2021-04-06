package com.example.bottomnavigationbar;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {
    RecyclerView videoList;
    String[] s1 = {"Episode 1", "Episode 2", "Episode 3", "Episode 4", "Episode 5", "Episode 6", "Episode 7", "Episode 8", "Episode 9"};
    int[] images = {R.drawable.lucifer1, R.drawable.lucifer1, R.drawable.lucifer1, R.drawable.lucifer1
            , R.drawable.lucifer1, R.drawable.lucifer1, R.drawable.lucifer1, R.drawable.lucifer1
            , R.drawable.lucifer1};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Glide.with(this).load(R.drawable.explore).into(img);
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        videoList = view.findViewById(R.id.videosList);
        MyAdapter1 myAdapter1 = new MyAdapter1(getContext(),s1, images);
        videoList.setAdapter(myAdapter1);
        videoList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1>{
    String title[];
    int img[];
    Context context;
    public MyAdapter1(Context ct, String s1[], int images[]){
        this.context = ct;
        this.img = images;
        this.title = s1;

    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.each_block,parent,false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter1.MyViewHolder1 holder, int position) {
        holder.textView.setText(title[position]);
        holder.imageView.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.video_title);
            imageView = itemView.findViewById(R.id.thumbnail);
        }
    }
}