import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import org.apache.log4j.Logger
import twitter4j._

object MainApp {
  def main(args: Array[String]): Unit = {
    val consumerKey: String = "id9H9aV9Qcx1KD9bqV5CQnfUO"
    val consumerSecret: String = "e0K15rYqNVQCMt9gJNsJ8HeiyfAekokikfu7XSNii4dRrPkoID"
    val accessToken: String = "958655174049869824-53T6iqUxr5ubLhS9MWlwR76Z8NIRwJp"
    val accessTokenSecret: String = "F1TR3n4H5yajlrANeePwn0ZkDBAwT2lM5h8rJ0yxpQuZ7"

    val log = Logger.getLogger(this.getClass)
    val twitter = TwitterConnectionFactory.getInstance(consumerKey, consumerSecret, accessToken, accessTokenSecret)
    val getResultsFor: String = "#knoldus"
    val statuses: Future[List[Status]] = Operations.printTweets(twitter,getResultsFor)/*.map(list => list)*/

    Thread.sleep(10000)
    log.info(s"Tweets on the hash tag $getResultsFor are : ${statuses.map(list => list.map(status =>s" ${status.getText} \n"))}")
 //   log.info(s"Total tweets on the trend $getResultsFor is ${Operations.getTweetCount(twitter,getResultsFor)} \n")
  //  log.info(s"Average tweets in 10 days are ${Operations.averageTweets(twitter,getResultsFor)} \n")

  }
}
