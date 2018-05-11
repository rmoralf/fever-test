package com.rodrigomoral.fever.model

import java.util.*

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

data class CrewData(val crewId: Int, val position: Int, val race: String)

fun generateRandomCrewMember(crewId: Int): CrewData {
    val rand = Random()
    val position = rand.nextInt(3)

    val raceId = rand.nextInt(3)
    val race = when (raceId) {
        0 -> "Human"
        1 -> "Betazoid"
        else -> "Vulcan"
    }
    return CrewData(crewId, position, race)
}

fun determineMultiplier(position: Int, race: String): String {
    return when (position) {
        0 -> { //Command
            when (race) {
                "Human" -> "x3"
                "Betazoid" -> "x1"
                else -> "x2" //Vulcan
            }
        }
        1 -> { //Science
            when (race) {
                "Human" -> "x1"
                "Betazoid" -> "x2"
                else -> "x3" //Vulcan
            }
        }
        else -> { //Engineering
            when (race) {
                "Human" -> "x2"
                "Betazoid" -> "x3"
                else -> "x1" //Vulcan
            }
        }
    }
}
