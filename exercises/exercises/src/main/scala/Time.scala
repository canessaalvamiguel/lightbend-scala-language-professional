class Time(val hours: Int, val minutes: Int){
    val asMinutes: Int= hours * 60 + minutes
    //TODO: Verify that hours is within 0 and 23
    //TODO: comment: Verify that minutes is within 0 and 59
}