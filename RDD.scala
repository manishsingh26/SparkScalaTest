
import org.apache.spark.sql.SparkSession

object RDD {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\winutils")

    val spark = SparkSession.builder().appName("RDD").master("local").getOrCreate()
    val data = spark.read.textFile("C:\\Users\\m4singh\\Documents\\Logs\\Sample Dashboard\\test_sample.csv")
    data.foreach(row => println(row))
  }
}
