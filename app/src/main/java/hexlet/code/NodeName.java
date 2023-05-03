package hexlet.code;

public final class NodeName {
    private final NodeStatus type;
    private final String key;
    private Object value;
    private final Object updatedValue;

    public NodeName(NodeStatus type, String key, Object value, Object updatedValue) {
        this.type = type;
        this.key = key;
        this.value = value;
        this.updatedValue = updatedValue;
    }

    public String getKey() {
        return key;
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

    public NodeStatus getType() {
        return type;
    }

}
