package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionsDto;
import cc.oakk.ladder.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Connections {
    private final List<Connection> connections;

    public Connections(List<Connection> connections) {
        if (connections == null) {
            throw new IllegalArgumentException("주어진 값이 null 입니다.");
        }
        this.connections = new ArrayList<>(connections);
    }

    public boolean isConnected(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);
        return connections.get(index).get();
    }

    public Connections connect(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);
        if (isLeftConnected(index) || isRightConnected(index)) {
            throw new IllegalArgumentException("두번 연속해 이을 수 없습니다.");
        }

        setConnection(index, true);
        return this;
    }

    private boolean isRightConnected(int index) {
        return index != size() - 1 && isConnected(index + 1);
    }

    private boolean isLeftConnected(int index) {
        return index != 0 && isConnected(index - 1);
    }

    public Connections disconnect(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);
        setConnection(index, false);
        return this;
    }

    private void setConnection(int index, boolean value) {
        connections.remove(index);
        connections.add(index, Connection.of(value));
    }

    public ConnectionsDto getDto() {
        return new ConnectionsDto(connections);
    }

    public int size() {
        return connections.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connections that = (Connections) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}