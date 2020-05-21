package com.lightbend.training.scalatrain

import scala.collection.Seq

case class Station(name: String)
case class Train(kind: String, number: Int, schedule: Seq[Station]){
    require(schedule.size >= 2, "Invalid schedule parameter")
}