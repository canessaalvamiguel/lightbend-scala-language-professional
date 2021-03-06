package com.lightbend.training.scalatrain

import scala.collection.Seq

case class Station(name: String)
case class Train(info: TrainInfo, schedule: Seq[(Time, Station)]){

    require(schedule.size >= 2, "Invalid schedule parameter")

    val stations: Seq[Station] =   schedule.map( _._2)

    def timeAt(station: Station): Option[Time] = {
        //schedule.find(timeAndStation => timeAndStation._2 == station).map(timeAndStation => timeAndStation._1)
        schedule.find{
            case (_, needle)  => needle == station
        }.map{
            case (time,_) => time
        }
    }
}

sealed abstract class TrainInfo{
    def number():Int
}

case class InterCityExpress(number: Int, hasWifi: Boolean = false) extends TrainInfo
case class RegionalExpress(number: Int, hasWifi: Boolean) extends TrainInfo
case class BavarianRegional(number: Int, hasWifi: Boolean) extends TrainInfo