
import org.apache.spark.sql.SparkSession


object ElasticData {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\winutils")

    val spark = SparkSession.builder().appName("DataFrameElastic").master("local").getOrCreate()
    val df = spark.read.format("org.elasticsearch.spark.sql")
                        .option("pushdown", "true")
                        .option("es.nodes", "localhost:9200")
                        .load("log_file_hyperlinking_keys/log")
    df.show(10)

  }
}
