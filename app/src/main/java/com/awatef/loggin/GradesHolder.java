package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GradesHolder extends RecyclerView.ViewHolder{


    TextView names;
    TextView quiz1;
    TextView quiz2;
    TextView mid;

    public GradesHolder(@NonNull View itemView) {
        super(itemView);
        names = (TextView) itemView.findViewById(R.id.names);
        quiz1 = (TextView) itemView.findViewById(R.id.q1);
        quiz2 = (TextView) itemView.findViewById(R.id.q2);
        mid = (TextView) itemView.findViewById(R.id.mid);
    }
}