
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col


object DataFrame {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\winutils")

    val spark = SparkSession.builder().appName("DataFrame").master("local").getOrCreate()
    val df = spark.read.format("csv").option("header", "true").load("C:\\Users\\m4singh\\Documents\\Logs\\Sample Dashboard\\test_sample.csv")
    println(df.show(10))

    val columnNames = df.columns
    println(columnNames)

    val columns = Array[String]("id", "severity", "msg_type", "Identifier", "error_msg", "day", "month", "no_col")
    val colNames = columns.map(name => col(name))
    println(colNames)

    val dfEdited = df.select(colNames:_*)
    println(dfEdited.show(10))

  }
}
