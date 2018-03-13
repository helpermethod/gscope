package com.github.helpermethod.gscope

import spock.lang.Specification

class ScopeSpec extends Specification {
    def 'apply calls the specified closure with this value as its delegate and returns this'() {
        expect:
        [lang: 'Groovy'].apply { put 'attribute', 'rocks' } == [lang: 'Groovy', attribute: 'rocks']
    }

    def 'also calls the specified closure with this as its argument and returns this'() {
        expect:
        [lang: 'Groovy'].also { it.put 'attribute', 'rocks' } == [lang: 'Groovy', attribute: 'rocks']
    }

    def 'let calls the specified closure with this as its argument and returns its result'() {
        expect:
        [lang: 'Groovy'].let { it.size() } == 1
    }

    def 'run call the specified closure with this value as its delegate and returns its result'() {
        expect:
        [lang: 'Groovy'].run { size() } == 1
    }
}