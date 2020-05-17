class Time(val hours: Int = 0, val minutes: Int = 0){
    //TODO: Verify that hours is within 0 and 23
    //TODO: comment: Verify that minutes is within 0 and 59
    val asMinutes: Int= hours * 60 + minutes

    def minus(that: Time): Int = asMinutes - that.asMinutes

    def -(that: Time): Int = minus(that)
       
}