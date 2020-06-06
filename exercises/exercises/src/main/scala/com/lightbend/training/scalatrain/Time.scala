package com.lightbend.training.scalatrain

import play.api.libs.json._
import scala.util.{Try}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time]{
    //TODO: Verify that hours is within 0 and 23
    //TODO: comment: Verify that minutes is within 0 and 59

    require(hours >= 0 && hours <= 23, "Invalid hours parameter")
    require(minutes >= 0 && minutes <= 59, "Invalid minutes parameter")

    val asMinutes: Int= hours * 60 + minutes

    def minus(that: Time): Int = asMinutes - that.asMinutes

    def -(that: Time): Int = minus(that)

    override lazy val toString: String = f"$hours%02d:$minutes%02d"

    override def compare(that: Time): Int = this.asMinutes - that.asMinutes

    def toJson: JsValue = JsObject(
        Map("hours" -> JsNumber(hours), "minutes" -> JsNumber(minutes))
    )
       
}

object Time{
    def fromMinutes(m: Int): Time = {
        val hours = m / 60
        val minutes = m % 60
        
        Time(hours, minutes)
    }

    def fromJson(js: JsValue): Option[Time] = {
        for{
            hours <- Try((js \ "hours").as[Int])
            minutes <- Try((js \ "minutes").as[Int]).recover{ case _ => 0}
        } yield Time(hours, minutes)   
    }.toOption
}
