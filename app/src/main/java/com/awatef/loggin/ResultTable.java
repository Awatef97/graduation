package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */

import java.util.List;

public class ResultTable {
    private List<AttendanceTable> table;
    public List<AttendanceTable> getTable(){
        return table;
    }
    public void setTable(List<AttendanceTable> table){
        this.table=table;
    }

}
