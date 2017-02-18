package org.amossoma.fasttwig.core.parser

import org.amossoma.fasttwig.core.model.FastTwigEchoElement
import org.amossoma.fasttwig.core.model.FastTwigTemplate
import org.amossoma.fasttwig.core.model.FastTwigTextElement
import org.amossoma.fasttwig.core.model.FastTwigVariableElement
import spock.lang.Specification
import spock.lang.Unroll

class FastTwigParserTest extends Specification {

    @Unroll
    "should parse text \"#text\" to template"() {
        given:
        def fastTwigParser = new FastTwigParser();

        when:
        def result = fastTwigParser.parse(text)

        then:
        result == new FastTwigTemplate(fastTwigElements)

        where:
        text                  || fastTwigElements
        "test"                || [new FastTwigTextElement("test")]
        "{{  abc   }}"        || [new FastTwigEchoElement(new FastTwigVariableElement("abc"))]
        "TEST1{{ abc }}TEST2" || [new FastTwigTextElement("TEST1"), new FastTwigEchoElement(new FastTwigVariableElement("abc")), new FastTwigTextElement("TEST2")]
    }

}
