package org.amossoma.fasttwig.core.model;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class FastTwigVariableElement implements FastTwigElement {

    private final String variableName;

    public FastTwigVariableElement(String variableName) {
        this.variableName = StringUtils.strip(variableName);
    }

    @Override
    public String render(FastTwigContext context) {
        return render(context.getVariable(variableName));
    }

    private final String render(Object object) {
        return object.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastTwigVariableElement that = (FastTwigVariableElement) o;
        return Objects.equals(variableName, that.variableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName);
    }

    @Override
    public String toString() {
        return "FastTwigVariableElement{" +
                "variableName='" + variableName + '\'' +
                '}';
    }

}
