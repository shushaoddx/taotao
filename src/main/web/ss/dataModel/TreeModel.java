package ss.dataModel;

/*
树形结构类
 */
public class TreeModel {

    private Long id;

    private String text;

    private String state;

    public TreeModel() {
    }

    public TreeModel(Long id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TreeModel{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
