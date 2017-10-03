// !LANGUAGE: +CallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

import kotlin.internal.contracts.*

inline fun <T> myRun(block: () -> T): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

fun throwInLambda(): Int {
    <!UNREACHABLE_CODE!>val <!UNUSED_VARIABLE!>x<!> =<!> myRun { throw java.lang.IllegalArgumentException(); <!UNREACHABLE_CODE!>42<!> }
    <!UNREACHABLE_CODE!>return x<!>
}