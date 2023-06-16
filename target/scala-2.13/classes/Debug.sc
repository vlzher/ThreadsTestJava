class Debug {
  def fields(obj: AnyRef): Unit = {
    val fields = obj.getClass.getDeclaredFields
    fields
      .filter(field => !field.getName.equals("$outer"))
      .foreach(field => {
          field.setAccessible(true)
          println(s"Pole: ${field.getName} => ${field.getType.getName}, ${field.get(obj)}")
      })
  }
}

class Point(var x: Int, var y: Int, var a: String = "test")

val p = new Point(3, 4)
val debug = new Debug
debug.fields(p)