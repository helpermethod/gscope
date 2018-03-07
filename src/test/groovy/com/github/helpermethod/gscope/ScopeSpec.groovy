package com.github.helpermethod.gscope

import spock.lang.Specification

class ScopeSpec extends Specification {
    def 'apply should call the specified closure with value as its delegate and return this'() {
        expect:
        [lang: 'Groovy'].apply { put 'attribute', 'rocks' } == [lang: 'Groovy', attribute: 'rocks']
    }

    def 'also should call the specified closure with this as its argument and return this'() {
        expect:
        [lang: 'Groovy'].also { it.put 'attribute', 'rocks' } == [lang: 'Groovy', attribute: 'rocks']
    }

    def 'let should call the specified closure with this as its argument and return its result'() {
        expect:
        [lang: 'Groovy'].let { it + [attribute: 'rocks'] } == [lang: 'Groovy', attribute: 'rocks']
    }
}