package com.github.helpermethod.gscope

import groovy.transform.CompileStatic
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam

import static groovy.lang.Closure.DELEGATE_FIRST

@CompileStatic
class Scope {
    static <T, R> T apply(T self, @DelegatesTo(type = 'T', strategy = DELEGATE_FIRST) Closure<R> block) {
        block.delegate = self
        block()
        self
    }

    static <T, R> T also(T self, @ClosureParams(FirstParam) Closure<R> block) {
        block self
        self
    }

    static <T, R> R let(T self, @ClosureParams(FirstParam) Closure<R> block) {
        block self
    }

    static <T, R> R run(T self, @DelegatesTo(type = 'T', strategy = DELEGATE_FIRST) Closure<R> block) {
        block.delegate = self
        block()
    }
}