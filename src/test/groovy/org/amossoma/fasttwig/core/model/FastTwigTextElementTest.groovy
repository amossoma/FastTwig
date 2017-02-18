package org.amossoma.fasttwig.core.model

import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap


class FastTwigTextElementTest extends Specification {

    def "should render given text"() {
        given:
        def fastTwigTextElement = new FastTwigTextElement("test")
        def fastTwigContext = new FastTwigContext(new ConcurrentHashMap())

        when:
        def result = fastTwigTextElement.render(fastTwigContext)

        then:
        result == "test"
    }

}
