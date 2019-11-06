package ss.dataModel;

import java.util.List;

public class DatagridModel {
    /*总数*/
    private long total;
    /*具体的数据集合*/
    private List<?> rows;

    public DatagridModel(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DatagridModel{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
