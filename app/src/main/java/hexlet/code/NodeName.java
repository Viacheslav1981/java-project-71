package hexlet.code;

public final class NodeName {

    private String key;
    private Object value;
    private Object updatedValue;
    private NodeStatus type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getUpdatedValue() {
        return updatedValue;
    }

    public void setUpdatedValue(Object updatedValue) {
        this.updatedValue = updatedValue;
    }

    public NodeStatus getType() {
        return type;
    }

    public void setType(NodeStatus type) {
        this.type = type;
    }
}
