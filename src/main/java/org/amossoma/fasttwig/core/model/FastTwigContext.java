package org.amossoma.fasttwig.core.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class FastTwigContext {

    private final ConcurrentHashMap<String, Object> variables;

    public FastTwigContext(ConcurrentHashMap<String, Object> variables) {
        this.variables = variables;
    }

    public Object getVariable(String variableName) {
        return variables.get(variableName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastTwigContext that = (FastTwigContext) o;
        return Objects.equals(variables, that.variables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variables);
    }

    @Override
    public String toString() {
        return "FastTwigContext{" +
                "variables=" + variables +
                '}';
    }

}
