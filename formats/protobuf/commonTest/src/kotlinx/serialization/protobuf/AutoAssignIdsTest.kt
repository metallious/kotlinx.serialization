/*
 * Copyright 2017-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.serialization.protobuf

import kotlinx.serialization.*
import kotlin.test.*

class AutoAssignIdsTest {
    @Serializable
    data class WithoutIds(val a: Int, val b: String)

    @Serializable
    data class WithId(@ProtoId(1) val a: Int, @ProtoId(2) val b: String)

    @Test
    fun saveAndRestoreWithoutIds() {
        val w1 = WithoutIds(1, "foo")
        val bytes = ProtoBuf.dump(WithoutIds.serializer(), w1)
        val w2 = ProtoBuf.load(WithoutIds.serializer(), bytes)
        assertEquals(w1, w2)
    }

    @Test
    fun incrementalIds() {
        val w1 = WithoutIds(1, "foo")
        val bytes = ProtoBuf.dump(WithoutIds.serializer(), w1)
        val w2 = ProtoBuf.load(WithId.serializer(), bytes)
        assertEquals(w1.a, w2.a)
        assertEquals(w1.b, w2.b)
    }
}
