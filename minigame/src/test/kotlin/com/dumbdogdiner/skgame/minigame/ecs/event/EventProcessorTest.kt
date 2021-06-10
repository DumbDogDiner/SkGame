/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.ecs.event

import com.dumbdogdiner.skgame.minigame.annotation.Component
import com.dumbdogdiner.skgame.minigame.event.ComponentChangeEvent
import com.dumbdogdiner.skgame.minigame.event.EntityCreateEvent
import com.dumbdogdiner.skgame.minigame.event.EventListener
import com.dumbdogdiner.skgame.minigame.event.EventProcessor
import com.dumbdogdiner.skgame.minigame.event.Listener
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Component
internal class ScoreComponent {
    val score = 0
}

internal class EventProcessorTest {
    private val processor = EventProcessor()

    @Test
    fun testAddListener() {
        val listener = object : Listener {
            @EventListener
            fun onComponentChange(e: ComponentChangeEvent<ScoreComponent>) {
            }
        }
        // register listener
        processor.registerListener(listener)
    }

    @Test
    fun testFireEvent() {

        // register listener
        val listener = object : Listener {
            var participantDidFire = false
            var notParticipantDidFire = false

            @EventListener
            fun onParticipantCreate(e: EntityCreateEvent) {
                participantDidFire = true
            }

            @EventListener
            fun onNotParticipantCreate(e: EntityCreateEvent) {
                notParticipantDidFire = false
            }
        }
        processor.registerListener(listener)
        // call event
        processor.call(entityCreateEvent)
        // make assertions
        Assertions.assertTrue(listener.participantDidFire)
        Assertions.assertFalse(listener.notParticipantDidFire)
    }
}
