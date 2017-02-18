package org.amossoma.fasttwig.core.model;

import java.util.Objects;

public class FastTwigEchoElement implements FastTwigElement {

    private final FastTwigElement fastTwigElement;

    public FastTwigEchoElement(FastTwigElement fastTwigElement) {
        this.fastTwigElement = fastTwigElement;
    }

    @Override
    public String render(FastTwigContext context) {
        return fastTwigElement.render(context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastTwigEchoElement that = (FastTwigEchoElement) o;
        return Objects.equals(fastTwigElement, that.fastTwigElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fastTwigElement);
    }

    @Override
    public String toString() {
        return "FastTwigEchoElement{" +
                "fastTwigElement=" + fastTwigElement +
                '}';
    }

}
