
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\winutils")

    val conf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val input = sc.textFile("C:\\Users\\m4singh\\Documents\\Logs\\ZipFileData\\test\\test\\201710123420\\201710123420\\Alarm_system\\BSC_Alarm_history.txt")
    val words = input.flatMap(line => line.split(" "))
    val count = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
    count.foreach( a => println(a))
  }
}
