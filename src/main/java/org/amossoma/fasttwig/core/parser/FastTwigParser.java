package org.amossoma.fasttwig.core.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.amossoma.fasttwig.core.model.FastTwigEchoElement;
import org.amossoma.fasttwig.core.model.FastTwigElement;
import org.amossoma.fasttwig.core.model.FastTwigTemplate;
import org.amossoma.fasttwig.core.model.FastTwigTextElement;
import org.amossoma.fasttwig.core.model.FastTwigVariableElement;

public class FastTwigParser {

    public FastTwigTemplate parse(String templateText) {
        List<FastTwigElement> elements = new ArrayList<>();
        int previousIndex = 0;

        for (int i = 0 ; i < templateText.length() ; i++) {
            if (i < templateText.length() - 1 && templateText.charAt(i) == '{' && templateText.charAt(i + 1) == '{') {
                if (previousIndex != i) {
                    elements.add(new FastTwigTextElement(templateText.substring(previousIndex, i)));
                }
                previousIndex = i++;
            }
            if (i < templateText.length() - 1 && templateText.charAt(i) == '}' && templateText.charAt(i + 1) == '}') {
                elements.add(new FastTwigEchoElement(parseEchoElement(templateText.substring(previousIndex + 2, i))));
                previousIndex = i+=2;
            }
        }

        if (previousIndex != templateText.length()) {
            elements.add(new FastTwigTextElement(templateText.substring(previousIndex, templateText.length())));
        }

        return new FastTwigTemplate(elements);
    }

    private FastTwigElement parseEchoElement(String substring) {
        return new FastTwigVariableElement(substring);
    }

}
