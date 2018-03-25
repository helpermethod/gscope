package com.github.helpermethod.gscope

import groovy.transform.EqualsAndHashCode
import spock.lang.Specification

class ScopeSpec extends Specification {
    def '`apply` calls the specified closure with `this` value as its delegate and returns `this`'() {
        expect:
        new Person().apply {
            firstName = 'Ash'
            lastName = 'Williams'
        } == new Person(firstName: 'Ash', lastName: 'Williams')
    }

    def '`also` calls the specified closure with `this` as its argument and returns `this`'() {
        expect:
        new Person().also {
            it.firstName = 'Ash'
            it.lastName = 'Williams'
        } == new Person(firstName: 'Ash', lastName: 'Williams')
    }

    def '`let` calls the specified closure with `this` as its argument and returns its result'() {
        expect:
        new Person(firstName: 'Ash', lastName: 'Williams').let { "$it.firstName $it.lastName"} == 'Ash Williams'
    }

    def '`run` calls the specified closure with `this` value as its delegate and returns its result'() {
        expect:
        new Person(firstName: 'Ash', lastName: 'Williams').run { "$firstName $lastName" } == 'Ash Williams'
    }

    @EqualsAndHashCode
    static class Person {
        String firstName
        String lastName

        def firstName(String firstName) {
            apply { this.firstName = firstName }
        }
    }
}