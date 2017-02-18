package org.amossoma.fasttwig.core.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FastTwigTemplate {

    private final List<FastTwigElement> fastTwigElementList;

    public FastTwigTemplate(List<FastTwigElement> fastTwigElementList) {
        this.fastTwigElementList = fastTwigElementList;
    }

    public String render(FastTwigContext context) {
        return fastTwigElementList.stream().map(element -> element.render(context)).collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastTwigTemplate that = (FastTwigTemplate) o;
        return Objects.equals(fastTwigElementList, that.fastTwigElementList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fastTwigElementList);
    }

    @Override
    public String toString() {
        return "FastTwigTemplate{" +
                "fastTwigElementList=" + fastTwigElementList +
                '}';
    }

}
