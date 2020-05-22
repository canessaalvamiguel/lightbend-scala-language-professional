package com.lightbend.training.scalatrain

class JourneyPlanner(trains: Set[Train]){
    val stations: Set[Station] = trains.flatMap(_.stations)
}