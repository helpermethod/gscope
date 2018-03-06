package com.github.helpermethod.gscope

import groovy.transform.CompileStatic
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam

@CompileStatic
class Scope {
    static <T, U> T apply(T self, @DelegatesTo(type = 'T') Closure<U> block) {
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