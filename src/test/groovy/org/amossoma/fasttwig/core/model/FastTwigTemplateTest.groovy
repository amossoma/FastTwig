package org.amossoma.fasttwig.core.model

import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap

class FastTwigTemplateTest extends Specification {

    def "should render concatenate of subelements renders"() {
        given:
        def fastTwigContext = new FastTwigContext(new ConcurrentHashMap())
        def fastTwigTemplate = new FastTwigTemplate([new FastTwigTextElement("0123"), new FastTwigTextElement("4567")]);

        when:
        def result = fastTwigTemplate.render(fastTwigContext)

        then:
        result == "01234567"
    }

}
