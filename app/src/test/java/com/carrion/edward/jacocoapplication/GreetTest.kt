package com.carrion.edward.jacocoapplication

import junit.framework.Assert.assertEquals
import org.junit.Test

class GreetTest {

    @Test
    fun greeting() {
        assertEquals(Greet.greeting("Edward"), ("Hello Edward"))
    }
    @Test
    fun greeting2() {
        assertEquals(Greet.greeting2("Edward"), ("Hello Edward."))
    }
    @Test
    fun greeting3() {
        assertEquals(Greet.greeting3("Edward"), ("Hello Edward;"))
    }
}