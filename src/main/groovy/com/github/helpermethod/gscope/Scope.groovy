package com.github.helpermethod.gscope

import groovy.transform.CompileStatic
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam

import static groovy.lang.Closure.DELEGATE_FIRST

@CompileStatic
class Scope {
    static <T, U> T apply(T self, @DelegatesTo(type = 'T', strategy = DELEGATE_FIRST) Closure<U> block) {
        block.delegate = self
        block()
        self
    }

    static <T, U> T also(T self, @ClosureParams(FirstParam) Closure<U> block) {
        block self
        self
    }

    static <T, U> U let(T self, @ClosureParams(FirstParam) Closure<U> block) {
        block self
    }
}