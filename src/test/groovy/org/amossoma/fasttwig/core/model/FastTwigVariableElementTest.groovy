package org.amossoma.fasttwig.core.model

import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap

class FastTwigVariableElementTest extends Specification {


    def "should render given variable"() {
        given:
        def fastTwigVariableElement = new FastTwigVariableElement("var")
        def fastTwigContext = new FastTwigContext(new ConcurrentHashMap(['var': 'test']))

        when:
        def result = fastTwigVariableElement.render(fastTwigContext)

        then:
        result == "test"
    }

}
