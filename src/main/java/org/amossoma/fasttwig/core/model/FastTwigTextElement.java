package org.amossoma.fasttwig.core.model;

import java.util.Objects;

public class FastTwigTextElement implements FastTwigElement {

    private final String text;

    public FastTwigTextElement(String text) {
        this.text = text;
    }

    @Override
    public String render(FastTwigContext context) {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastTwigTextElement that = (FastTwigTextElement) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "FastTwigTextElement{" +
                "text='" + text + '\'' +
                '}';
    }
}
